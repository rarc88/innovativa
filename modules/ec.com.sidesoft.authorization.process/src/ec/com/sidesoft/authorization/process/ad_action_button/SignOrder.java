/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2011 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  __________Santiago Recalde_________________________.
 ************************************************************************
 */
package ec.com.sidesoft.authorization.process.ad_action_button;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.application.attachment.AttachImplementationManager;
import org.openbravo.client.application.attachment.AttachmentAH;
import org.openbravo.client.application.attachment.AttachmentUtils;
import org.openbravo.client.application.attachment.CoreAttachImplementation;
import org.openbravo.base.weld.WeldUtils;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProviderImpl;
import org.openbravo.utils.CryptoUtility;
import org.openbravo.dal.service.OBCriteria;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.sql.*;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openbravo.model.ad.utility.Attachment;
import org.hibernate.criterion.Restrictions;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.dal.core.OBContext;

import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.order.Order;
import ec.com.sidesoft.authorization.process.AuthorizationLevel;
import ec.com.sidesoft.authorization.process.ReasonRejection;

import ec.com.sidesoft.authorization.process.ad_action_button.AuthorizeLevel;

public class SignOrder extends BaseActionHandler {

	// System.out.println("share another class: "+AuthorizeLevel.testDemo());

	private static final Logger log = Logger.getLogger(SignOrder.class);

	// protected static final String BASEURL = "http://186.69.209.150:25414/";
	protected static final String BASEURL = "http://192.168.1.143:5000/";

	final String attachmentFolderPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
			.getProperty("attach.path");
	public String tadFinal = "";
	public String tableFinal = "";
	public ReasonRejection reasonrejection = null;


	@Override
	protected JSONObject execute(Map<String, Object> parameters, String data) {

		try {
			final JSONObject jsonData = new JSONObject(data);
			final JSONArray orderIds = jsonData.getJSONArray("orders");
			final String action = jsonData.getString("action");
			tadFinal = jsonData.getString("tad");
			tableFinal = jsonData.getString("table");

			AuthorizeLevel authorizelevel = new AuthorizeLevel();

			for (int i = 0; i < orderIds.length(); i++) {
				// get the order
				final Order order = OBDal.getInstance().get(Order.class, orderIds.getString(i));
				getFileID(orderIds.getString(i));
				authorizelevel.createLineAuthorizationLevel(order,order.getEcsapAuthLevel(),reasonrejection);
				order.setEcsapSigned(true);
			}
			JSONObject result = new JSONObject();
			result.put("updated", "Success PDF signed");
			return result;
		} catch (Exception e) {
			throw new OBException(e);
		}
	}

	public String uploadPDFtoSign(String fileName, String lx, String ly, User user) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = "";
		try {
		
			HttpPost httppost = new HttpPost(BASEURL + "signpdf");


			 int CONNECTION_TIMEOUT_MS = 5 * 1000; // Timeout in millis.
				RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
				.setConnectTimeout(CONNECTION_TIMEOUT_MS)
				.setSocketTimeout(CONNECTION_TIMEOUT_MS)
				.build();

			FileBody pdf = new FileBody(new File(fileName));
			// FileBody p12 = new FileBody(new File("pkijs_pkcs12(1).p12"));
			FileBody p12 = new FileBody(new File(getLocationP12File(user.getId())));

			StringBody reason = new StringBody(user.getUsername(), ContentType.TEXT_PLAIN);
			// StringBody reason = new StringBody("Quintana Darwin", ContentType.TEXT_PLAIN);
			StringBody locationX = new StringBody(lx, ContentType.TEXT_PLAIN);
			StringBody locationY = new StringBody(ly, ContentType.TEXT_PLAIN);
			// StringBody password = new StringBody("Kacheadg01", ContentType.TEXT_PLAIN);
			StringBody password = new StringBody(CryptoUtility.decrypt(user.getEcsapSignDigital()), ContentType.TEXT_PLAIN);

			HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("pdf", pdf).addPart("p12", p12)
					.addPart("reason", reason).addPart("pos_x", locationX).addPart("pos_y", locationY)
					.addPart("pwd", password).build();
			
			httppost.setConfig(requestConfig);
			httppost.setEntity(reqEntity);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			responseBody = httpclient.execute(httppost, responseHandler);
			return responseBody;
		} finally {
			httpclient.close();
		}
	}

	public String saveSingedPDF(String filenamesigned, String recordOrderID)
			throws Exception {
		String fileSignCurrent = "";
		String attachPath = CoreAttachImplementation.getAttachmentDirectoryForNewAttachments(tableFinal, recordOrderID);
		String absoluteFileFolderPath = attachmentFolderPath + "/" + attachPath + "/";
		String FileSingPath = attachmentFolderPath + "/" + filenamesigned;

		try (BufferedInputStream inputStream = new BufferedInputStream(
				new URL(BASEURL + "/download/" + filenamesigned).openStream());
			FileOutputStream fileOS = new FileOutputStream(FileSingPath)) {
			byte data[] = new byte[1024];
			int byteContent;
			while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
				fileOS.write(data, 0, byteContent);
			}
			return filenamesigned;
		} catch (IOException e) {
			// handles IO exceptions
		}
		return fileSignCurrent;

	}

	public void uploadFile(String filenamesigned, Attachment attachment, String recordOrderID)
			throws Exception {
				
		try {
			final File pdfSigned = new File(filenamesigned);
			AttachImplementationManager aim = WeldUtils
					.getInstanceFromStaticBeanManager(AttachImplementationManager.class);

			Map<String, String> requestParams = new HashMap<String, String>();
			requestParams.put("E22E8E3B737D4A47A691A073951BBF16", "Documento Firmado");
			aim.upload(requestParams, tadFinal, recordOrderID,
					attachment.getOrganization().getId(), pdfSigned);
		} catch (Exception e) {
			throw new OBException(e);
		}
	}

	public void getFileID(String recordOrderID) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String newFileSign = "";
		String attachPath = CoreAttachImplementation.getAttachmentDirectoryForNewAttachments(tableFinal, recordOrderID);
		String absoluteFileFolderPath = attachmentFolderPath + "/" + attachPath + "/";

		try {
			connection = (new ConnectionProviderImpl(OBPropertiesProvider.getInstance().getOpenbravoProperties()))
					.getConnection();
			try {
				String consulta = "SELECT c_file_id FROM c_file where ad_record_id =? AND c_datatype_id=? AND name NOT LIKE '%signed%' ";
				statement = connection.prepareStatement(consulta);
				statement.setString(1, recordOrderID);
				statement.setString(2, "application/pdf");
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {

					String fileId = resultSet.getString("c_file_id");
					Attachment authorizationlevel = OBDal.getInstance().get(Attachment.class, fileId);
					String fileAttachment = absoluteFileFolderPath + authorizationlevel.getName();

					newFileSign  = listSignatureUser(fileAttachment, recordOrderID);
					uploadFile(newFileSign, authorizationlevel, recordOrderID);
				}
			} finally {
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
			}

		} catch (Exception e) {
			throw new OBException(e);
		}
	}

	public String listSignatureUser (String fileAttachment, String recordOrderID) throws Exception {

	// get List of AuthorizationLevel of order
	OBCriteria<AuthorizationLevel> AuthorizationLevelList = OBDal.getInstance()
						.createCriteria(AuthorizationLevel.class);
		AuthorizationLevelList.addOrderBy(AuthorizationLevel.PROPERTY_VALIDATIONCODE, true);
		// int locationX = 160; 
		// int newlocationX = -140;
		// int locationY = 55; 
		// int locationY = 145; 
		String responseBody = "";
		// Values to 6 or 3 signatures
		String[] sx = new String[]{ "20","180","340","20","180","340" };
		// Values to 5 signatures
		String[] fvx = new String[]{ "20","180","340","90","275" };
		// Values to 4 signatures
		String[] frx = new String[]{ "20","180","340","180"};
		// Values to Y
		String[] y = new String[]{ "145","145","145", "55","55","55" };

		int i = 1;  
		int j = -1;
		for (AuthorizationLevel authorizationlevel : AuthorizationLevelList.list()) {
			final User authorizationUser = OBDal.getInstance().get(User.class,
			authorizationlevel.getUserContact().getId());
			j += i;
			if(AuthorizationLevelList.list().size()<=3){
			responseBody = uploadPDFtoSign(fileAttachment, sx[j], y[3], authorizationUser);
			fileAttachment = saveSingedPDF(responseBody, recordOrderID);
			fileAttachment = renameSignedFIle(fileAttachment, responseBody);
			}
			else if(AuthorizationLevelList.list().size()==4){
			responseBody = uploadPDFtoSign(fileAttachment, frx[j], y[j], authorizationUser);
			fileAttachment = saveSingedPDF(responseBody, recordOrderID);
			fileAttachment = renameSignedFIle(fileAttachment, responseBody);
			}
			else if(AuthorizationLevelList.list().size()==5){
			responseBody = uploadPDFtoSign(fileAttachment, fvx[j], y[j], authorizationUser);
			fileAttachment = saveSingedPDF(responseBody, recordOrderID);
			fileAttachment = renameSignedFIle(fileAttachment, responseBody);
			}
			else{
			responseBody = uploadPDFtoSign(fileAttachment, sx[j], y[j], authorizationUser);
			fileAttachment = saveSingedPDF(responseBody, recordOrderID);
			fileAttachment = renameSignedFIle(fileAttachment, responseBody);
			}
		}
		return	fileAttachment;	
	}

	public String getLocationP12File(String recordUserId) throws OBException {
		OBContext.setAdminMode(true);
		OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
		final Table table = OBDal.getInstance().get(Table.class,
			"114");
		obc.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordUserId));
    	obc.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
		obc.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, "application/x-pkcs12"));
		obc.setFilterOnReadableOrganization(false);
		obc.setMaxResults(1);
		Attachment attach = (Attachment) obc.uniqueResult();
		if (attach == null) {
			return attachmentFolderPath + "/";
		}
		return attachmentFolderPath + "/" + attach.getPath()+'/'+attach.getName();
	}

	public String renameSignedFIle(String oldName,String newName){
		String nameFile = attachmentFolderPath + "/" + newName.replace("-signed-signed.pdf", "-signed.pdf");
		File pdfSigned = new File(attachmentFolderPath + "/" + oldName);
		File renamePDFSigned = new File(nameFile);
		pdfSigned.renameTo(renamePDFSigned);
		return nameFile;
	}

}
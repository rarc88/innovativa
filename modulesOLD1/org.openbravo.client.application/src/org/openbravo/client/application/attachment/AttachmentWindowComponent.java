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
 * All portions are Copyright (C) 2012-2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.client.application.attachment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.application.Parameter;
import org.openbravo.client.application.window.ApplicationDictionaryCachedStructures;
import org.openbravo.client.application.window.OBViewParameterHandler;
import org.openbravo.client.kernel.BaseTemplateComponent;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.client.kernel.Template;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.domain.Validation;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.model.ad.utility.AttachmentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The component which takes care of creating a class for a tab's Attachment popup.
 */
public class AttachmentWindowComponent extends BaseTemplateComponent {
  private static final String DEFAULT_TEMPLATE_ID = "01E447F740584E02BA4612F6BDFB900D";
  private static final Logger log = LoggerFactory.getLogger(AttachmentWindowComponent.class);

  private Boolean inDevelopment = null;
  private String uniqueString = "" + System.currentTimeMillis();
  private Tab tab;
  private AttachmentMethod attMethod;

  @Inject
  private OBViewParameterHandler paramHandler;

  @Inject
  private ApplicationDictionaryCachedStructures adcs;

  protected Template getComponentTemplate() {
    return OBDal.getInstance().get(Template.class, DEFAULT_TEMPLATE_ID);
  }

  /**
   * Gets a String composed by the tabId, attachmentId and if is in development, an unique sequence
   * 
   * @return String sequence generated for this attach
   */
  public String getWindowClientClassName() {
    String baseClassName = KernelConstants.ID_PREFIX + tab.getId() + KernelConstants.ID_PREFIX
        + attMethod.getId();
    if (isIndevelopment()) {
      return baseClassName + KernelConstants.ID_PREFIX + uniqueString;
    }
    return baseClassName;
  }

  /**
   * Compares if the module of the class tab variable is in development
   * 
   * @return True if the module is in development
   */
  public boolean isIndevelopment() {
    if (inDevelopment != null) {
      return inDevelopment;
    }

    // check window, tabs and fields
    inDevelopment = Boolean.FALSE;
    if (tab.getModule().isInDevelopment() && tab.getModule().isEnabled()) {
      inDevelopment = Boolean.TRUE;
    }

    return inDevelopment;
  }

  /**
   * Generates java-script code
   * 
   * @return generated code
   */
  public String generate() {
    final String jsCode = super.generate();
    return jsCode;
  }

  /**
   * Sets the Attachment Method and Tab. Actualizes metadata depending on this tab an attachment
   * method
   * 
   * @param _tab
   *          Tab to set.
   * @param _attMethod
   *          Method to set.
   */
  public void initialize(Tab _tab, AttachmentMethod _attMethod) {
    this.attMethod = _attMethod;
    this.tab = _tab;
    paramHandler.setParameters(getTabMetadataFields());
    paramHandler.setParamWindow(this);
  }

  /**
   * Gets the Attachment Method
   * 
   * @return Attachment Method
   */
  public String getAttachmentMethodId() {
    return attMethod.getId();
  }

  /**
   * Gets the OBViewParameterHandler for this class
   * 
   * @return OBViewParameterHandler injected on this class
   */
  public OBViewParameterHandler getParamHandler() {
    return paramHandler;
  }

  /**
   * Gets the Parent Window of the Attachment component.
   */
  public Window getParentWindow() {
    return tab.getWindow();
  }

  /**
   * Return a JSONObject with all dynamic columns parsed to String.
   * 
   * Dynamic columns is a list of columns that cause others to be modified, it includes the ones
   * causing the modification as well as the affected ones.
   * 
   * Columns are identified as strings surrounded by quotes (" or ') matching one of the names of
   * the parameters.
   * 
   * @return Dynamic columns parsed to string
   */
  public String getDynamicColumns() {
    List<Parameter> paramsWithValidation = new ArrayList<Parameter>();
    List<String> allParams = new ArrayList<String>();
    Map<String, List<String>> dynCols = new HashMap<String, List<String>>();

    for (Parameter param : getTabMetadataFields()) {
      Validation validation = param.getValidation();
      if (validation != null) {
        if (validation.getType().equals("HQL_JS")) {
          paramsWithValidation.add(param);
        } else {
          log.error("Unsupported validation type {} for param {} in tab {}", new Object[] {
              "HQL_JS", param, tab });
        }
      }
      allParams.add(param.getDBColumnName());
    }

    for (Parameter paramWithVal : paramsWithValidation) {
      parseValidation(paramWithVal.getValidation(), dynCols, allParams,
          paramWithVal.getDBColumnName());
    }

    JSONObject jsonDynCols = new JSONObject();

    for (String dynColName : dynCols.keySet()) {
      JSONArray affectedColumns = new JSONArray();
      for (String affectedCol : dynCols.get(dynColName)) {
        affectedColumns.put(affectedCol);
      }
      try {
        jsonDynCols.put(dynColName, affectedColumns);
      } catch (JSONException e) {
        log.error("Error generating dynamic columns for tab {}", tab.getIdentifier(), e);
      }
    }
    return jsonDynCols.toString();
  }

  /**
   * Gets the list of parameters associated to an Attachment Method ad a Tab
   * 
   * @return List of parameters by attachment method and tab
   */
  private List<Parameter> getTabMetadataFields() {
    return adcs.getMethodMetadataParameters(attMethod.getId(), tab.getId());
  }

  private void parseValidation(Validation validation, Map<String, List<String>> dynCols,
      List<String> allParams, String paramName) {
    String token = validation.getValidationCode().replace("\"", "'");

    List<String> columns;

    int i = token.indexOf("'");
    while (i != -1) {
      token = token.substring(i + 1);
      i = token.indexOf("'");
      if (i != -1) {
        String strAux = token.substring(0, i);
        token = token.substring(i + 1);
        columns = dynCols.get(token);

        if (!strAux.equals(paramName) && allParams.contains(strAux)) {
          if (dynCols.containsKey(strAux)) {
            columns = dynCols.get(strAux);
          } else {
            columns = new ArrayList<String>();
            dynCols.put(strAux, columns);
          }
          if (!columns.contains(paramName)) {
            columns.add(paramName);
          }
        }
      }
      if (token.indexOf("'") != -1) {
        token = "'" + token;
      }
      i = token.indexOf("'");
    }
  }
}

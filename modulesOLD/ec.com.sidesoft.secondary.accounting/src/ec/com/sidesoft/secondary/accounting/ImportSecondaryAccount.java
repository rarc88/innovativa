package ec.com.sidesoft.secondary.accounting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.openbravo.base.VariablesBase;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.businessUtility.COAData;
import org.openbravo.erpCommon.businessUtility.InitialSetupUtility;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.ad.utility.TreeNode;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.Element;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValueOperand;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import au.com.bytecode.opencsv.CSVReader;

public class ImportSecondaryAccount extends IdlServiceJava {

  private static final String ACCOUNT_TREE_TABLE_ID = "188";
  private static final String strMessageOk = "Success";
  private static final Logger log4j = Logger.getLogger(ImportSecondaryAccount.class);
  private Element element;
  private Client client;
  private Organization organization;
  Tree accountTree;

  private String filNameToProcess;
  private HashMap<String, ElementValue> defaultElementValues = new HashMap<String, ElementValue>();

  private Tree getAccountTree(Client client) {
    final Table accountTreeTable = OBDal.getInstance().get(Table.class, ACCOUNT_TREE_TABLE_ID);
    try {
      accountTree = InitialSetupUtility.getTree(accountTreeTable, client, null);
    } catch (Exception e) {
      return getAccountTreeSecondary(client, accountTreeTable);
    }

    if (accountTree == null) {
      accountTree = getAccountTreeSecondary(client, accountTreeTable);
    }

    return accountTree;
  }

  private Tree getAccountTreeSecondary(final Client client, final Table accountTreeTable) {

    final Tree treeSecondary = OBProvider.getInstance().get(Tree.class);
    try {
      treeSecondary.setClient(client);
      treeSecondary.setOrganization(OBDal.getInstance().get(Organization.class, "0"));
      treeSecondary.setName(client.getName().concat("  Elemnt Secondary"));
      treeSecondary.setDescription(treeSecondary.getName());
      treeSecondary.setAllNodes(true);
      treeSecondary.setTable(accountTreeTable);
      treeSecondary.setTypeArea("EVS");
      OBDal.getInstance().save(treeSecondary);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      throw new OBException("Error al crear el árbol de cuentas secundario "
          + e.getCause().getMessage(), e.getCause(), true);
    }
    return treeSecondary;
  }

  @Override
  protected boolean executeImport(String filename, boolean insert) throws Exception {

    if (insert) {
      try {
        filNameToProcess = filename;
        client = OBDal.getInstance().get(Client.class, vars.getClient());
        organization = OBDal.getInstance().get(Organization.class, "0");
        accountTree = getAccountTree(client);
        InputStream inputStream = new FileInputStream(filename);
        createElement();
        insertElementValues(vars, inputStream);
      } catch (Exception e) {
        OBDal.getInstance().rollbackAndClose();
        return true;
      }
    } else {
      return executeImportValidator(filename);
    }

    return true;
  }

  private void createElement() throws Exception {
    element = InitialSetupUtility.insertElement(client, organization,
        client.getName().concat(" Secondary"), accountTree, true);
    element.setType("U");
    OBDal.getInstance().save(element);

  }

  private OBError insertElementValues(VariablesBase vars, InputStream fileCoA) {
    OBError obeResult = new OBError();
    obeResult.setType(strMessageOk);

    COAData[] coa;
    try {
      log4j
          .debug("insertElementValues() - Lectura y análisis proporcionados en el Arbol de cuentas..");
      coa = parseCOA(vars, fileCoA);
    } catch (Exception e) {
      throw new OBException("insertElementValues() - ERROR - Excepción en el  archivo de lectura"
          + e.getCause().getMessage(), e.getCause(), true);
    }
    log4j.debug("insertElementValues() - Provided Chart of Accounts read and parsed correctly."
        + " Inserting elements read from file to database.");
    if (coa != null && coa.length != 0) {
      try {
        obeResult = insertElementValuesInDB(coa);
        if (!obeResult.getType().equals(strMessageOk)) {
          return obeResult;
        } else {
          OBDal.getInstance().flush();
        }
      } catch (Exception e) {
        throw new OBException(
            "insertElementValues() - Excepción al guardar valores de elementos leídos del archivo"
                + e.getCause().getMessage());
      }
    } else {
      throw new OBException("insertElementValues() - ERROR - ¡El archivo está vacío!");
    }
    return obeResult;
  }

  private OBError insertElementValuesInDB(COAData[] data) throws Exception {
    OBError obeResult = new OBError();
    obeResult.setType(strMessageOk);
    if (data == null)
      throw new OBException(
          "insertElementValuesInDB() - Ningún elemento proporcionado para ser insertado en la base de datos");

    HashMap<String, String> mapElementValueValue = new HashMap<String, String>();
    // mapElementValueId while store the link value <-> c_elementvalue_id
    HashMap<String, String> mapElementValueId = new HashMap<String, String>();
    // mapParent while store the link value <-> value of the parent
    HashMap<String, String> mapParent = new HashMap<String, String>();
    // mapSequence will store the link value <-> sequence that must be assigned to that node
    // in the ADTreeNode. To start with, root node (value=0) has sequence 0
    HashMap<String, Long> mapSequence = new HashMap<String, Long>();
    mapSequence.put("0", 0L);
    // mapChildSequence will store the link value <-> last sequence assigned to a son-node. To start
    // with, root node (value=0) is initialized to 0
    HashMap<String, Long> mapChildSequence = new HashMap<String, Long>();
    mapChildSequence.put("0", 0L);
    CSVReader reader = getCSVReader(filNameToProcess);
    for (int i = 0; i < data.length; i++) {

      String[] nextLine = reader.readNext();
      finishRecordProcess((Object[]) nextLine);

      log4j.debug("insertElementValuesInDB() - Procesing element in position " + i
          + " with default account " + data[i].getDefaultAccount());

      Boolean IsDocControlled = data[i].getAccountDocument().startsWith("Y");
      Boolean IsSummary = data[i].getAccountSummary().startsWith("Y");
      String C_ElementValue_ID = data[i].getCElementValueId();
      String accountType = setAccountType(data[i]);
      String showValueCond = data[i].getShowValueCond();
      String titleNode = data[i].getTitleNode();
      OBContext.setAdminMode();
      try {
        // String language = OBContext.getOBContext().getLanguage().getLanguage();

        if (!"".equals(showValueCond) && !showValueCond.startsWith("P")
            && !showValueCond.startsWith("N") && !showValueCond.startsWith("A")) {
          showValueCond = null;
        }

        if (!"".equals(titleNode) && !titleNode.startsWith("Y") && !titleNode.startsWith("N")) {
          titleNode = null;
        }

      } finally {
        OBContext.restorePreviousMode();
      }

      if (accountType == null) {
        OBException obException = new OBException(
            "insertElementValuesInDB() - No se pudo establecer el tipo de cuenta para la cuenta ( "
                + data[i].getAccountName() + " ) línea: " + i);

        logRecordError(obException.fillInStackTrace().getMessage(), (Object[]) nextLine);

        throw obException;
      }
      String accountSign = setAccountSign(data[i]);

      log4j.debug("insertElementValuesInDB() - Adding Account: Value: " + data[i].getAccountValue()
          + ". Name: " + data[i].getAccountName() + ". Default: " + data[i].getDefaultAccount()
          + ". C_ElementValue_ID: " + C_ElementValue_ID + ". C_Element_ID: " + element.getId()
          + ". Value: " + data[i].getAccountValue() + ". Name: " + data[i].getAccountName()
          + ". Description: " + data[i].getAccountDescription());

      if (data[i].getAccountValue().equals("")) {
        data[i].setCElementValueId("");
      } else {
        log4j.debug("insertElementValuesInDB() - Inserting element value in database");
        ElementValue elementValue = null;
        if ("".equals(data[i].getAccountName()) || data[i].getAccountName() == null) {
          OBException obException = new OBException(
              "insertElementValuesInDB() - Cuenta encontrada sin nombre,  línea: " + i);
          logRecordError(obException.fillInStackTrace().getMessage(), (Object[]) nextLine);
          throw obException;
        }
        try {
          elementValue = InitialSetupUtility.insertElementValue(element, organization,
              data[i].getAccountName(), data[i].getAccountValue(), data[i].getAccountDescription(),
              accountType, accountSign, IsDocControlled, IsSummary, data[i].getElementLevel(),
              false, showValueCond, titleNode);
        } catch (Exception e) {
          OBException obException = new OBException("line " + i
              + "  insertElementValuesInDB() - Cuenta no insertada con valor: ("
              + data[i].getAccountValue() + "  )  " + e.getMessage(), e.getCause(), true);
          logRecordError(obException.fillInStackTrace().getMessage(), (Object[]) nextLine);
          throw obException;
        }
        if (elementValue == null) {
          OBException obException = new OBException("line " + i
              + "  insertElementValuesInDB() - Cuenta no insertada con valor: ("
              + data[i].getAccountValue() + "  )  ");
          logRecordError(obException.fillInStackTrace().getMessage(), (Object[]) nextLine);
          throw obException;
        }
        if (!data[i].getDefaultAccount().equals(""))
          defaultElementValues.put(data[i].getDefaultAccount(), elementValue);

        mapElementValueValue.put(elementValue.getId(), elementValue.getSearchKey());
        mapElementValueId.put(elementValue.getSearchKey(), elementValue.getId());

        log4j
            .debug("insertElementValuesInDB() - Element value correctly inserted. Figuring out the correct sequence number.");

        Long lSequence = 10L;
        String strParent = data[i].getAccountParent();
        if (strParent.equals(""))
          strParent = "0";
        if (mapChildSequence.containsKey(strParent)) {
          lSequence = mapChildSequence.get(strParent) + 10;
          mapChildSequence.put(strParent, lSequence);
          mapChildSequence.put(data[i].getAccountValue(), 0L);
          mapSequence.put(data[i].getAccountValue(), lSequence);
          mapParent.put(data[i].getAccountValue(), strParent);
        }

        log4j.debug("insertElementValues() - Sequence for the element value: " + lSequence);
      }

      try {
        OBDal.getInstance().flush();
      } catch (Exception e) {
        logRecordError(e.getCause().getMessage(), (Object[]) nextLine);
        throw e;
      }
    }

    log4j
        .debug("insertElementValuesInDB() - All accounts processed correctly. Updating tree node.");
    List<TreeNode> lTreeNodes = null;
    try {
      lTreeNodes = InitialSetupUtility.getTreeNode(accountTree, client, organization);
      log4j.debug("insertElementValuesInDB() - Read from database " + lTreeNodes.size()
          + " ADTreeNode elements. Updating tree.");
      InitialSetupUtility.updateAccountTree(lTreeNodes, mapSequence, mapElementValueValue,
          mapElementValueId, mapParent, false);
      log4j.debug("insertElementValuesInDB() - Account tree updated.");
      try {
        OBContext.setAdminMode();
        OBDal.getInstance().flush();
      } finally {
        OBContext.restorePreviousMode();
      }
    } catch (Exception e) {
      OBException obException = new OBException("El árbol de cuentas no se puede ordenar. : "
          + e.getCause().getMessage(), e.getCause(), true);
      logRecordError(e.fillInStackTrace().getMessage());
      throw obException;
      // logEvent("@AccountTreeNotSorted@");
    }
    log4j
        .debug("insertElementValuesInDB() - All accounts inserted correctly in database. Updating operands.");
    return updateOperands(data);
  }

  private OBError updateOperands(COAData[] data) {
    log4j.debug("updateOperands() - Updating operands for " + data.length
        + " element values inserted.");
    OBError obeResult = new OBError();
    obeResult.setType(strMessageOk);

    for (int i = 0; i < data.length; i++) {
      log4j.debug("updateOperands() - Procesing account in position " + i + ": "
          + data[i].getAccountValue());
      String[][] strOperand = operandProcess(data[i].getOperands());
      String strSeqNo = "10";
      try {
        ElementValue elementValue = InitialSetupUtility.getElementValue(element,
            data[i].getAccountValue());
        for (int j = 0; strOperand != null && j < strOperand.length; j++) {
          ElementValue operand = InitialSetupUtility.getElementValue(element, strOperand[j][0]);
          if (elementValue != null && operand != null) {
            log4j.debug("updateOperands() - Procesing operand " + strOperand[j][0]
                + ", of the account " + data[i].getAccountValue());
            ElementValueOperand operandElement = InitialSetupUtility.insertOperand(operand,
                elementValue, Long.valueOf((strOperand[j][1].equals("+") ? "1" : "-1")),
                Long.valueOf(strSeqNo));
            strSeqNo = nextSeqNo(strSeqNo);
            if (operandElement == null)
              log4j.info("@OperandNotInserted@. @Account_ID@ = " + data[i].getAccountValue()
                  + " - @Account_ID@ = " + strOperand[j][0]);
          } else {
            log4j.info("Operand not inserted: Account = " + data[i].getAccountValue()
                + " - Operand = " + strOperand[j][0]);
            log4j.error("Operand not inserted - Value = " + strOperand[j][0]);
          }
        }
      } catch (Exception e) {
        OBException obException = new OBException("Operando no insertado. : "
            + e.getCause().getMessage(), e.getCause(), true);
        logRecordError(e.fillInStackTrace().getMessage());
        throw obException;
      }
    }
    return obeResult;
  }// updateOperands()

  private String nextSeqNo(String oldSeqNo) {
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    String SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    return SeqNo;
  }

  private String[][] operandProcess(String strOperand) {
    if (strOperand == null || strOperand.equals(""))
      return null;
    StringTokenizer st = new StringTokenizer(strOperand, "+-", true);
    StringTokenizer stNo = new StringTokenizer(strOperand, "+-", false);
    int no = stNo.countTokens();
    String[][] strResult = new String[no][2];
    no = 0; // Token No
    int i = 0; // Array position
    strResult[0][1] = "+";
    while (st.hasMoreTokens()) {
      if (i % 2 != 1) {
        strResult[no][0] = st.nextToken().trim();
        no++;
      } else
        strResult[no][1] = st.nextToken().trim();
      i++;
    }
    // strResult = filterArray(strResult);
    return strResult;
  }

  private String setAccountSign(COAData data) {
    String accountSign = "";
    if (!data.getAccountSign().equals("")) {
      String s = data.getAccountSign().toUpperCase().substring(0, 1);
      if (s.equals("D") || s.equals("C"))
        accountSign = s;
      else
        accountSign = "N";
    } else
      accountSign = "N";
    log4j.debug("AccountSign: " + accountSign);
    return accountSign;
  }

  private String setAccountType(COAData data) {
    if (data == null)
      return null;
    String accountType = "";
    if (!data.getAccountType().equals("")) {
      String s = data.getAccountType().toUpperCase().substring(0, 1);
      if (s.equals("A") || s.equals("L") || s.equals("O") || s.equals("E") || s.equals("R")
          || s.equals("M"))
        accountType = s;
      else
        accountType = "E";
    } else {
      accountType = "E";
    }
    log4j.debug("Account Type: " + accountType);
    return accountType;
  }

  private COAData[] parseCOA(VariablesBase vars, InputStream instFile) throws IOException {
    log4j.debug("parseCOA() - Parsing chart of acconts file provided."
        + " A COAData object is created.");
    COAData coa;
    if (vars == null)
      coa = new COAData(instFile, true, "C");
    else
      coa = new COAData(vars, instFile, true, "C");
    log4j.debug("parseCOA() - A COAData object correctly created."
        + " Parsing the data readen from the file.");
    return parseData(coa.getFieldProvider());
  }

  private COAData[] parseData(FieldProvider[] data) {
    if (data == null)
      return null;
    log4j.debug("parseData() - Parsing " + data.length + " elements read from file.");
    COAData[] result = null;
    Vector<COAData> vec = new Vector<>();
    for (int i = 0; i < data.length; i++) {
      log4j.debug("parseData() - Processing element " + data[i].getField("accountValue"));
      COAData dataAux = new COAData();
      dataAux.setAccountValue(data[i].getField("accountValue"));
      log4j.debug("parseData() - dataAux.accountValue: " + dataAux.getAccountValue());
      dataAux.setAccountName(data[i].getField("accountName"));
      log4j.debug("parseData() - dataAux.accountName: " + dataAux.getAccountName());
      dataAux.setAccountDescription(data[i].getField("accountDescription"));
      log4j.debug("parseData() - dataAux.accountDescription: " + dataAux.getAccountDescription());
      dataAux.setAccountType(data[i].getField("accountType"));
      log4j.debug("parseData() - dataAux.accountType: " + dataAux.getAccountType());
      dataAux.setAccountSign(data[i].getField("accountSign"));
      log4j.debug("parseData() - dataAux.accountSign: " + dataAux.getAccountSign());
      dataAux.setAccountDocument(data[i].getField("accountDocument"));
      log4j.debug("parseData() - dataAux.accountDocument: " + dataAux.getAccountDocument());
      dataAux.setAccountSummary(data[i].getField("accountSummary"));
      log4j.debug("parseData() - dataAux.accountSummary: " + dataAux.getAccountSummary());
      dataAux.setDefaultAccount(data[i].getField("defaultAccount"));
      log4j.debug("parseData() - dataAux.defaultAccount: " + dataAux.getDefaultAccount());
      dataAux.setAccountParent(data[i].getField("accountParent"));
      log4j.debug("parseData() - dataAux.accountParent: " + dataAux.getAccountParent());
      dataAux.setElementLevel(data[i].getField("elementLevel"));
      log4j.debug("parseData() - dataAux.elementLevel: " + dataAux.getElementLevel());
      dataAux.setBalanceSheet(data[i].getField("balanceSheet"));
      log4j.debug("parseData() - dataAux.operands: " + dataAux.getOperands());
      dataAux.setOperands(data[i].getField("operands"));
      log4j.debug("parseData() - dataAux.balanceSheet: " + dataAux.getBalanceSheet());
      dataAux.setBalanceSheetName(data[i].getField("balanceSheetName"));
      log4j.debug("parseData() - dataAux.balanceSheetName: " + dataAux.getBalanceSheetName());
      dataAux.setUS1120BalanceSheet(data[i].getField("uS1120BalanceSheet"));
      log4j.debug("parseData() - dataAux.uS1120BalanceSheet: " + dataAux.getUS1120BalanceSheet());
      dataAux.setUS1120BalanceSheetName(data[i].getField("uS1120BalanceSheetName"));
      log4j.debug("parseData() - dataAux.uS1120BalanceSheetName: "
          + dataAux.getUS1120BalanceSheetName());
      dataAux.setProfitAndLoss(data[i].getField("profitAndLoss"));
      log4j.debug("parseData() - dataAux.profitAndLoss: " + dataAux.getProfitAndLoss());
      dataAux.setProfitAndLossName(data[i].getField("profitAndLossName"));
      log4j.debug("parseData() - dataAux.profitAndLossName: " + dataAux.getProfitAndLossName());
      dataAux.setUS1120IncomeStatement(data[i].getField("uS1120IncomeStatement"));
      log4j.debug("parseData() - dataAux.uS1120IncomeStatement: "
          + dataAux.getUS1120IncomeStatement());
      dataAux.setUS1120IncomeStatementName(data[i].getField("uS1120IncomeStatementName"));
      log4j.debug("parseData() - dataAux.uS1120IncomeStatementName: "
          + dataAux.getUS1120IncomeStatementName());
      dataAux.setCashFlow(data[i].getField("cashFlow"));
      log4j.debug("parseData() - dataAux.cashFlow: " + dataAux.getCashFlow());
      dataAux.setCashFlowName(data[i].getField("cashFlowName"));
      log4j.debug("parseData() - dataAux.cashFlowName: " + dataAux.getCashFlowName());
      dataAux.setCElementValueId(data[i].getField("cElementValueId"));
      log4j.debug("parseData() - dataAux.cElementValueId: " + dataAux.getCElementValueId());
      vec.addElement(dataAux);

      dataAux.setShowValueCond(data[i].getField("showValueCond"));
      log4j.debug("parseData() - showValueCond: " + dataAux.getShowValueCond());
      dataAux.setTitleNode(data[i].getField("titleNode"));
      log4j.debug("parseData() - dataAux.accountValue: " + dataAux.getTitleNode());

    }
    log4j.debug("parseData() - All elements processed correctly.");
    result = new COAData[vec.size()];
    vec.copyInto(result);
    return result;
  }

  @Override
  protected String getEntityName() {
    return "Importar Árbol de Cuentas Secundario";
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {
    validator.checkNotNull(validator.checkString(values[0], 40), "Codigo");
    validator.checkNotNull(validator.checkString(values[1], 255), "Nombre");
    validator.checkNotNull(validator.checkString(values[2], 255), "Descripcion");
    validator.checkNotNull(validator.checkString(values[3], 1), "Account Type");
    validator.checkNotNull(validator.checkString(values[4], 1), "Naturaleza de la cuenta");
    validator.checkNotNull(validator.checkBoolean(values[5]), "Account Document");
    validator.checkNotNull(validator.checkBoolean(values[6]), "Nivel agrupación");
    validator.checkString(values[7], 60);
    validator.checkString(values[8], 20);
    validator.checkNotNull(validator.checkString(values[9], 1), "Nivel");
    validator.checkString(values[10], 255);
    return values;
  }

  @Override
  protected BaseOBObject internalProcess(Object... values) throws Exception {
    return null;
  }

  private boolean executeImportValidator(String filename) throws Exception {

    CSVReader reader = getCSVReader(filename);

    String[] nextLine;

    // Check header
    nextLine = reader.readNext();
    if (nextLine == null) {
      throw new OBException(Utility.messageBD(conn, "IDLJAVA_HEADER_MISSING", vars.getLanguage()));
    }
    Parameter[] parameters = getParameters();
    if (parameters.length > nextLine.length) {
      throw new OBException(
          Utility.messageBD(conn, "IDLJAVA_HEADER_BAD_LENGTH", vars.getLanguage()));
    }

    Validator validator;

    while ((nextLine = reader.readNext()) != null) {

      if (nextLine.length > 1 || nextLine[0].length() > 0) {
        // It is not an empty line

        // Validate types
        if (parameters.length > nextLine.length) {
          throw new OBException(Utility.messageBD(conn, "IDLJAVA_LINE_BAD_LENGTH",
              vars.getLanguage()));
        }

        validator = getValidator(getEntityName());
        Object[] result = validateProcess(validator, nextLine);
        if ("0".equals(validator.getErrorCode())) {
          finishRecordProcess(result);
        } else {
          logRecordError(validator.getErrorMessage(), result);
        }
      }
    }

    return true;
  }

  private CSVReader getCSVReader(String filename) throws UnsupportedEncodingException,
      FileNotFoundException {
    CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"),
        ',', '\"', '\\', 0, false, true);
    return reader;
  }

  @Override
  public Parameter[] getParameters() {
    return new Parameter[] { //
    new Parameter("Codigo", Parameter.STRING),// 0
        new Parameter("Nombre", Parameter.STRING),// 1
        new Parameter("Descripcion ", Parameter.STRING),// 2
        new Parameter("Tipo de Cuenta ", Parameter.STRING),// 3
        new Parameter("ACreditCreditount Sign ", Parameter.STRING),// 4
        new Parameter("Account_Document", Parameter.STRING), // 5
        new Parameter("Account Summar", Parameter.STRING), // 6
        new Parameter("Default Accoun", Parameter.STRING),// 7
        new Parameter("Account Parent", Parameter.STRING), // 8
        new Parameter("Nivel", Parameter.STRING), // 9
        new Parameter("Operando", Parameter.STRING),// 10
    };
  }

}

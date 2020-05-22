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
 * All portions are Copyright (C) 2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.test.expression;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;
import org.openbravo.client.application.OBBindings;
import org.openbravo.client.application.OBBindingsConstants;
import org.openbravo.dal.core.OBContext;
import org.openbravo.test.base.OBBaseTest;
import org.openbravo.test.base.mock.HttpServletRequestMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test the result of evaluating JavaScript expressions configuring {@link OBBindings} as the Java
 * binding to be used by the engine in the execution of the scripts.
 */
public class OBBindingsTest extends OBBaseTest {
  private static final Logger log = LoggerFactory.getLogger(OBBindingsTest.class);
  private static final String DEFAULT = "DEFAULT";
  private static final String YES = "Y";
  private ScriptEngine engine;
  private HttpServletRequestMock request;

  @Before
  public void initScriptEngine() throws Exception {
    request = new HttpServletRequestMock();
    Map<String, String> parameters = new HashMap<>();
    parameters.put(OBBindingsConstants.COMMAND_TYPE_PARAM, DEFAULT);
    parameters.put(OBBindingsConstants.POSTED_PARAM, YES);
    // initialize Javascript engine
    engine = new ScriptEngineManager().getEngineByName("js");
    engine.put("OB", new OBBindings(OBContext.getOBContext(), parameters, request.getSession()));
    log.info("Using script engine {}", engine.getClass().getSimpleName());
  }

  @Test
  public void formatDate() throws ScriptException {
    Object result = engine.eval("OB.formatDate(new Date('12/29/2017'))");
    assertThat(result.toString(), equalTo("29-12-2017"));
  }

  @Test
  public void customFormatDate() throws ScriptException {
    Object result = engine.eval("OB.formatDate(new Date('12/29/2017'),'yyyy/MM/dd')");
    assertThat(result.toString(), equalTo("2017/12/29"));
  }

  @Test
  public void formatDateTime() throws ScriptException {
    Object result = engine.eval("OB.formatDateTime(new Date('12/29/2017 16:29:21'))");
    assertThat(result.toString(), equalTo("29-12-2017 16:29:21"));
  }

  @Test
  public void parseDate() throws ScriptException, ParseException {
    Date result = (Date) engine.eval("OB.parseDate('29-12-2017')");
    Date expectedDate = new SimpleDateFormat("dd-MM-yyyy").parse("29-12-2017");
    assertThat(result, equalTo(expectedDate));
  }

  @Test
  public void customParseDate() throws ScriptException, ParseException {
    Date result = (Date) engine.eval("OB.parseDate('2017/12/29','yyyy/MM/dd')");
    Date expectedDate = new SimpleDateFormat("dd-MM-yyyy").parse("29-12-2017");
    assertThat(result, equalTo(expectedDate));
  }

  @Test
  public void parseDateTime() throws ScriptException, ParseException {
    // parseDateTime is only called from the client and assumes that the dates that arrive are in
    // the UTC timezone and transforms it into the local time
    Date result = (Date) engine.eval("OB.parseDateTime('2017-12-29T16:29:21')");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date expectedDate = convertToLocalTime(sdf.parse("29-12-2017 16:29:21"));
    assertThat(result, equalTo(expectedDate));
  }

  private Date convertToLocalTime(Date UTCTime) {
    Calendar localTime = Calendar.getInstance();
    localTime.setTime(UTCTime);
    int gmtMillisecondOffset = (localTime.get(Calendar.ZONE_OFFSET) + localTime
        .get(Calendar.DST_OFFSET));
    localTime.add(Calendar.MILLISECOND, gmtMillisecondOffset);
    return localTime.getTime();
  }

  @Test
  public void getContextInfo() throws ScriptException {
    Object result = engine.eval("OB.getContext().getCurrentClient().id");
    assertThat(result.toString(), equalTo(TEST_CLIENT_ID));
  }

  @Test
  public void getStringValueFromRequestMap() throws ScriptException {
    String result = (String) engine.eval("OB.getCommandType()");
    assertThat(result, equalTo(DEFAULT));
  }

  @Test
  public void getBooleanValueFromRequestMap() throws ScriptException {
    Boolean result = (Boolean) engine.eval("OB.isPosted()");
    assertThat(result, equalTo(Boolean.TRUE));
  }
}

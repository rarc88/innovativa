/*
 ************************************************************************************
 * Copyright (C) 2012-2014 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */
package org.openbravo.mobile.core.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.NOPLoggerRepository;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.authentication.AuthenticationException;
import org.openbravo.base.exception.OBSecurityException;
import org.openbravo.base.secureApp.AllowedCrossDomainsHandler;
import org.openbravo.client.kernel.BaseKernelServlet;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.SessionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DbUtility;
import org.openbravo.service.json.JsonConstants;

/**
 * A base JSON web service This servlet just verifies if the user is authenticated
 * 
 * @author adrianromero
 * @author iperdomo
 */
public abstract class WebServiceAuthenticatedServlet extends BaseKernelServlet {
  private static final Logger log = Logger.getLogger(WebServiceAuthenticatedServlet.class);
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // always set the cors headers
    AllowedCrossDomainsHandler.getInstance().setCORSHeaders(request, response);

    // don't process any further requests otherwise sessions are created for OPTIONS
    // requests, the cors headers have already been set so can return
    if (request.getMethod().equals("OPTIONS")) {
      return;
    }

    try {
      final KernelHttpServletResponse localResponse = new KernelHttpServletResponse(response);
      RequestContext.get().setResponse(localResponse);

      try {
        callServiceInSuper(request, localResponse);
      } catch (AuthenticationException e) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        if (supportBasicAuthentication(request)) {
          response.setHeader("WWW-Authenticate", "Basic realm=\"Openbravo\"");
        }
        throw new NotAuthorizedException();
      }

      //
      // When the user is not authenticated the local response has a redirect target. When the user
      // has no access to this resource a error page is generated in the service using bdError
      // method of HttpSecureAppServlet and the local response has a content type
      //
      if (localResponse.getRedirectTarget() != null && !bypassAuthentication()) {
        if (!response.isCommitted()) {
          response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          if (supportBasicAuthentication(request)) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Openbravo\"");
          }
          throw new NotAuthorizedException();
        }
      } else if (HttpServletResponse.SC_UNAUTHORIZED == response.getStatus()) {
        if (supportBasicAuthentication(request)) {
          response.setHeader("WWW-Authenticate", "Basic realm=\"Openbravo\"");
        }
      } else {
        response.setStatus(HttpServletResponse.SC_OK);
      }
    } catch (Exception e) {
      SessionHandler.getInstance().setDoRollback(true);
      if (e instanceof NotAuthorizedException) {
        log.debug("Not authorized", e);
      } else {
        log.error("Error in WebServiceAuthenticatedServlet", e);
      }
      writeResult(response, silentExceptionToJson(e));
    }
  }

  private boolean supportBasicAuthentication(HttpServletRequest req) {
    return !"false".equals(req.getParameter("auth"))
        && "true".equals(req.getParameter("basicAuthentication"));
  }

  @Override
  public void doOptions(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // normally this is already handled in the service method above,
    // but to be complete implemented the doOptions as well
    AllowedCrossDomainsHandler.getInstance().setCORSHeaders(request, response);
  }

  @Override
  protected void bdError(HttpServletRequest request, HttpServletResponse response, String strCode,
      String strLanguage) throws IOException {
    final String message = Utility.messageBD(this, strCode, strLanguage);
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    writeResult(response, silentExceptionToJson(new OBSecurityException(message) {
      private static final long serialVersionUID = 1L;

      @Override
      protected Logger getLogger() {
        // The logger is overridden so no unnecessary exception trace is shown in the log in this
        // case
        return new org.apache.log4j.spi.NOPLogger(new NOPLoggerRepository(), "NOP");
      }
    }));
  }

  protected void writeResult(HttpServletResponse response, String result) throws IOException {
    response.setContentType("application/json;charset=UTF-8");
    response.setHeader("Content-Type", "application/json;charset=UTF-8");

    final Writer w = response.getWriter();
    w.write(result);
    w.close();
  }

  protected String getRequestContent(HttpServletRequest request) throws IOException {
    final BufferedReader reader = request.getReader();
    if (reader == null) {
      return "";
    }
    String line;
    final StringBuilder sb = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      if (sb.length() > 0) {
        sb.append("\n");
      }
      sb.append(line);
    }
    log.debug("REQUEST CONTENT>>>>");
    log.debug(sb.toString());
    return sb.toString();
  }

  protected Object getContentAsJSON(String content) throws JSONException {
    if (content == null || content.equals("")) {
      return new JSONObject();
    } else if (content.trim().startsWith("[")) {
      return new JSONArray(content);
    } else {
      return new JSONObject(content);
    }
  }

  protected String getJSONResult(String result) throws JSONException {
    final JSONObject jsonResult = new JSONObject();
    jsonResult.put("result", result);
    return jsonResult.toString();
  }

  public static String silentExceptionToJson(Throwable throwable) throws IOException {

    Throwable localThrowable = DbUtility.getUnderlyingSQLException(throwable);

    try {
      final JSONObject jsonResult = new JSONObject();
      final JSONObject jsonResponse = new JSONObject();
      jsonResponse.put(JsonConstants.RESPONSE_STATUS, JsonConstants.RPCREQUEST_STATUS_FAILURE);

      try {
        // get rid of the current transaction
        OBDal.getInstance().rollbackAndClose();
      } catch (Exception e) {
        // ignored on purpose
        log.error(e.getMessage(), e);
      }

      final JSONObject error = new JSONObject();
      error.put("message", localThrowable.getMessage());
      error.put("type", localThrowable.getClass().getName());
      jsonResponse.put(JsonConstants.RESPONSE_ERROR, error);

      jsonResponse.put(JsonConstants.RESPONSE_TOTALROWS, 0);
      jsonResult.put(JsonConstants.RESPONSE_RESPONSE, jsonResponse);
      return jsonResult.toString();
    } catch (JSONException e) {
      throw new IOException(e);
    }
  }

  protected boolean bypassAuthentication() {
    return false;
  }

  private class NotAuthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
  }
}

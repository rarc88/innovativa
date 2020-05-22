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
 * All portions are Copyright (C) 2012-2015 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ___________Santiago Recalde___________.
 ************************************************************************
 */

OB.ECSAP = OB.ECSAP || {};

OB.ECSAP.Process = {
  // *** Note: 
  // params.handler= "Name class java to handler"
  orderAuthorize: function (params, view) {
    params.handler = "AuthorizeLevel";
    params.action = "authorize";
    OB.ECSAP.Process.execute(params, view);
  },
  invoiceAuthorize: function (params, view) {
    params.handler = "InvoiceAuthorize";
    params.action = "authorize";
    OB.ECSAP.Process.execute(params, view);
  },
  orderReject: function (params, view) {
    params.handler = "AuthorizeLevel";
    params.action = "reject";
    OB.ECSAP.Process.execute(params, view);
  },
  invoiceReject: function (params, view) {
    params.handler = "InvoiceAuthorize";
    params.action = "reject";
    OB.ECSAP.Process.execute(params, view);
  },
  invoiceSign: function (params, view) {
    params.handler = "InvoiceSign";
    params.action = "sign";
    OB.ECSAP.Process.execute(params, view);
  },
  orderSign: function (params, view) {
    params.handler = "SignOrder";
    params.action = "sign";
    OB.ECSAP.Process.execute(params, view);
  },

  execute: function (params, view) {
    var i,
      selection = params.button.contextView.viewGrid.getSelectedRecords(),
      tadId = "",
      tableId = "",
      path = "ec.com.sidesoft.authorization.process.ad_action_button.",
      recordIdList = [],
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      if (params.action === "authorize") {
        isc.say(OB.I18N.getLabel("ECSAP_Authorize", [data.updated]));
        params.button.contextView.viewGrid.refreshGrid();
      } else if (params.action === "reject") {
        isc.say(OB.I18N.getLabel("ECSAP_Rejected", [data.updated]));
        params.button.contextView.viewGrid.refreshGrid();
      } else {
        isc.say(OB.I18N.getLabel("ECSAP_Signed", [data.updated]));
        params.button.contextView.viewGrid.refreshGrid();
      }
      params.button.closeProcessPopup();
    };

    for (i = 0; i < selection.length; i++) {
      recordIdList.push(selection[i][OB.Constants.ID]);
      tadId = params.button.contextView.standardProperties.inpTabId;
      tableId = params.button.contextView.standardProperties.inpTableId;
    }

    if (params.action === "authorize" || params.action === "sign") {
      OB.RemoteCallManager.call(
        path + params.handler,
        {
          orders: recordIdList,
          action: params.action,
          reason: '',
          tad: tadId,
          table: tableId,
        },
        {},
        callback
      );
    } else if (params.action === "reject") {
      // Create the PopUp
      isc.RejectAuthorization.create({
        actionHandler: path + params.handler,
        orders: recordIdList,
        view: view,
        params: params
      }).show();
    } else {
    }
  },
};

isc.defineClass('RejectAuthorization', isc.OBPopup);

isc.RejectAuthorization.addProperties({

  width: 320,
  height: 200,
  title: null,
  showMinimizeButton: false,
  showMaximizeButton: false,

  //Form
  mainform: null,

  //Button
  okButton: null,
  cancelButton: null,

  getActionList: function (form) {
    var send = {
      recordIdList: this.recordIdList
    },
      actionField, popup = this;
    send.action = 'ACTION_COMBO';
    OB.RemoteCallManager.call('ec.com.sidesoft.authorization.process.selector_list.LevelAuthorization', send, {}, function (response, data, request) {
      if (response) {
        actionField = form.getField('Motivo');
        if (response.data) {
          popup.setTitle('Anular Autorización');
          // actionField.closePeriodStepId = response.data.nextStepId;
          actionField.setValueMap(response.data.actionComboBox.valueMap);
          actionField.setDefaultValue(response.data.actionComboBox.defaultValue);
        }
      }
    });
  },

  initWidget: function () {

    var recordIdList = this.recordIdList,
      originalView = this.view,
      params = this.params;

    this.mainform = isc.DynamicForm.create({
      numCols: 2,
      colWidths: ['50%', '50%'],
      fields: [{
        name: 'Motivo',
        title: 'Motivo',
        height: 20,
        width: 255,
        required: true,
        type: '_id_17', //selected reference
        // defaultToFirstOption: false
      }]
    });

    this.okButton = isc.OBFormButton.create({
      title: OB.I18N.getLabel('OK'),
      popup: this,
      action: function () {
        var callback, action;

        callback = function (rpcResponse, data, rpcRequest) {
          var status = rpcResponse.status,
            view = rpcRequest.clientContext.originalView.getView(params.adTabId);
          if (data.message) {
            view.messageBar.setMessage(data.message.severity, null, data.message.text);
          }
          rpcRequest.clientContext.popup.closeClick();
          rpcRequest.clientContext.originalView.refresh(false, false);
        };

        OB.RemoteCallManager.call(this.popup.actionHandler, {
          orders: this.popup.orders,
          action: this.popup.params.action,
          reason: this.popup.mainform.getField('Motivo').getValue()
        }, {}, callback, {
          originalView: this.popup.view,
          popup: this.popup
        });
      }
    });

    this.cancelButton = isc.OBFormButton.create({
      title: OB.I18N.getLabel('Cancel'),
      popup: this,
      action: function () {
        this.popup.closeClick();
      }
    });

    this.getActionList(this.mainform);

    this.items = [
      isc.VLayout.create({
        defaultLayoutAlign: "center",
        align: "center",
        width: "100%",
        layoutMargin: 10,
        membersMargin: 6,
        members: [
          isc.HLayout.create({
            defaultLayoutAlign: "center",
            align: "center",
            layoutMargin: 30,
            membersMargin: 6,
            members: this.mainform
          }), isc.HLayout.create({
            defaultLayoutAlign: "center",
            align: "center",
            membersMargin: 10,
            members: [this.okButton, this.cancelButton]
          })]
      })];

    this.Super('initWidget', arguments);
  }

});


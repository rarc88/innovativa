OB.ValidateCostingRule={};OB.ValidateCostingRule.onLoad=function(a){a.messageBar.setMessage(isc.OBMessageBar.TYPE_INFO,null,OB.I18N.getLabel("CostingRuleHelp"));};OB.ValidateCostingRule.onProcess=function(a,e,d){var c,b;c=function(f,h,g){b=function(i){if(i){e();}else{a.parentElement.parentElement.closeClick();
}};if(h.message.text){isc.confirm(h.message.text,b);}else{e();}};a.messageBar.setMessage(isc.OBMessageBar.TYPE_INFO,null,OB.I18N.getLabel("CostingRuleHelp"));OB.RemoteCallManager.call("org.openbravo.costing.CostingRuleProcessOnProcessHandler",{ruleId:a.parentWindow.view.lastRecordSelected.id},{},c);};

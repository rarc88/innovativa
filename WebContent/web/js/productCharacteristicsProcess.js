OB=OB||{};OB.ProductCharacteristics={execute:function(b,f){var e,g=b.button.contextView.viewGrid.getSelectedRecords(),c,d=f.getView(b.adTabId).messageBar,j,h,a=true;j=function(l,k,i){this.view=f;isc.UpdateInvariantCharacteristicsPopup.create({productId:k.productId,characteristicList:k.productCharList,actionHandler:"org.openbravo.client.application.event.UpdateInvariantCharacteristicsHandler",view:f}).show();
};c=g[0].id;OB.RemoteCallManager.call(b.actionHandler,{productId:c,action:b.action},{},j);},updateInvariants:function(b,a){b.actionHandler="org.openbravo.client.application.event.UpdateInvariantCharacteristicsHandler";b.adTabId=a.activeView.tabId;b.processId="A832A5DA28FB4BB391BDE883E928DFC5";b.action="INITIALIZE";
OB.ProductCharacteristics.execute(b,a);},testOnGridLoad:function(b){var a=b.getData().getLength(),c=b.view.messageBar;if(a==0){c.setMessage("info",OB.I18N.getLabel("HighRecords"));}},};isc.defineClass("UpdateInvariantCharacteristicsPopup",isc.OBPopup);isc.UpdateInvariantCharacteristicsPopup.addProperties({width:400,height:300,title:"Update Characteristics",canDragResize:false,showMinimizeButton:false,showMaximizeButton:false,productId:null,actionHandler:null,characteristicCombos:null,okButton:null,cancelButton:null,initWidget:function(){OB.TestRegistry.register("org.openbravo.client.application.UpdateInvariantCharacteristics.popup",this);
var a=this.view,e=this.params,b,c,d;c=function(){};d=function(){this.optionDataSource=OB.Datasource.create({createClassName:"",dataURL:"/openbravo/org.openbravo.service.datasource/CharacteristicValue",requestProperties:{params:{targetProperty:this.name,adTabId:"A43B5CFC17754AED86B9E57F71460C4E",IsSelectorItem:"true",Constants_FIELDSEPARATOR:"$",columnName:this.name,Constants_IDENTIFIER:"_identifier",_extraProperties:"id,name"}},fields:[{name:"id",type:"_id_13",primaryKey:true},{name:"client",type:"_id_19"},{name:"client$_identifier"},{name:"organization",type:"_id_19"},{name:"organization$_identifier"},{name:"active",type:"_id_20"},{name:"creationDate",type:"_id_16"},{name:"createdBy",type:"_id_30"},{name:"createdBy$_identifier"},{name:"updated",type:"_id_16"},{name:"updatedBy",type:"_id_30"},{name:"updatedBy$_identifier"},{name:"characteristic",type:"_id_19"},{name:"characteristic$_identifier"},{name:"name",type:"_id_10"},{name:"summaryLevel",type:"_id_20"},{name:"code",type:"_id_10"},{name:"description",type:"_id_10"},{name:"addProducts",type:"_id_28"},{name:"id",type:"_id_13",additional:true,primaryKey:true},{name:"name",type:"_id_10",additional:true}]});
this.Super("init",arguments);this.tree.originalShow=this.tree.show;this.tree.treeItem.addParamsToRequest=function(){return{parentCharId:this.parentCharId,productCharSubsetId:this.productCharSubsetId};};this.tree.show=function(f){if(this.dataSource){this.originalShow(f);this.bringToFront();}};};this.characteristicCombos=[];
for(b=0;b<this.characteristicList.length;b++){this.characteristicCombos[b]=isc.DynamicForm.create({view:a.view,handleItemChange:c,fields:[{id:this.characteristicList[b].id,name:this.characteristicList[b].name,title:this.characteristicList[b].title,valueMap:this.characteristicList[b].valueMap,defaultValue:this.characteristicList[b].selectedValue,existingProdChValue:this.characteristicList[b].existingProdChValue,height:20,width:255,required:false,form:{view:a.view},columnName:this.characteristicList[b].name,inpColumnName:this.characteristicList[b].name,refColumnName:this.characteristicList[b].name,targetEntity:this.characteristicList[b].name,treeReferenceId:"95582A51651D415993D0FD3B64C8E861",parentCharId:this.characteristicList[b].id,dataSourceId:"90034CAE96E847D78FBEF6D38CB1930D",parentSelectionAllowed:true,popupTextMatchStyle:"substring",textMatchStyle:"substring",defaultPopupFilterField:"name",displayField:"name",valueField:"id",referencedTableId:"E913D17C9B3847CF92235082DBE2EC44",productCharSubsetId:this.characteristicList[b].productCharSubsetId,showTreePopupWindow:false,pickListFields:[{title:" ",name:"name",type:"text"}],showSelectorGrid:true,treeGridFields:[{title:"name",name:"name",canSort:false,type:"_id_10"}],extraSearchFields:[],init:d,gridProps:{sort:3,autoExpand:true,displayField:"characteristicValue$name",displaylength:32,fkField:true,showHover:true},type:"_id_D3D9A7BAF4594950922A22B2D7ABFA74"}]});
this.characteristicCombos[b].getField(0).setIcons([]);}this.okButton=isc.OBFormButton.create({title:OB.I18N.getLabel("OK"),popup:this,action:function(){var l,j,f={},g,k,h={};l=function(n,m,i){i.clientContext.popup.closeClick();i.clientContext.popup.view.refresh(false,false);if(m.message){i.clientContext.popup.view.view.messageBar.setMessage(m.message.severity,null,m.message.text);
}};for(g=0;g<this.popup.items[0].members[0].members.length;g++){k=this.popup.items[0].members[0].members[g];f[k.fields[0].id]=k.values[k.fields[0].name];h[k.fields[0].id]=k.fields[0].existingProdChValue;}OB.RemoteCallManager.call(this.popup.actionHandler,{productId:this.popup.productId,updatedValues:f,existingProdChValues:h,action:"UPDATE"},{},l,{originalView:this.popup.view,popup:this.popup});
}});OB.TestRegistry.register("org.openbravo.client.application.UpdateInvariantCharacteristics.popup.okButton",this.okButton);this.cancelButton=isc.OBFormButton.create({title:OB.I18N.getLabel("Cancel"),popup:this,action:function(){this.popup.closeClick();}});this.items=[isc.VLayout.create({defaultLayoutAlign:"center",align:"center",width:"100%",height:300,overflow:"auto",layoutMargin:10,membersMargin:6,members:[isc.VLayout.create({defaultLayoutAlign:"right",align:"right",layoutMargin:30,membersMargin:6,members:this.characteristicCombos}),isc.HLayout.create({defaultLayoutAlign:"center",align:"center",membersMargin:10,members:[this.okButton,this.cancelButton]})]})];
this.Super("initWidget",arguments);}});
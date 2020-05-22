/*
 ************************************************************************************
 * Copyright (C) 2016-2017 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */

/*global enyo, Backbone, OB, _ */

enyo.kind({
  kind: 'OB.UI.SmallButton',
  name: 'OB.UI.ButtonAdvancedFilter',
  style: 'width: 160px; margin: 0px 9px 8px 0px;',
  classes: 'btnlink-yellow btnlink btnlink-small',
  i18nLabel: 'OBPOS_LblAdvancedFilter',
  events: {
    onShowPopup: '',
    onSearchAction: '',
    onSetSelectorAdvancedSearch: '',
    onHideSelector: '',
    onShowSelector: ''
  },
  tap: function () {
    if (this.disabled) {
      return true;
    }
    var me = this;
    this.doHideSelector();
    this.doShowPopup({
      popup: this.dialog,
      args: {
        callback: function (result) {
          me.doShowSelector();
          if (result) {
            me.doSetSelectorAdvancedSearch({
              isAdvanced: true
            });
            me.doSearchAction({
              filters: result.filters,
              orderby: result.orderby,
              advanced: true
            });
          }
        }
      }
    });
  }
});

enyo.kind({
  name: 'OB.UI.ListSelectorLine',
  kind: 'OB.UI.listItemButton',
  style: 'padding: 2px 0px 2px 10px;',
  events: {
    onHideSelector: '',
    onHideThisPopup: ''
  },
  canHidePopup: function () {
    return true;
  },
  tap: function () {
    this.inherited(arguments);
    this.owner.owner.owner.selectedItem = true;
    if (this.contextMenuItemSelected) {
      this.contextMenuItemSelected = false;
      this.doHideSelector();
    } else if (this.canHidePopup()) {
      this.doHideThisPopup();
    }
    return true;
  }
});

/* Modal definition */
enyo.kind({
  name: 'OB.UI.ModalSelector',
  kind: 'OB.UI.Modal',
  events: {
    onSetSelectorAdvancedSearch: '',
    onClearAllFilterSelector: '',
    onCloseSelector: ''
  },
  handlers: {
    onHideSelector: 'hideSelector',
    onShowSelector: 'showSelector'
  },
  hideSelector: function (inSender, inEvent) {
    this.selectorHide = inEvent && !OB.UTIL.isNullOrUndefined(inEvent.selectorHide) ? inEvent.selectorHide : true;
    this.hide();
    return true;
  },
  showSelector: function () {
    this.show();
    return true;
  },
  getScrollableTable: function () {
    return null;
  },
  getFilterSelectorTableHeader: function () {
    return null;
  },
  getAdvancedFilterBtn: function () {
    return null;
  },
  getAdvancedFilterDialog: function () {
    return null;
  },
  initSelector: function () {
    var advancedFilterBtn = this.getAdvancedFilterBtn(),
        advancedFilterDialog = this.getAdvancedFilterDialog(),
        filterSelectorTableHeader = this.getFilterSelectorTableHeader();
    this.scrollableTable = this.getScrollableTable();
    if (this.scrollableTable) {
      this.scrollableTable.selectedItem = false;
    }
    if (filterSelectorTableHeader) {
      filterSelectorTableHeader.advancedFilterBtn = advancedFilterBtn;
      filterSelectorTableHeader.advancedFilterDialog = advancedFilterDialog;
      filterSelectorTableHeader.setAdvancedFilterBtnCaption();
    }
  },
  init: function (model) {
    this.model = model;
    this.initSelector();
  },
  isInitialized: function () {
    if (this.args.clean) {
      delete this.args.clean;
      this.initialized = false;
    }
    return this.initialized;
  },
  executeOnShow: function () {
    if (!this.isInitialized()) {
      this.selectorHide = false;
      this.initialized = true;
      this.target = this.args.target;
      var filterSelectorTableHeader = this.getFilterSelectorTableHeader();
      if (filterSelectorTableHeader) {
        filterSelectorTableHeader.setAdvancedFilterBtnCaption();
        filterSelectorTableHeader.setFocus();
      }
    }
  },
  executeOnHide: function () {
    if (this.selectorHide) {
      this.selectorHide = false;
      if (this.scrollableTable) {
        this.scrollableTable.selectedItem = false;
      }
    } else {
      this.initialized = false;
      this.waterfall('onClearAllFilterSelector');
      this.doSetSelectorAdvancedSearch({
        isAdvanced: false
      });
      if (this.scrollableTable) {
        if (!this.scrollableTable.selectedItem) {
          this.doCloseSelector({
            target: this.target
          });
        } else {
          this.scrollableTable.selectedItem = false;
        }
      }
    }
  },
  getRemoteCriteria: function (filterModel, filters, orderby) {
    var criteria = {
      _orderByClause: ''
    };
    criteria.remoteFilters = [];
    _.each(filters, function (flt) {
      var column = _.find(filterModel.getProperties(), function (col) {
        return col.column === flt.column;
      });
      if (column) {
        var columnCriteria = {
          columns: [column.name],
          operator: column.isAmount ? flt.operator : column.operator,
          value: flt.value
        };
        if (column.isAmount) {
          columnCriteria.fieldType = 'Number';
        }
        if (column.isSelector) {
          columnCriteria.isId = true;
        }
        criteria.remoteFilters.push(columnCriteria);
      }
    });
    if (orderby) {
      criteria._orderByClause = orderby.column + ' ' + orderby.direction;
    }
    criteria._limit = filterModel.prototype.remoteDataLimit ? filterModel.prototype.remoteDataLimit : OB.Dal.REMOTE_DATALIMIT;
    criteria.forceRemote = true;
    return criteria;
  }
});

enyo.kind({
  name: 'OB.UI.FilterSelectorAmount',
  components: [{
    kind: 'OB.UI.List',
    name: 'filterCondition',
    classes: 'combo',
    style: 'float: left; width: calc(50% - 8px); padding: 4px; margin-right: 16px; margin-bottom: 0px;',
    renderEmpty: 'enyo.Control',
    renderLine: enyo.kind({
      kind: 'enyo.Option',
      initComponents: function () {
        this.inherited(arguments);
        this.setValue(this.model.get('id'));
        this.setContent(this.model.get('name'));
      }
    })
  }, {
    kind: 'enyo.Input',
    type: 'text',
    classes: 'input narrow-input',
    name: 'filterInput',
    style: 'float: right; width: calc(50% - 22px); padding: 4px; margin-bottom: 0px;',
    handlers: {
      onkeyup: 'keyup'
    },
    keyup: function (inSender, inEvent) {
      if (this.owner.hasRemoveButton) {
        var value = this.getValue();
        if (value === '') {
          this.owner.parent.hideRemove();
        } else {
          this.owner.parent.showRemove();
        }
      }
      return true;
    }
  }],
  getValue: function () {
    return this.$.filterInput.getValue();
  },
  setValue: function (value) {
    this.$.filterInput.setValue(value);
    if (this.hasRemoveButton) {
      if (value === '') {
        this.parent.hideRemove();
      } else {
        this.parent.showRemove();
      }
    }
  },
  setPresetValue: function (preset) {
    this.$.filterCondition.setSelectedValue(preset.id, 'id');
    this.setValue(preset.name);
  },
  getOperator: function () {
    return this.$.filterCondition.getValue();
  },
  initComponents: function () {
    this.inherited(arguments);
    this.$.filterCondition.setCollection(new Backbone.Collection());
    this.$.filterCondition.getCollection().reset([{
      id: 'greaterThan',
      name: OB.I18N.getLabel('OBMOBC_FilterQueryBuilderMoreThan')
    }, {
      id: 'lessThan',
      name: OB.I18N.getLabel('OBMOBC_FilterQueryBuilderLessThan')
    }, {
      id: 'equals',
      name: OB.I18N.getLabel('OBMOBC_FilterQueryBuilderEquals')
    }, {
      id: 'notEquals',
      name: OB.I18N.getLabel('OBMOBC_FilterQueryBuilderNotEquals')
    }]);
  }

});

enyo.kind({
  name: 'OB.UI.FilterSelectorButton',
  selectFilterKey: 'OBPOS_SELECTFILTER',
  components: [{
    kind: 'OB.UI.SmallButton',
    name: 'filterButton',
    classes: 'btnlink-gray advancedfilter-selector-btn',
    tap: function () {
      this.owner.owner.owner.showSelector = true;
      this.owner.showSelector = true;
      this.bubble('onHideSelector');
      this.bubble('onShowPopup', {
        popup: this.owner.selectorPopup,
        args: {
          target: 'filterSelectorButton_' + this.owner.filterName,
          filterName: this.owner.filterName
        }
      });
    }
  }],
  getValue: function () {
    return this.value;
  },
  setValue: function (value) {
    this.value = value;
    if (value === '') {
      this.$.filterButton.setContent(OB.I18N.getLabel(this.selectFilterKey));
    }
    if (this.hasRemoveButton) {
      if (value === '') {
        this.parent.hideRemove();
      } else {
        this.parent.showRemove();
      }
    }
  },
  setSelectorValue: function (value, text) {
    this.setValue(value);
    this.$.filterButton.setContent(text ? text : OB.I18N.getLabel(this.selectFilterKey));
  },
  setPresetValue: function (preset) {
    this.setSelectorValue(preset.id, preset.name);
  },
  initComponents: function () {
    this.inherited(arguments);
    this.$.filterButton.setContent(OB.I18N.getLabel(this.selectFilterKey));
    this.value = '';
  }
});

enyo.kind({
  kind: 'OB.UI.List',
  name: 'OB.UI.FilterSelectorList',
  classes: 'combo',
  handlers: {
    onchange: 'change'
  },
  renderLine: enyo.kind({
    kind: 'enyo.Option',
    initComponents: function () {
      this.inherited(arguments);
      this.setValue(this.model.get('id'));
      this.setContent(this.model.get('name'));
    }
  }),
  renderEmpty: 'enyo.Control',
  change: function () {
    var value = this.getValue();
    if (this.hasRemoveButton) {
      if (value === '') {
        this.parent.hideRemove();
      } else {
        this.parent.showRemove();
      }
    }
    return true;
  },
  changeColumn: function (column) {
    if (column.idList && !OB.MobileApp.model.get(column.termProperty)) {
      column.termProperty = 'list_' + column.idList;
      if (OB.I18N.lists && OB.I18N.lists[column.idList]) {
        OB.MobileApp.model.set(column.termProperty, OB.I18N.lists[column.idList], {
          silent: true
        });
      } else {
        OB.MobileApp.model.set(column.termProperty, [], {
          silent: true
        });
      }
    }
    this.loadList(column);
  },
  loadList: function (column) {
    var models = OB.MobileApp.model.get(column.termProperty),
        columns = [];
    columns.push({
      id: '',
      name: ''
    });
    _.each(models, function (model) {
      var addModel = true,
          value;
      if (column.showValues && column.showValues.length > 0) {
        value = _.find(column.showValues, function (val) {
          return model[column.propertyId] === val;
        });
        addModel = value !== undefined;
      }
      if (column.excludeValues && column.excludeValues.length > 0) {
        value = _.find(column.excludeValues, function (val) {
          return model[column.propertyId] === val;
        });
        addModel = addModel && value === undefined;
      }
      if (addModel) {
        columns.push({
          id: model[column.propertyId],
          name: model[column.propertyName]
        });
      }
    });
    this.getCollection().reset(columns);
  },
  setValue: function (value) {
    this.setSelectedValue(value, 'id');
    if (this.hasRemoveButton) {
      if (value === '') {
        this.parent.hideRemove();
      } else {
        this.parent.showRemove();
      }
    }
  },
  setPresetValue: function (preset) {
    this.setValue(preset.id);
  },
  getCaption: function () {
    var index = this.getSelected();
    return index >= 0 ? this.getCollection().at(index).get('name') : '';
  },
  initComponents: function () {
    this.setCollection(new Backbone.Collection());
    this.getCollection().reset([]);
  }
});

enyo.kind({
  name: 'OB.UI.FilterSelectorText',
  kind: 'enyo.Input',
  type: 'text',
  classes: 'input narrow-input',
  handlers: {
    onkeyup: 'keyup'
  },
  setPresetValue: function (preset) {
    this.setValue(preset.name);
    this.keyup();
  },
  keyup: function (inSender, inEvent) {
    var value = this.getValue();
    if (this.hasRemoveButton) {
      if (value === '') {
        this.parent.hideRemove();
      } else {
        this.parent.showRemove();
      }
    }
    return true;
  }
});

enyo.kind({
  name: 'OB.UI.FilterSelectorRenderLine',
  kind: 'OB.UI.ListSelectorLine',
  allowHtml: true,
  components: [{
    name: 'line',
    style: 'line-height: 23px; width: 100%',
    components: [{
      name: 'textInfo',
      style: 'float: left; width: 91%; min-height: 32px; padding-top: 10px;',
      components: [{
        style: 'float: left; display: inline-block;',
        name: 'identifier'
      }, {
        style: 'float: left; display: inline-block; color: #888888; padding-left:5px;',
        name: 'filter'
      }, {
        style: 'clear: both;'
      }]
    }]
  }],
  create: function () {
    this.inherited(arguments);
    this.$.identifier.setContent(this.model.get('_identifier'));
    this.$.filter.setContent(this.model.get('filter'));
    this.render();
  }
});

enyo.kind({
  name: 'OB.UI.FilterSelectorTableHeader',
  published: {
    filters: null,
    showFields: true
  },
  events: {
    onSearchAction: '',
    onClearAllFilterSelector: ''
  },
  handlers: {
    onSetAdvancedSearchMode: 'setAdvancedSearchMode',
    onSearchActionByKey: 'searchAction',
    onFiltered: 'searchAction',
    onChangeColumn: 'changeColumn',
    onCloseCancelSelector: 'closeCancelSelector',
    onUpdateFilterSelector: 'updateFilterSelector'
  },
  components: [{
    components: [{
      style: 'display: table;',
      components: [{
        style: 'display: table-cell; width: 100%; vertical-align: middle; ',
        components: [{
          style: 'width: 100%;',
          name: 'advancedFilterInfo',
          showing: false,
          initComponents: function () {
            this.setContent(OB.I18N.getLabel('OBPOS_AdvancedFiltersApplied'));
          }
        }, {
          style: 'display: table; width: 100%;',
          name: 'filterInputs',
          components: [{
            style: 'display: table-cell; width: 35%; vertical-align: top',
            name: 'entityFilterColumnContainer',
            components: [{
              kind: 'OB.UI.List',
              name: 'entityFilterColumn',
              classes: 'combo',
              style: 'width: 95%; white-space: nowrap; margin-bottom: 0px',
              handlers: {
                onchange: 'changeColumn'
              },
              renderLine: enyo.kind({
                kind: 'enyo.Option',
                initComponents: function () {
                  this.inherited(arguments);
                  this.setValue(this.model.get('id'));
                  this.setContent(this.model.get('name'));
                }
              }),
              renderEmpty: 'enyo.Control',
              changeColumn: function () {
                this.owner.$.entityFilterText.removeClass('error');
                this.owner.$.dateFormatError.hide();
                this.owner.$.numberFormatError.hide();
                this.owner.$.entityFilterText.setValue('');
                this.owner.doClearAllFilterSelector();
                this.bubble('onChangeColumn', {
                  value: this.getValue()
                });
              },
              initComponents: function () {
                var columns = [];
                _.each(this.owner.filters, function (prop) {
                  if (prop.filter) {
                    columns.push({
                      id: prop.column,
                      name: OB.I18N.getLabel(prop.caption)
                    });
                  }
                });
                this.setCollection(new Backbone.Collection());
                this.getCollection().reset(columns);
              }
            }, {
              name: 'entityFilterLabel',
              style: 'text-align: right; padding: 10px 10px;',
              showing: false
            }]
          }, {
            style: 'display: table-cell; width: 65%; vertical-align: top',
            name: 'entitySearchContainer',
            components: [{
              kind: 'OB.UI.SearchInputAutoFilter',
              name: 'entityFilterText',
              hasRemoveButton: false,
              minLengthToSearch: 3,
              style: 'width: 100%; margin-bottom: 0px;'
            }, {
              kind: 'OB.UI.FilterSelectorList',
              name: 'entityFilterList',
              hasRemoveButton: false,
              style: 'width: 100%; margin-bottom: 0px'
            }, {
              kind: 'OB.UI.FilterSelectorAmount',
              name: 'entityFilterAmount',
              hasRemoveButton: false,
              style: 'width: 100%; margin-bottom: 0px'
            }, {
              kind: 'OB.UI.FilterSelectorButton',
              name: 'entityFilterButton',
              hasRemoveButton: false,
              style: 'width: 100%; margin-bottom: 0px'
            }]
          }]
        }, {
          style: 'padding-left: 10px',
          name: 'dateFormatError',
          showing: false,
          initComponents: function () {
            this.setContent(enyo.format(OB.I18N.getLabel('OBPOS_DateFormatError'), OB.I18N.getDateFormatLabel()));
          }
        }, {
          style: 'padding-left: 10px',
          name: 'numberFormatError',
          showing: false,
          initComponents: function () {
            this.setContent(OB.I18N.getLabel('OBPOS_NumberFormatError'));
          }
        }]
      }, {
        style: 'display: table-cell;',
        components: [{
          kind: 'OB.UI.SmallButton',
          classes: 'btnlink-gray btn-icon-small btn-icon-clear',
          style: 'width: 50px; margin: 4px 5px 4px 27px;',
          tap: function () {
            this.owner.clearFilter();
          }
        }]
      }, {
        style: 'display: table-cell;',
        components: [{
          kind: 'OB.UI.SmallButton',
          name: 'entitySearchBtn',
          classes: 'btnlink-yellow btn-icon-small btn-icon-search',
          style: 'width: 50px; margin: 4px 0px 4px 5px;',
          handlers: {
            onEnableSearch: 'enableSearch',
            onDisableSearch: 'disableSearch'
          },
          tap: function () {
            this.owner.searchAction();
          },
          putDisabled: function (status) {
            if (status === false) {
              this.setDisabled(false);
              this.removeClass('disabled');
              this.disabled = false;
              return;
            } else {
              this.setDisabled(true);
              this.addClass('disabled');
              this.disabled = true;
            }
          },
          enableSearch: function () {
            this.putDisabled(false);
          },
          disableSearch: function () {
            this.putDisabled(true);
          }
        }]
      }]
    }]
  }],
  closeCancelSelector: function (inSender, inEvent) {
    if (this.$.entityFilterButton.showSelector) {
      this.$.entityFilterButton.showSelector = false;
      this.owner.owner.owner.owner.owner.owner.show();
    }
    return true;
  },
  updateFilterSelector: function (inSender, inEvent) {
    if (this.$.entityFilterButton.showSelector) {
      this.$.entityFilterButton.showSelector = false;
      this.$.entityFilterButton.setSelectorValue(inEvent.selector.value, inEvent.selector.text);
      this.owner.owner.owner.owner.owner.owner.show();
    }
    return true;
  },
  changeColumn: function (inSender, inEvent) {
    var column = _.find(this.filters, function (flt) {
      return flt.column === inEvent.value;
    }, this);
    if (column) {
      this.$.entityFilterText.setShowing(!column.isList && !column.isAmount && !column.isSelector);
      this.$.entityFilterList.setShowing(column.isList === true);
      this.$.entityFilterAmount.setShowing(column.isAmount === true);
      this.$.entityFilterButton.setShowing(column.isSelector === true);
      if (column.isList) {
        this.$.entityFilterList.changeColumn(column);
      }
      if (column.isSelector) {
        this.$.entityFilterButton.selectorPopup = column.selectorPopup;
        this.$.entityFilterButton.filterName = column.name;
      }
    }
    return true;
  },
  searchAction: function () {
    var me = this,
        text, caption = null,
        value = this.fixedColumn ? this.fixedColumn.column : this.$.entityFilterColumn.getValue(),
        column = this.fixedColumn ? this.fixedColumn : _.find(this.filters, function (flt) {
        return flt.column === value;
      }, this),
        operator = column.operator;

    if (column.isList) {
      text = this.$.entityFilterList.getValue();
    } else if (column.isAmount) {
      text = this.$.entityFilterAmount.getValue();
      operator = this.$.entityFilterAmount.getOperator();
    } else if (column.isSelector) {
      text = this.$.entityFilterButton.getValue();
      caption = this.$.entityFilterButton.$.filterButton.getContent();
    } else {
      text = this.$.entityFilterText.getValue();
    }

    if (this.showFields && text !== '' && column && column.isDate) {
      var dateValidated = OB.Utilities.Date.OBToJS(text, OB.Format.date) || OB.Utilities.Date.OBToJS(text, 'yyyy-MM-dd');
      if (dateValidated) {
        text = OB.Utilities.Date.JSToOB(dateValidated, 'yyyy-MM-dd');
        me.$.dateFormatError.hide();
        this.$.entityFilterText.removeClass('error');
      } else {
        me.$.dateFormatError.show();
        this.$.entityFilterText.addClass('error');
        return;
      }
    }
    if (this.showFields && text !== '' && column && column.isNumeric) {
      if (!_.isNaN(OB.I18N.parseNumber(text))) {
        text = OB.I18N.parseNumber(text);
        this.$.entityFilterText.setValue(text);
        this.$.entityFilterText.removeClass('error');
        this.$.numberFormatError.hide();
      } else {
        this.$.entityFilterText.addClass('error');
        this.$.numberFormatError.show();
        return;
      }
    }
    var filters = [{
      operator: operator,
      column: this.showFields ? value : '_filter',
      value: text,
      hqlFilter: column.hqlFilter,
      isId: column.isSelector
    }];
    if (this.advancedFilterDialog) {
      this.bubble('onAdvancedFilterSelector', {
        name: this.advancedFilterDialog,
        filter: filters[0],
        caption: caption,
        operator: operator,
        callback: function (advancedFilters) {
          me.doSearchAction({
            filters: advancedFilters.filters,
            orderby: advancedFilters.orderby,
            advanced: false
          });
        }
      });
    } else {
      this.doSearchAction({
        filters: filters,
        advanced: false
      });
    }
    return true;
  },
  setFocus: function () {
    var item = null;
    if (this.$.entityFilterText.getShowing()) {
      item = this.$.entityFilterText;
    } else if (this.$.entityFilterAmount.getShowing()) {
      item = this.$.entityFilterAmount;
    } else if (this.$.entityFilterList.getShowing()) {
      item = this.$.entityFilterList;
    }
    if (item) {
      setTimeout(function () {
        item.focus();
      }, 200);
    }
  },
  clearFilter: function () {
    this.$.entityFilterText.setValue('');
    this.$.entityFilterText.removeClass('error');
    this.$.entityFilterList.setValue('');
    this.$.entityFilterAmount.setValue('');
    this.$.entityFilterButton.setValue('');
    this.$.entityFilterColumn.setSelected(0);
    this.$.entityFilterList.setSelected(0);
    this.$.advancedFilterInfo.setShowing(false);
    this.$.dateFormatError.hide();
    this.$.numberFormatError.hide();
    this.$.filterInputs.setShowing(true);
    this.$.entitySearchBtn.putDisabled(false);
    this.setAdvancedFilterBtnCaption();
    if (this.showFields && !this.fixedColumn) {
      this.changeColumn(this, {
        value: this.$.entityFilterColumn.getValue()
      });
    }
    this.doClearAllFilterSelector({
      name: this.advancedFilterDialog
    });
    return true;
  },
  setAdvancedFilterBtnCaption: function () {
    if (this.advancedFilterBtn && this.advancedFilterDialog) {
      var me = this;
      this.bubble('onCheckPresetFilterSelector', {
        name: this.advancedFilterDialog,
        callback: function (hasPreset) {
          if (hasPreset) {
            me.advancedFilterBtn.setContent('* ' + OB.I18N.getLabel(me.advancedFilterBtn.i18nLabel));
          } else {
            me.advancedFilterBtn.setContent(OB.I18N.getLabel(me.advancedFilterBtn.i18nLabel));
          }
        }
      });
    }
    return true;
  },
  setAdvancedSearchMode: function (inSender, inEvent) {
    this.$.advancedFilterInfo.setShowing(inEvent.isAdvanced);
    this.$.filterInputs.setShowing(!inEvent.isAdvanced);
    this.$.entitySearchBtn.putDisabled(inEvent.isAdvanced);
    if (inEvent.isAdvanced && this.advancedFilterBtn) {
      this.advancedFilterBtn.setContent(OB.I18N.getLabel(this.advancedFilterBtn.i18nLabel));
    }
    return true;
  },
  hideFilterCombo: function () {
    this.showFields = false;
    this.$.entityFilterColumnContainer.setStyle('display: none');
    this.$.entitySearchContainer.setStyle('display: table-cell; width: 425px;');
    return true;
  },
  fixColumn: function (column) {
    this.$.entityFilterColumn.hide();
    this.$.entityFilterLabel.show();
    this.$.entityFilterLabel.setContent(OB.I18N.getLabel(column.caption));
    this.changeColumn(null, {
      value: column.column
    });
    return true;
  },
  initComponents: function () {
    this.inherited(arguments);
    var fixed = _.find(this.filters, function (filter) {
      return filter.isFixed;
    });
    this.showFields = true;
    this.fixedColumn = fixed;
    if (fixed) {
      this.fixColumn(fixed);
    } else if (this.$.entityFilterColumn.collection.length > 0) {
      this.bubble('onChangeColumn', {
        value: this.$.entityFilterColumn.collection.at(0).id
      });
    }
  }
});
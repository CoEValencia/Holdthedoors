Ext.define('{appName}.view.page1.Page1VC', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.page1-controller',


    onPage1ButtonClick: function() {
        alert(i18n.page1.buttonPress);
    }
});

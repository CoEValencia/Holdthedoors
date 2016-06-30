Ext.define('{appName}.controller.main.MainController', {
    extend: 'Ext.app.Controller',

    requires: [
        '{appName}.view.main.i18n.Main_en_EN',
        '{appName}.view.main.i18n.Main_es_ES', 
        '{appName}.view.main.Home',
        '{appName}.view.main.Header',
        '{appName}.view.main.Menu',
        '{appName}.view.main.Content',
        '{appName}.view.main.LeftSidePanel', 
    ],

    onClickButton: function () {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    }
});

Ext.define('chirr.controller.main.MainController', {
    extend: 'Ext.app.Controller',

    requires: [
        'chirr.view.main.i18n.Main_en_EN',
        'chirr.view.main.i18n.Main_es_ES', 
        'chirr.view.main.Home',
        'chirr.view.main.Header',
        'chirr.view.main.Menu',
        'chirr.view.main.Content',
        'chirr.view.main.LeftSidePanel', 
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

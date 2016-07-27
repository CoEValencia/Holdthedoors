Ext.define('Sample.view.main.HeaderVC', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main-header',

    languageChange: function(combo) {
        Devon.I18n.setCurrentLocale(combo.getValue());
        location.reload();
    },

    onLogoffClick: function() {
        Devon.Security.logoutOperation();
    },

    onUserSettingsClick: function(){
    	Ext.Msg.alert('Opciones de usuario', 'Soon...');
    }
});

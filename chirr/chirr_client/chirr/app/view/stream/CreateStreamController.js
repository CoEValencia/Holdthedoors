Ext.define('Sample.view.stream.CreateStreamController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.createstream',

    requires: [
    ],

    onCancel: function(btn){
        this.getView().up('window').close();
    },

    onSave: function(btn){
        this.getView().up('window').close();
    },

    onTypeChange: function(cmp, newValue, oldValue){
        if(newValue){
            this.lookupReference('allowedUsers').show();
        }
        else{
            this.lookupReference('allowedUsers').hide();   
        }
    }

});

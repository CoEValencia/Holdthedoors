Ext.define('Sample.view.stream.CreateStreamController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.createstream',

    requires: [
    ],

    onCancel: function(btn){
        this.onCloseWindow();
    },

    onSave: function(btn){
        var me = this;
        var view = this.getView();

        var values = view.getValues();
        values.privated = false;
        values.userid = Devon.Security.currentUser.id;

        Devon.rest.streammanagement.stream.post({
            scope: this,
            jsonData: values,
            success: me.onCloseWindow()
        });   
    },

    onCloseWindow: function(){
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

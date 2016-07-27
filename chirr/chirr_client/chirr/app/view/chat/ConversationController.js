Ext.define('Sample.view.chat.ConversationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.conversation',

    requires: ['Ext.util.DelayedTask'],

    init: function(){
        this.control({
            'conversation': {
                afterrender: 'onChatRender',
                close: 'onClosePanel'
            }
        });

        this.callParent(arguments);
    },

    onStopTask: function(){
        if(this.myTask)
            Ext.TaskManager.stop(this.myTask);
    },

    onClosePanel: function(){
        if(this.myTask)
            Ext.TaskManager.stop(this.myTask);
    },

    onChatRender: function(view){
        var me = this;
        var dataview = this.getView().down('dataview');
        var store = dataview.getStore();
        var record = this.getView().params;

        me.myTask = Ext.TaskManager.start({
          run: function() {
            store.load({
                params: {'flowid': record.get('id')},
                callback: function(){
                    dataview.up().scrollBy(0, 999999, true);
                }
            });
          },
          interval: 1500
        });
    },

    onEnterPush: function(field, e){
        if (field.isValid() && e.getKey() == e.ENTER) {
            var record = this.getView().params;
            var dataview = this.getView().down('dataview');
            var form = this.lookupReference('conversationForm');
            var values = form.getValues();

            values.flowid = record.get('id');
            values.userid = Devon.Security.currentUser.id;

            form.reset();

            Devon.rest.messagemanagement.message.post({
                scope: this,
                jsonData: values
            });
        }
    },

    onMessageSendMe: function(){
        var record = this.getView().params;
        var dataview = this.getView().down('dataview');
        var form = this.lookupReference('conversationForm');
        var values = form.getValues();

        values.flowid = record.get('id');
        values.userid = Devon.Security.currentUser.id;

        if(form.isValid()){
            form.reset();

            Devon.rest.messagemanagement.message.post({
                scope: this,
                jsonData: values
            });   
        }
    }
});
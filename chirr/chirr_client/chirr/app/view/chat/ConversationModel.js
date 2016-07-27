Ext.define('Sample.view.chat.ConversationModel', {
    extend: 'Ext.app.ViewModel',
    requires: [
        'Sample.model.message.MessageM'
    ],
    alias: 'viewmodel.conversation',

    data: {
    },

    stores: {
        messages: {
            model: 'Sample.model.message.MessageM',
            proxy: {
                type : 'messagemanagement.search'
            },
            autoLoad:true
        }
    }

});

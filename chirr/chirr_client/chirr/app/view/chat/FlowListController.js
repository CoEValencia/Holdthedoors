Ext.define('Sample.view.chat.FlowListController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.flowlist',

    init: function(){
    	this.control({
    	});

    	this.callParent(arguments);
    },

    onFlowClick: function(list, record){
        var flowChat = this.getView().up('flowchat');
        var tabpanel = flowChat.down('tabpanel');
        flowChat.setLoading(true);

        var newConversation = new Sample.view.chat.Conversation({
            region: 'center',
            title: record.get('name'),
            name: record.get('name'),
            closable: true
        });

        var conversation = tabpanel.down('conversation[name="'+ record.get('name') + '"]');

        if(conversation != null){
            tabpanel.setActiveTab(conversation);
        }
        else{
            tabpanel.add(newConversation);
        }
        flowChat.setLoading(false);
    }
});

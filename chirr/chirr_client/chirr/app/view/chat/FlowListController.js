Ext.define('Sample.view.chat.FlowListController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.flowlist',

    init: function(){
    	this.control({
    	});

    	this.callParent(arguments);
    },

    onViewRender: function(view){
        var streamid = view.up('flowchat').streamid;

        view.setLoading(true);
        Ext.defer(function(){
            view.down('dataview').getStore().load({
                params: {'streamid': streamid},
                callback: function(){
                    view.setLoading(false);
                }
            });
        }, 800);
    },

    onFlowClick: function(list, record){
        var flowChat = this.getView().up('flowchat');
        var tabpanel = flowChat.down('tabpanel');
        flowChat.setLoading(true);

        var newConversation = new Sample.view.chat.Conversation({
            region: 'center',
            title: record.get('name'),
            name: record.get('name'),
            params: record,
            closable: true
        });

        var conversation = tabpanel.down('conversation[name="'+ record.get('name') + '"]');

        if(conversation != null){
            tabpanel.setActiveTab(conversation);
        }
        else{
            tabpanel.add(newConversation);
            tabpanel.setActiveTab(newConversation);
        }
        flowChat.setLoading(false);
    },

    onStreamSearch: function(cmp, newValue, oldValue){
        var view = this.getView();
        var dataview = view.down('dataview');
        var streamid = view.up('flowchat').streamid;

        if(newValue != null && newValue != ''){
            view.setLoading(true);
            view.down('dataview').getStore().load({
                params: {
                    'streamid': streamid,
                    'name': newValue
                },
                callback: function(){
                    view.setLoading(false);
                }
            });    
        }
    },

    onFlowCreate: function(){
        Ext.Msg.alert('Aviso', 'Soon...');
    }
});

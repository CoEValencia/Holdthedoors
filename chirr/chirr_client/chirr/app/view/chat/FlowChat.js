Ext.define("Sample.view.chat.FlowChat", {
    extend: "Ext.container.Container",
    alias: 'widget.flowchat',

    //controller: "createstream",
    requires: ['Sample.view.chat.FlowList',
    'Sample.view.chat.Conversation'],

    layout:'border',

    items: [{
        xtype: 'flowlist',
        title: 'My Flows',
        region:'west',
        width: 200,
        collapsible: true
    },{
        xtype: 'tabpanel',
        //title: 'Flow conversation',
        region: 'center'
    }]
});

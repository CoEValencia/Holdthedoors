Ext.define('Flow', {
    extend: 'Ext.data.Model',
    fields: [
        { name:'name', type:'string' },
        { name:'text', type: 'string'}
    ]
});

Ext.create('Ext.data.Store', {
    id:'flowStore',
    model: 'Flow',
    data: [
        { 
            name:'Flow Steve',
            text: 'Buenas!',
            notRead: 4
        },
        { 
            name:'Flow Jhonny',
            text: '¿Que tal?',
            notRead: 10
        },
        { 
            name:'Flow James',
            text: '¿Bien?',
            notRead: 1
        },
        { 
            name:'Flow Quicks',
            text: 'Si bueno...',
            notRead: 12
        }
    ]
});

Ext.define("Sample.view.chat.FlowList", {
    extend: "Ext.panel.Panel",
    alias: 'widget.flowlist',

    requires:['Sample.view.chat.FlowListController'],
    controller: "flowlist",

    layout:{
        type: 'vbox',
        align: 'stretch'
    },

    defaults: { padding: 5},

    items: [{
        xtype: 'textfield',
        name: 'flowName',
        emptyText: 'Search flow...'
    },{
        xtype: 'dataview',
        flex: 0.9,
        tpl:new Ext.XTemplate(
            '<tpl for=".">',
                '<div class="mainflow">',
                      '<div>{name} <b>({notRead})</b></div>',
                '</div>',
            '</tpl>'
        ),
        itemSelector: 'div.mainflow',
        emptyText: 'No images available',
        store: Ext.data.StoreManager.lookup('flowStore'),
        listeners: {
            itemdblclick: 'onFlowClick'
        }
    }]
});

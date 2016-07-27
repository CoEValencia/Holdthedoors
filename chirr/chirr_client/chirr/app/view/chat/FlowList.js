Ext.define("Sample.view.chat.FlowList", {
    extend: "Ext.panel.Panel",
    alias: 'widget.flowlist',

    requires:['Sample.view.chat.FlowListController', 
              'Sample.view.chat.FlowListModel'
    ],
    controller: "flowlist",
    viewModel: {
        type: "flowlist"
    },

    layout:{
        type: 'vbox',
        align: 'stretch'
    },

    defaults: { padding: 10},

    items: [{
        xtype: 'textfield',
        name: 'name',
        emptyText: 'Search flow...',
        allowOnlyWhiteSpace: false,
        listeners: {
            change: 'onStreamSearch'
        }
    },{
        xtype: 'dataview',
        flex: 0.9,
        tpl:new Ext.XTemplate(
            '<tpl for=".">',
                '<div class="mainflow">',
                      '<div>{name} <b>({userid})</b></div>',
                '</div>',
            '</tpl>'
        ),
        itemSelector: 'div.mainflow',
        emptyText: 'No images available',
        bind: {
            store: '{flows}'
        },
        listeners: {
            itemdblclick: 'onFlowClick'
        }
    }],

    tbar: [{
        xtype: 'button',
        text: 'Crear Flow',
        iconCls: 'fa fa-plus',
        listeners: {
            click: 'onFlowCreate'
        }
    }],

    listeners: {
        afterrender: 'onViewRender'
    }
});

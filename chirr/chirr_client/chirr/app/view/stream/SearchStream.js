Ext.create('Ext.data.Store', {
    storeId:'streamStore',
    fields:['id', 'name', 'privated','userid'],
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});


Ext.define("Sample.view.stream.SearchStream", {
    extend: "Ext.panel.Panel",
    alias: 'widget.searchstream',

    requires: [
        'Ext.grid.Panel',
        'Sample.view.stream.SearchStreamModel'
    ],

    padding: 30,
    border: true,

    controller: "searchstream",
    title: 'Select stream',
    viewModel: {
        type: "searchstream"
    },

    layout:{
        type:'vbox',
        align:'stretch'
    },

    items: [{
        xtype: 'combobox',
        reference: 'streamCombo',
        emptyText: 'Search streams...',
        bind: {
            store: '{streams}'
        },
        displayField: 'name',
        valueField: 'name',
        listeners: {
            select: 'onSelectStream'
        }
    },{
        xtype: 'grid',
        store: Ext.data.StoreManager.lookup('streamStore'),
        columns: [
            { text: 'Name', dataIndex: 'name', flex: 1 },
            { text: 'User', dataIndex: 'userid', flex: 1 },
            { 
                xtype: 'widgetcolumn',
                text: 'Action',
                widget: {
                    xtype: 'button',
                    text: '',
                    iconCls: 'fa fa-trash',
                    listeners: {
                        click: 'onGridDeleteRecord'
                    }
                },
                onWidgetAttach: 'onWidgetRender'
            }
        ],
        flex: 1,
        listeners: {
            itemdblclick: 'onRowClick'
        }
    }],

    bbar:[{
        text: 'Create Stream',
        flex: 1,
        listeners: {
            click: 'onCreateStream'
        }
    }]
});

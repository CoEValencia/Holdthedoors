Ext.create('Ext.data.Store', {
    storeId:'simpsonsStore',
    fields:['name', 'email', 'phone'],
    data:{'items':[
        { 'name': 'Stream Juegos',  "email":"lisa@simpsons.com",  "phone":"555-111-1224"  },
        { 'name': 'Stream Devon',  "email":"bart@simpsons.com",  "phone":"555-222-1234" },
        { 'name': 'Stream Rasca', "email":"homer@simpsons.com",  "phone":"555-222-1244"  },
        { 'name': 'Stream Pica', "email":"marge@simpsons.com", "phone":"555-222-1254"  }
    ]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});

Ext.create('Ext.data.Store', {
    storeId:'simpsonsStore2',
    fields:['name', 'email', 'phone'],
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
        'Ext.grid.Panel'
    ],

    padding: 30,
    border: true,

    //controller: "cook-controller",
    title: 'Select stream',
    /*viewModel: {
        type: "cook-model"
    },*/

    layout:{
        type:'vbox',
        align:'stretch'
    },

    items: [{
        xtype: 'combobox',
        emptyText: 'Search streams...',
        store: Ext.data.StoreManager.lookup('simpsonsStore'),
        displayField: 'name',
        valueField: 'name',
        listeners: {
            select: function(combo, record){
                combo.up().down('grid').getStore().add(record.data);
            }
        }
    },{
        xtype: 'grid',
        store: Ext.data.StoreManager.lookup('simpsonsStore2'),
        columns: [
            { text: 'Name', dataIndex: 'name', flex: 1 },
            { 
                xtype: 'widgetcolumn',
                text: 'Action',
                widget: {
                    xtype: 'button',
                    text: '',
                    iconCls: 'fa fa-trash',
                    listeners: {
                        click: function(btn){
                            var record = btn.getWidgetRecord();
                            btn.up('grid').getStore().remove(record);
                        }
                    }
                }
            }
        ],
        flex: 1,
        listeners: {
            afterrender: function(view){
            }
        }
    }],

    bbar:[{
        text: 'Create Stream'
    }]
});

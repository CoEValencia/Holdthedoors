Ext.create('Ext.data.Store', {
    storeId:'simpsonsStore',
    fields:['name', 'email', 'phone'],
    data:{'items':[
        { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "phone":"555-111-1224"  },
        { 'name': 'Bart',  "email":"bart@simpsons.com",  "phone":"555-222-1234" },
        { 'name': 'Homer', "email":"homer@simpsons.com",  "phone":"555-222-1244"  },
        { 'name': 'Marge', "email":"marge@simpsons.com", "phone":"555-222-1254"  }
    ]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});

Ext.define("Sample.view.stream.CreateStream", {
    extend: "Ext.form.Panel",
    alias: 'widget.createstream',

    padding: 30,
    border: true,

    controller: "createstream",
    requires: [
        'Ext.grid.Panel'
    ],

    layout:{
        type:'vbox',
        align:'stretch'
    },

    items: [{
        xtype: 'textfield',
        fieldLabel: 'Stream name',
        name: 'name'
    },{
        xtype: 'checkbox',
        name: 'privated',
        fieldLabel: 'Private',
        disabled: true,
        listeners: {
            //change: 'onTypeChange'
        }
    },{
        xtype: 'tagfield',
        reference: 'allowedUsers',
        name: 'users',
        displayField: 'name',
        valueField: 'name',
        store: Ext.data.StoreManager.lookup('simpsonsStore'),
        fieldLabel: 'Members',
        height: 150,
        hidden: true
    }],

    bbar:[{
        text: 'Cancel',
        flex: 1,
        listeners: {
            click: 'onCancel'
        }
    },{
        text: 'Save',
        flex: 1,
        margin: '0 0 0 10',
        listeners: {
            click: 'onSave'
        }
    }]
});

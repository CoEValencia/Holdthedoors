Ext.define('Sample.model.flow.FlowM', {
    extend: 'Ext.data.Model',

    fields: [{
            name: 'id',
            type: 'auto'
        },
        'name',
        {
            name: 'userid',
            type: 'auto'
        },
        {
            name: 'streamid',
            type: 'auto'
        }
    ]

});

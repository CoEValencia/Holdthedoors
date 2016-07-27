Ext.define('Sample.model.stream.StreamM', {
    extend: 'Ext.data.Model',

    fields: [{
            name: 'id',
            type: 'auto'
        },
        'name',
        {
            name: 'privated',
            type: 'auto'
        },
        {
            name: 'userid',
            type: 'auto'
        }
    ]

});

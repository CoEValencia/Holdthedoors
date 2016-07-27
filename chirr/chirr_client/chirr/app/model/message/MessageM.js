Ext.define('Sample.model.message.MessageM', {
    extend: 'Ext.data.Model',

    fields: [{
            name: 'id',
            type: 'auto'
        },
        'content',
        {
            name: 'userid',
            type: 'auto'
        },
        {
            name: 'flowid',
            type: 'auto'
        }
    ]

});

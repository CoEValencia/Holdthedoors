Ext.define('Sample.view.stream.SearchStreamModel', {
    extend: 'Ext.app.ViewModel',
    requires: [
        'Sample.model.stream.StreamM'
    ],
    alias: 'viewmodel.searchstream',

    data: {
    },

    stores: {
        streams: {
            model: 'Sample.model.stream.StreamM',
            proxy: {
                type : 'streammanagement.streams'
            },
            autoLoad:false,
            remoteSort: false,
            remoteFilter:true,
            sorters: {
                property: 'name',
                direction: 'ASC'
            }
        }
    }

});

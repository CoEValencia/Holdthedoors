Ext.define('Sample.view.chat.FlowListModel', {
    extend: 'Ext.app.ViewModel',
    requires: [
        'Sample.model.flow.FlowM'
    ],
    alias: 'viewmodel.flowlist',

    data: {
    },

    stores: {
        flows: {
            model: 'Sample.model.flow.FlowM',
            proxy: {
                type : 'flowmanagement.search'
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

Ext.define('Sample.controller.cook.CookController', {
    extend: 'Ext.app.Controller',

    requires: [
        'Sample.view.cook.i18n.Cook_en_EN',
        'Sample.view.cook.i18n.Cook_es_ES',
        'Sample.view.cook.Cook',
        'Sample.view.stream.SearchStream'
    ],

    config: {
        listen: {
            global: {
                event_menuOpenPositions: 'onMenuOpenPositions',
                eventStreamSearch: 'onStreamSearch',
            }
        }
    },
    
    init: function() {
        Devon.Ajax.define({
            /*'salesmanagement.order': {
                url: 'salesmanagement/v1/order/{id}'
            },*/
            'salesmanagement.orderposition': {
                url: 'salesmanagement/v1/orderposition'
            }
        });
    },

    onMenuOpenPositions: function(data) {
        var positions = new Sample.view.cook.Cook({
            viewModel: {
                data: data
            }
        });
        Devon.App.openInContentPanel(positions);
    },

    onStreamSearch: function(options){
        var tables = new Sample.view.stream.SearchStream(options);

        Devon.App.openInContentPanel(tables);
    }
});

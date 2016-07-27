Ext.define('Sample.controller.main.MainController', {
    extend: 'Ext.app.Controller',

    requires: [
        'Sample.view.main.i18n.Main_en_EN',
        'Sample.view.main.i18n.Main_es_ES',
        'Sample.model.main.Recent',
        'Sample.view.main.Home',
        'Sample.view.main.Header',
        'Sample.view.main.Menu',
        'Sample.view.main.Content',
        'Sample.view.main.LeftSidePanel',
        'Sample.view.main.RestaurantStatus',
        'Sample.view.main.Recent'
    ],

    init: function() {
        Devon.Ajax.define({
            'streammanagement.stream': {
                url: 'streammanagement/v1/stream/{id}'
            },
            'streammanagement.streams': {
                url: 'streammanagement/v1/stream'
            }, 
            'streammanagement.search': {
                url: 'streammanagement/v1/stream/search',
                pagination: false
            },
            'flowmanagement.search': {
                url: 'flowmanagement/v1/flow/search',
                pagination: true
            },
            'messagemanagement.search': {
                url: 'messagemanagement/v1/message/search',
                pagination: true
            },
            'messagemanagement.message': {
                url: 'messagemanagement/v1/message/{id}'
            },
            'usermanagement.search': {
                url: 'usermanagement/v1/user/search'
            }
        });

        console.log('My rest services defined');
    }
});

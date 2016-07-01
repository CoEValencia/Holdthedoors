Ext.define('Sample.view.stream.SearchStreamController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.searchstream',

    requires: [
        'Sample.view.stream.CreateStream',
        'Sample.view.chat.FlowList'
    ],

    onCreateStream: function(btn){
        Ext.create('Ext.window.Window', {
            title: 'Create Stream',
            height: 500,
            width: 900,
            layout: 'fit',
            modal: true,
            items: {  // Let's put an empty grid in just to illustrate fit layout
                xtype: 'createstream'
            }
        }).show();
    },

    onRowClick: function(grid, record, item){
        var panel = new Sample.view.chat.FlowChat({
            title: record.get('name'),
            closable:true
        });
        Devon.App.openInContentPanel(panel, {id: 1});
    }

});

Ext.define('Sample.view.stream.SearchStreamController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.searchstream',

    requires: [
        'Sample.view.stream.CreateStream',
        'Sample.view.chat.FlowList'
    ],

    init: function(){
        Devon.rest.usermanagement.search.post({
            scope: this,
            jsonData: {
                'username': Devon.Security.currentUser.name
            },
            success: function(user) {
                if(user){
                    Devon.Security.currentUser.id = user.result[0].id;
                }
            }
        }); 
    },

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
            closable:false,
            streamid: record.get('id')
        });
        Devon.App.openInContentPanel(panel);
    },

    onSelectStream: function(combo, record){
        combo.up().down('grid').getStore().add(record.data);
    },

    onGridDeleteRecord: function(btn){
        var record = btn.getWidgetRecord();
        var me = this;
        var combo = me.lookupReference('streamCombo');

        Devon.rest.streammanagement.stream.del({
            scope: this,
            uriParams: {
                id: record.get('id')
            },
            success: function(stream) {
                btn.up('grid').getStore().remove(record);
                combo.reset();
                combo.getStore().reload();
            }
        }); 
    },

    onWidgetRender: function(column, btn, record){
        if(record.get('userid') != Devon.Security.currentUser.id)
            btn.disable();
    }

});

Ext.define('Devon.view.main.ViewportLogin', {
    extend: 'Ext.container.Viewport',
    requires: [],

    xtype: 'main-viewport-login',

    layout: {
        type: 'vbox',
		align: 'stretch',
		pack: 'center'
    },

    initComponent: function() {
        this.items = Devon.Array.defineIf([{
			defineIf: Devon.Class.isDefined('widget.main-login'),
            xtype: 'main-login'
        }]);
        this.callParent();
    }

});

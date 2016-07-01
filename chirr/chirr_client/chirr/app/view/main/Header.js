Ext.define('Sample.view.main.Header', {
    extend: 'Ext.Panel',

    alias: 'widget.main-header',

    requires: [
        'Ext.Img',
        'Sample.view.main.HeaderVC'
    ],

    layout: {
        type: 'hbox',
        align: 'middle'
    },
    border: false,

    controller: 'main-header',

    //cls: 'main-header',
    bodyStyle: 'background: #3fc462 !important; ',
    height: 70,

    defaults: {
        border: false,
        bodyStyle: 'background: #3fc462 !important; '
    },

    items: [{
        xtype: 'image',
        src: './resources/logoChirr.png',
        width: 339,
        height: 65,
        margin: '0 20'
    }, {
    	xtype: 'component',
    	flex:1
    }, {
        xtype: 'label',
        html: i18n.main.header.title,
        style: 'margin-right:5px',
        bind: {
            text: i18n.main.loggedInAs + '{currentUser.firstName} {currentUser.lastName}'
        }
    },
    /*{
        xtype: 'combobox',
        style: 'margin-right:5px',
        editable: false,
        width: 100,
        queryMode: 'local',
        valueField: 'value',
        forceSelection: true,
        value: Devon.I18n.currentLocale,
        store: {
            fields: ['text', 'value'],
            data: [{
                'text': 'English',
                'value': 'en_EN'
            }, {
                'text': 'Castellano',
                'value': 'es_ES'
            }]
        },
        listeners: {
            change: 'languageChange'
        }
    }, */
    {
        xtype: 'button',
        style: 'margin-right:5px',
        iconCls: 'fa fa-cog'
    },
    {
        xtype: 'button',
        style: 'margin-right:5px',
        //text: i18n.main.logOffButton,
        iconCls: 'fa fa-power-off',
        handler: 'onLogoffClick'
    }]
});

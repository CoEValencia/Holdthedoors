Ext.define('{appName}.view.main.Home', {
    extend: 'Ext.Panel',
    alias: 'widget.main-home',

    title: i18n.main.home.tabTitle,
    closable: false,
    padding: 50,

    html: i18n.main.home.content

});

/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 *
 *
 */
Ext.define('chirr.Application', {
    extend: 'Devon.App',

    name: 'chirr', 

    controllers: [
        'chirr.controller.main.MainController',
        'chirr.controller.page1.Page1Controller'
    ],

    launch: function() {
        Devon.Log.trace('chirr.app launch');
        console.log('chirr.app launch'); 
        
        this.callParent(arguments);
    }
});

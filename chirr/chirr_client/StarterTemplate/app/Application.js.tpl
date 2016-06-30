/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 *
 *
 */
Ext.define('{appName}.Application', {
    extend: 'Devon.App',

    name: '{appName}', 

    controllers: [
        '{appName}.controller.main.MainController',
        '{appName}.controller.page1.Page1Controller'
    ],

    launch: function() {
        Devon.Log.trace('{appName}.app launch');
        console.log('{appName}.app launch'); 
        
        this.callParent(arguments);
    }
});

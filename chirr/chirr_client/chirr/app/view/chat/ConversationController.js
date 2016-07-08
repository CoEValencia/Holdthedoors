Ext.define('Sample.view.chat.ConversationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.conversation',

    requires: ['Ext.util.DelayedTask'],

    init: function(){
    	this.control({
    		'conversation': {
    			beforerender: 'onChatRender',
                close: 'onClosePanel'
    		}
    	});

    	this.callParent(arguments);
    },

    onStopTask: function(){
        if(this.myTask)
            Ext.TaskManager.stop(this.myTask);
    },

    onClosePanel: function(){
        if(this.myTask)
            Ext.TaskManager.stop(this.myTask);
    },

    onChatRender: function(view){
    	var me = this;
    	var dataview = this.getView().down('dataview');
    	var store = dataview.getStore();

        this.myTask = Ext.TaskManager.start({
		  run: function() {
		  	store.add({
				img: 'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN',
				name: 'Jhonatan Core',
				text: 'Mensaje ' + Math.random(),
				date: new Date()
			});
			dataview.up().scrollBy(0, 999999, true);
		  },
		  interval: 1500
		});
    },

    onOpenChatClick: function(btn){
    	this.getView().down('#contentPanel').removeAll();

    	var chat = Ext.create('chirr.view.chat.ChirrChatView');

    	this.getView().down('#contentPanel').add(chat);
    },

    onMessageSendOther: function(){
    	var dataview = this.getView().down('dataview');
    	var store = dataview.getStore();
    	var text = this.lookupReference('messageField');

    	store.add({
			img: 'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN',
			name: 'Jhonatan Core',
			text: text.getValue(),
			date: new Date()
		});

		dataview.up().scrollBy(0, 999999, true);
        text.reset();
    },

    onMessageSendMe: function(){
    	var dataview = this.getView().down('dataview');
    	var store = dataview.getStore();
    	var text = this.lookupReference('messageField');

    	store.add({
			img: 'https://mug0.assets-yammer.com/mugshot/images/75x75/RNgqbtFHFwRQLmlh93WZs3PTM6btWgSD',
			name: 'Quique Mateu',
			text: text.getValue(),
			date: new Date()
		});

		dataview.up().scrollBy(0, 999999, true);
        text.reset();
    }
});

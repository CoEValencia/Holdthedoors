Ext.define('Image', {
    extend: 'Ext.data.Model',
    fields: [
        { name:'img', type:'string' },
        { name:'name', type:'string' },
        { name:'text', type: 'string'}
    ]
});

Ext.create('Ext.data.Store', {
    id:'imagesStore',
    model: 'Image',
    data: [
        { 
        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
        	name:'Jhonatan Core',
        	text: 'Buenas!',
        	date: new Date()
        },
        { 
        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
        	name:'Jhonatan Core',
        	text: '¿Que tal?',
        	date: new Date()
        },
        { 
        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
        	name:'Jhonatan Core',
        	text: '¿Bien?',
        	date: new Date()
        },
        { 
        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
        	name:'Jhonatan Core',
        	text: 'Si bueno...',
        	date: new Date()
        }
    ]
});


Ext.define('Sample.view.chat.Conversation',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.conversation',

	layout: 'border',

	requires: ['Sample.view.chat.ConversationController'],
	controller: 'conversation',

	initComponent: function(){
        Ext.apply(this, {
           items:[this.getChatPanel()]
        });
      
        this.callParent(arguments);  
    },

	getChatPanel: function(){
		return {
			xtype: 'panel',
			region: 'center',
			layout: {
				type: 'vbox',
				align: 'stretch'
			},
			items:[{
				xtype: 'panel',
				layout: 'fit',
				scrollable: true,
				flex: 1,
				items:[{
					xtype: 'dataview',
					store: this.getConversationStore(),
				    tpl:new Ext.XTemplate(
					    '<tpl for=".">',
					    	'<div class="MainPanel">',
						    	"<tpl if='name == \"Quique Mateu\"'>",
						    		'<div class="FloatingSectionRight">',
						    	"<tpl else>",
						    		'<div class="FloatingSectionLeft">',
								"</tpl>",
						          '<img class= "userImg" src="{img}"></img>',
						          '<div class="nameDiv">{name} - {date:date("h:i:s")}</div>',
								  '<div class="textDiv">{text}</div>',
						        '</div>',
					        '</div><br/>',
					    '</tpl>'
					),
				    itemSelector: 'div.MainPanel',
				    emptyText: 'No images available'
				}]
			},{
				xtype:'form',
		        collapsible: true,
		        height: 100,
		        layout: {
					type: 'hbox',
					align: 'stretch'
				},
		        items: [{
					xtype: 'textfield',
					reference: 'messageField',
					border: true,
					margin: '0 0 0 5',
					flex: 0.8
				},{
					xtype: 'button',
					text: 'Enviar como yo',
					margin: '0 0 0 10',
					flex: 0.2,
					listeners: {
						click: 'onMessageSendMe'
					}
				},{
					xtype: 'button',
					text: 'Enviar como Jhonny',
					margin: '0 0 0 10',
					flex: 0.2,
					listeners: {
						click: 'onMessageSendOther'
					}
				},{
					xtype: 'button',
					text: 'Stop task',
					margin: '0 0 0 10',
					flex: 0.2,
					listeners: {
						click: 'onStopTask'
					}
				}]
			}]
		};
	},

	getConversationStore: function(){
		var store = Ext.create('Ext.data.Store', {
		    id:'imagesStore',
		    model: 'Image',
		    name:'storeconversation_'+Math.random(),
		    data: [
		        { 
		        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
		        	name:'Jhonatan Core',
		        	text: 'Buenas!',
		        	date: new Date()
		        },
		        { 
		        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
		        	name:'Jhonatan Core',
		        	text: '¿Que tal?',
		        	date: new Date()
		        },
		        { 
		        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
		        	name:'Jhonatan Core',
		        	text: '¿Bien?',
		        	date: new Date()
		        },
		        { 
		        	img:'https://mug0.assets-yammer.com/mugshot/images/48x48/8rzxMRRZ3xVVJ92vcsVssZqlsB8b1FwN', 
		        	name:'Jhonatan Core',
		        	text: 'Si bueno...',
		        	date: new Date()
		        }
		    ]
		});

		return store;
	}
});
Ext.define('Sample.view.chat.Conversation',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.conversation',

	layout: 'border',

	requires: ['Sample.view.chat.ConversationController',
			   'Sample.view.chat.ConversationModel'
   ],
	controller: 'conversation',
	viewModel: {
		type: 'conversation'
	},

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
				overflowY: 'auto',
				flex: 1,
				items:[{
					xtype: 'dataview',
					/*bind: {
			            store: '{messages}'
			        },*/
			        store: this.getConversationStore(),
					padding: 10,
					loadMask: false,
				    tpl:new Ext.XTemplate(
					    '<tpl for=".">',
					    	'<div class="MainPanel">',
						    	"<tpl if='userid == Devon.Security.currentUser.id'>",
						    		'<img style="float:right" class= "userImg" src="resources/user.png"></img>',
						    		'<div class="FloatingSectionRight">',
						    	"<tpl else>",
						    		'<img style="float:left" class= "userImg" src="resources/user.png"></img>',
						    		'<div class="FloatingSectionLeft">',
						    		'<p class="nameDiv"><b>User: {userid}</b></p>',
								"</tpl>",
						          //'<img style="float:right" class= "userImg" src="resources/user.png"></img>',
						          //'<div class="nameDiv">{name} - {date:date("h:i:s")}</div>',
						          //'<div class="nameDiv">User: {userid}</div>',
								  '<div class="textDiv">{content}</div>',
								  //'<div><time>User: {userid}</time></div>',
						        '</div>',
					        '</div><br/>',
					    '</tpl>'
					),
				    itemSelector: 'div.MainPanel',
				    emptyText: 'Sin mensajes...'
				}]
			},{
				xtype:'form',
		        collapsible: false,
		        reference: 'conversationForm',
		        height: 100,
		        layout: {
					type: 'hbox',
					align: 'stretch'
				},
				padding: 10,
				defaults: {padding: 10},
		        items: [{
					xtype: 'textfield',
					reference: 'messageField',
					name: 'content',
					border: true,
					margin: '0 0 0 5',
					allowOnlyWhitespace: false,
					allowBlank: false,
					invalidCls: 'invalidMsg',
					flex: 0.8,
					listeners:{
						specialkey: 'onEnterPush'
					}
				},{
					xtype: 'button',
					text: 'Enviar',
					margin: '0 0 0 10',
					flex: 0.2,
					listeners: {
						click: 'onMessageSendMe'
					}
				}]
			}]
		};
	},

	getConversationStore: function(){
		var store = Ext.create('Ext.data.Store', {
		    id:'imagesStore',
		    requires: ['Sample.model.message.MessageM'],
		    model: 'Sample.model.message.MessageM',
		    name:'storeconversation_'+Math.random(),
		    proxy: {
                type : 'messagemanagement.search'
            }
		});

		return store;
	}
});
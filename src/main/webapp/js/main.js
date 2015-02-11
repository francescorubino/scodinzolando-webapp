// Set the require.js configuration for your application.
require.config({

	shim : {
		'underscore' : {
			exports : '_'
		},
		'underscore-string' : {
			deps : [ 'underscore' ]
		},
		'handlebars-orig' : {
			exports : 'Handlebars'
		},
		'backbone' : {
			deps : [ 'underscore', 'underscore-string', 'jquery' ],
			exports : 'Backbone'
		},
		'backbone-queryparams' : {
			deps : [ 'backbone' ],
			exports : 'Backbone'
		},
		'backbone-datagrid' : {
			deps : [ 'backbone' ],
			exports : 'Backbone.Datagrid'
		},
		'backbone-paginator' : {
			deps : [ 'backbone' ],
			exports : 'Backbone.Paginator'
		},
		'bootstrap' : {
			deps : [ 'jquery' ]
		},
		'backbone-associations' : {
			deps : [ 'backbone' ]
		},
		'keymaster' : {
			exports : 'key'
		},
		'async' : {
			exports : 'async'
		},
		'jssor' : {
			deps : [ 'jquery' ],
		},
		'jssor-slider' : {
			deps : [ 'jquery', 'jssor' ],
        	exports : "jssor-slider"
		},
		'eventCalendar' : {
			deps : [ 'jquery'],
			exports : "eventCalendar"
		},
		'timeago' : {
			deps : [ 'jquery'],
			exports : "timeago"
		},
		'colorbox' : {
			deps : [ 'jquery' ],
			exports : "colorbox"
		},
		'calendar' : {
			deps : [ 'jquery', 'moment' ],
			exports : "calendar"
		},
	},

	// Libraries
	paths : {
		jquery : 'lib/jquery',
		underscore : 'lib/underscore',
		'underscore-string' : 'lib/underscore-string',
		backbone : 'lib/backbone',
		resthub : 'lib/resthub/resthub',

		text : 'lib/text',
		i18n : 'lib/i18n',
		'bootstrap' : 'lib/bootstrap',
		'backbone-validation-orig' : 'lib/backbone-validation',
		'backbone-validation' : 'lib/resthub/backbone-validation-ext',
		'handlebars-orig' : 'lib/handlebars',
		'handlebars' : 'lib/resthub/handlebars-helpers',
		'backbone-queryparams' : 'lib/backbone-queryparams',
		'backbone-datagrid' : 'lib/backbone-datagrid',
		'backbone-paginator' : 'lib/backbone-paginator',
		'backbone-associations' : 'lib/backbone-associations',
		'backbone-localstorage' : 'lib/backbone-localstorage',
		async : 'lib/async',
		keymaster : 'lib/keymaster',
		hbs : 'lib/resthub/require-handlebars',
		moment : 'lib/moment.min',
		template : '../template',
		json2 : 'lib/json2',
		console : 'lib/resthub/console',
		'jssor' : 'lib/jssor/jssor',
		'jssor-slider' : 'lib/jssor/jssor.slider',
		'eventCalendar' : 'lib/eventCalendar/jquery.eventCalendar',
		'timeago' : 'lib/eventCalendar/jquery.timeago',
		'colorbox' : 'lib/colorbox/jquery.colorbox',
		'calendar' : 'lib/calendar/fullcalendar',
	},
	locale: localStorage.getItem('locale') || 'it-it'
});

// Load our app module and pass it to our definition function
require([ 'console', 'app' ]);

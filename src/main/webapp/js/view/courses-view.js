define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/courses-view',
		'calendar' ], function(Backbone, Resthub, myLabels, coursesTemplate) {

	var CoursesView = Resthub.View.extend({

		// Define view template
		template : coursesTemplate,
		labels : myLabels,

		initialize : function() {
			this.render();
		},

		render : function() {
			CoursesView.__super__.render.apply(this, arguments);

			$('#calendar').fullCalendar({
				defaultDate : '2015-02-12',
				editable : true,
				eventLimit : true,
				events : {
					url : "calendar/events",
					cache : true
				}
			});
		}

	});
	return CoursesView;
});
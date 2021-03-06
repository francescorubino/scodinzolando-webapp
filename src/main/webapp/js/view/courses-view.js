define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/courses-view',
		'calendar', 'gcal' ], function(Backbone, Resthub, myLabels, coursesTemplate) {

	var CoursesView = Resthub.View.extend({

		// Define view template
		template : coursesTemplate,
		labels : myLabels,

		initialize : function() {
			this.render();
		},

		render : function() {
			CoursesView.__super__.render.apply(this, arguments);

//			var startDate = this.getStartDate();
//			
//			$('#calendar').fullCalendar({
//				googleCalendarApiKey: 'AIzaSyCSC5CaR2BV6OIQvEURkV4xZAXJBcQU4l8',
//				defaultDate : startDate,
//				editable : false,
//				eventLimit : false,
//				events : {
////					googleCalendarId: "7i3jq0tper8bo08v662a80bmrk@group.calendar.google.com",
//					googleCalendarId: "C07MG63K76JFH42RLE1ITJ3B68@group.calendar.google.com",
//					
//				},
//				eventColor: "#CEA04B"
//			});
//			
//			$("#gFrame").contents().find(".agenda-more").css("color", "white");
			
		},
		
		getStartDate : function() {
			var today = new Date();
			var yyyy = today.getFullYear();
			var mm = today.getMonth()+1;
			if(mm<10) {
			    mm='0'+mm
			} 
			return yyyy+"-"+mm+"-01";
		}

	});
	return CoursesView;
});
define([ 'backbone', 'view/home-view', 'view/activity-view', 'view/activityDetails-view', 'view/courses-view', 'view/album-view', 'view/instructors-view',
		'view/contacts-view', 'view/menu-view' ], function(Backbone, HomeView,
		ActivityView, ActivityDetailsView, CoursesView, AlbumView, InstructorsView, ContactsView, MenuView) {

	var AppRouter = Backbone.Router.extend({

		initialize : function() {
			new MenuView({
				root : $('#menu')
			});
			Backbone.history.start({
				pushState : false,
				root : "/"
			});
		},

		routes : {
			'' : 'home',
			'home' : 'home',
			'activity' : 'activity',
			'activity/:id' : 'activityDetails',
			'courses' : 'courses',
			'album' : 'album',
			'instructors' : 'instructors',
			'contacts' : 'contacts'
		},

		home : function() {
			this.updateNavbarActive("#liHome");
			new HomeView({
				root : $('#main')
			});
		},

		activity : function() {
			this.updateNavbarActive("#liActivity");
			new ActivityView({
				root : $('#main')
			});
		},

		activityDetails : function(id) {
			this.updateNavbarActive("#liActivity");
			new ActivityDetailsView({
				root : $('#main'),
				activityId : id
			});
		},

		album : function() {
			this.updateNavbarActive("#liAlbum");
			new AlbumView({
				root : $('#main')
			});
		},
		
		courses : function() {
			this.updateNavbarActive("#liCourses");
			new CoursesView({
				root : $('#main')
			});
		},
		
		instructors : function() {
			this.updateNavbarActive("#liInstructors");
			new InstructorsView({
				root : $('#main')
			});
		},
		
		contacts : function() {
			this.updateNavbarActive("#liContacts");
			new ContactsView({
				root : $('#main')
			});
		},

		updateNavbarActive : function(where) {
			$(".active").removeClass("active");
			$(where).addClass("active");
		}

	});

	return AppRouter;

});
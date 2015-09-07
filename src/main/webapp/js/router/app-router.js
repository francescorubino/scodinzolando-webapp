define([ 'backbone', 
         'view/home-view', 
         'view/activity-view', 
         'view/activityDetails-view', 
         'view/courses-view', 
         'view/album-view', 
         'view/instructors-view',
         'view/instructor-bindi-view',
         'view/instructor-floris-view',
         'view/instructor-norfo-view',
         'view/contacts-view', 
         'view/menu-view' ], 
         function(Backbone, 
        		 HomeView,
        		 ActivityView, 
        		 ActivityDetailsView, 
        		 CoursesView, 
        		 AlbumView, 
        		 InstructorsView, 
        		 InstructorBindiView, 
        		 InstructorFlorisView, 
        		 InstructorNorfoView, 
        		 ContactsView, 
        		 MenuView) {

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
			'instructors/:id' : 'instructorDetails',
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
		
		instructorDetails : function(id) {
			this.updateNavbarActive("#liInstructors");
			if(id === 'alessandro-bindi'){
				new InstructorBindiView({
					root : $('#main')
				});
			}
			if(id === 'roberta-norfo'){
				new InstructorNorfoView({
					root : $('#main')
				});
			}
			if(id === 'valentina-floris'){
				new InstructorFlorisView({
					root : $('#main')
				});
			}
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
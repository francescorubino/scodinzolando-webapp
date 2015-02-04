define(['backbone', 'view/home-view', 'view/activity-view', 'view/contacts-view', 'view/menu-view'],
function (Backbone, HomeView, ActivityView, ContactsView, MenuView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
        	new MenuView({ root: $('#menu') });
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
            'activity' : 'activity',
            'contacts' : 'contacts'
        },

        home:function () {
        	this.updateNavbarActive("#liHome");
            new HomeView({ root: $('#main') });
        },
        
        activity:function () {
        	this.updateNavbarActive("#liActivity");
        	new ActivityView({ root: $('#main') });
        },
        
        contacts:function () {
        	this.updateNavbarActive("#liContacts");
            new ContactsView({ root: $('#main') });
        },
        
        updateNavbarActive: function(where) {
        	var elem = $(".active");
        	elem.attr("class", "");
        	elem = $(where);
        	elem.attr("class","active");
        }

    });

    return AppRouter;

});
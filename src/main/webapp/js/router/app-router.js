define(['backbone', 'view/home-view', 'view/activity-view', 'view/contacts-view'],
function (Backbone, HomeView, ActivityView, ContactsView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
            'activity' : 'activity',
            'contacts' : 'contacts'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        
        activity:function () {
        	new ActivityView({ root: $('#main') });
        },
        
        contacts:function () {
            new ContactsView({ root: $('#main') });
        },

    });

    return AppRouter;

});
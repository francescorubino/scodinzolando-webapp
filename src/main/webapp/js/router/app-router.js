define(['backbone', 'view/home-view', 'view/contacts-view'],
function (Backbone, HomeView, ContactsView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
            'contacts' : 'contacts'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        contacts:function () {
            new ContactsView({ root: $('#main') });
        },

    });

    return AppRouter;

});
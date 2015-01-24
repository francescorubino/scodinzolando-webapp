define(['backbone', 'view/home-view'],
function (Backbone, HomeView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },

    });

    return AppRouter;

});
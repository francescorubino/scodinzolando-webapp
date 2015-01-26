define([ 'backbone', 'resthub', 'hbs!template/home' ],
function (Backbone, Resthub, homeTemplate) {
    
    var HomeView = Resthub.View.extend({
        
        // Define view template
        template: homeTemplate,

        initialize:function () {
           this.render();
        }

    });
    return HomeView;
});
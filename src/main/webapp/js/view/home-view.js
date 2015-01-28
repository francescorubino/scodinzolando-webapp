define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/home' ],
function (Backbone, Resthub, myLabels, homeTemplate) {
    
    var HomeView = Resthub.View.extend({
        
        // Define view template
        template: homeTemplate,
        labels : myLabels,
        
        initialize:function () {
           this.render();
        }

    });
    return HomeView;
});
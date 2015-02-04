define([ 'backbone', 'resthub', 'i18n!nls/labels', 'collection/activity-collection', 'hbs!template/menu-view' ],
function (Backbone, Resthub, myLabels, ActivityCollection, menuTemplate) {
    
    var MenuView = Resthub.View.extend({
        
        // Define view template
        template: menuTemplate,
        labels : myLabels,
        
        initialize:function () {
        	 // Initialize the collection
            this.activities = new ActivityCollection();
            
            // Render the view when the activities is retreived from the server
            this.listenTo(this.activities, 'sync', this.render);
            
            // Request unpaginated URL
            this.activities.fetch({ data: { page: 'no'} });
        },
        
        render : function(){
        	MenuView.__super__.render.apply(this, arguments);
        }

    });
    return MenuView;
});
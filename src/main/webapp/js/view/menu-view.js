define([ 'backbone', 'resthub',  'collection/activity-collection', 'hbs!template/menu-view' ],
function (Backbone, Resthub,  ActivityCollection, menuTemplate) {
    
    var MenuView = Resthub.View.extend({
        
        // Define view template
        template: menuTemplate,
//        labels : myLabels,
        
        initialize:function () {
        	 // Initialize the collection
            this.collection = new ActivityCollection();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        },

    });
    return MenuView;
});
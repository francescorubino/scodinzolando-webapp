define([ 'backbone', 'resthub', 'i18n!nls/labels', 'collection/activity-collection', 'hbs!template/activity-view' ],
function (Backbone, Resthub, myLabels, ActivityCollection, activityTemplate) {
    
    var ActivityView = Resthub.View.extend({
        
        // Define view template
        template: activityTemplate,
        labels : myLabels,
        
        initialize:function () {
            // Initialize the collection
            this.collection = new ActivityCollection();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        }

    });
    return ActivityView;
});
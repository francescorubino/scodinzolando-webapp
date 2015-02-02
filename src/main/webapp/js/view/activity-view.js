define([ 'backbone', 'resthub', 'i18n!nls/labels', 'view/activity-detail-view', 'collection/activity-collection', 'hbs!template/activity-view' ],
function (Backbone, Resthub, myLabels, ActivityDetailView, ActivityCollection, activityTemplate) {
    
    var ActivityView = Resthub.View.extend({
        
        // Define view template
        template: activityTemplate,
        labels : myLabels,
        events : {
        	'click a.sco-viewDetail' : 'details'
        },
        
        initialize:function () {
            // Initialize the collection
            this.collection = new ActivityCollection();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        },
        
        details : function(e){
        	e.preventDefault();
        	var elem = $(e.target);
        	var activityId = elem.data('activityid');
        	var activityName = elem.data('activityname');
        	this._details(activityId, activityName);
        },
        
        _details : function(activityId, activityName){
        	console.log(activityId);
        	new ActivityDetailView({
        		root : $('.colorbox'),
        		id : activityId,
        		popup : true
        	});
        }

    });
    return ActivityView;
});
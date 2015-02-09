define([ 'backbone', 'resthub', 'i18n!nls/labels', 'view/sliderThumbnail-view', 'model/activity', 'hbs!template/activityDetails-view' ],
function (Backbone, Resthub, myLabels, SliderThumbnailView, Activity, activityDetailsTemplate) {
    
    var ActivityDetailsView = Resthub.View.extend({
        
        // Define view template
        template: activityDetailsTemplate,
        labels : myLabels,

        initialize:function (args) {
            // Initialize the collection
            this.model = new Activity({
            	id : args.activityId
            });
            this.listenTo(this.model, 'sync', this.render)
            this.model.fetch();
        },
        
        render: function() {
        	ActivityDetailsView.__super__.render.apply(this, arguments);
        	
        	var sliderThumbnailView = new SliderThumbnailView({
				root : ($('#slider')),
				activityId : this.model.id
			});
        }
    });
    return ActivityDetailsView;
});
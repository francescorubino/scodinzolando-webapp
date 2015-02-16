define([ 'backbone', 'resthub', 'i18n!nls/labels', 'view/slider-view', 'model/activity', 'hbs!template/activityDetails-view' ],
function (Backbone, Resthub, myLabels, SliderView, Activity, activityDetailsTemplate) {
    
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
        	
        	var sliderView = new SliderView({
				root : ($('#slider')),
				activityId : this.model.id
			});
        }
    });
    return ActivityDetailsView;
});
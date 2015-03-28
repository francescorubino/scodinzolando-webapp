define([ 'backbone', 'resthub', 'collection/activity-collection',
		'hbs!template/menu-view' ], function(Backbone, Resthub,
		ActivityCollection, menuTemplate) {

	var MenuView = Resthub.View.extend({

		// Define view template
		template : menuTemplate,
		// labels : myLabels,

		initialize : function() {
			// Initialize the collection
			this.activitiesA = new ActivityCollection({
				type : "a"
			});
			this.activitiesB = new ActivityCollection({
				type : "b"
			});

			var self = this;
			$.when(self.activitiesA.fetch(), self.activitiesB.fetch()).done(function() {
				self.render({activitiesA: self.activitiesA, activitiesB: self.activitiesB});
			});
			
			
		},
//		render : function() {
//        	MenuView.__super__.render.apply(this, arguments);
//        	var A = this.activitiesA;
//        	var B = this.activitiesB;
//		}

	});
	return MenuView;
});
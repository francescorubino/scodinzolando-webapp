define([ 'backbone', 'model/activity' ], function(Backbone, ActivityModel) {

	var ActivityCollection = Backbone.Collection.extend({

		// Reference to this collection's model.
		model : ActivityModel,
		url : 'activity/list',

		initialize : function(args) {
			if (args != undefined)
				if (typeof args.type != 'undefined') {
					this.url = 'activity/findByType?type=' + args.type;
				}
		},
	});
	return ActivityCollection;
});

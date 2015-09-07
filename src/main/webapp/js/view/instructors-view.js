define([ 'backbone', 'resthub', 'hbs!template/instructors-view' ], function(
		Backbone, Resthub, instructorsTemplate) {

	var InstructorsView = Resthub.View.extend({

		// Define view template
		template : instructorsTemplate,

		initialize : function() {
			this.render();
		}
	});
	return InstructorsView;
});
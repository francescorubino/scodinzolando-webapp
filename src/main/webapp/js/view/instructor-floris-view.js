define([ 'backbone', 'resthub', 'hbs!template/instructor-floris-view' ],
		function(Backbone, Resthub, instructorTemplate) {

			var InstructorsView = Resthub.View.extend({

				// Define view template
				template : instructorTemplate,

				initialize : function() {
					this.render();
				}
			});
			return InstructorsView;
		});
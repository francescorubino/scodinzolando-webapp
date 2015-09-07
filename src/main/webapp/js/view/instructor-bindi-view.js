define([ 'backbone', 'resthub', 'hbs!template/instructor-bindi-view' ],
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
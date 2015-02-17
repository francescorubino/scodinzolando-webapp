define([ 'backbone', 'resthub', 'i18n!nls/labels',
		'collection/photoGroup-collection', 'view/slider-view',
		'hbs!template/album-view' ], function(Backbone, Resthub, myLabels,
		PhotoGroupCollection, SliderView, albumTemplate) {

	var AlbumView = Resthub.View.extend({

		// Define view template
		template : albumTemplate,
		labels : myLabels,

		events : {
			"click .colorbox" : function(e) {
				var sliderView = new SliderView({
					root : ($('#overlay')),
					groupId : $(e.currentTarget).data('id')
				});
				$.colorbox({
					html : sliderView.el,
					title : $(e.currentTarget).data('title'),
					width : "800px",
					height : "565px",
					scrolling : false,
					opacity : 0.99
				});
			}
		},

		initialize : function() {

			// Initialize the collection
			this.collection = new PhotoGroupCollection();

			// Render the view when the collection is retrieved from the server
			this.listenTo(this.collection, 'sync', this.render);

			// Request first page
			this.collection.fetch({
				data : {
					page : 'no'
				}
			});
		},

	});
	return AlbumView;
});
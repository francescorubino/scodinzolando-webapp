define([ 'backbone', 'resthub', 'jssor-slider', 'hbs!template/sliderThumbnail-view',
		'collection/photo-collection' ], function(Backbone, Resthub,
		JssorSlider, sliderTemplate, PhotoCollection) {

	var SliderView = Resthub.View.extend({

		// Define view template
		template : sliderTemplate,

		initialize : function(args) {

			if (typeof args.activityId != 'undefined')
				this.collection = new PhotoCollection({
					activityId : args.activityId
				});
			if (typeof args.groupId != 'undefined')
				this.collection = new PhotoCollection({
					groupId : args.groupId
				});

			this.listenTo(this.collection, 'sync', this.render);
			this.collection.fetch();

			// Render the view
			this.render();
		},

		render : function() {
			SliderView.__super__.render.apply(this, arguments);
			if (this.collection.length !== 0) {

				var options = {
					$AutoPlay : true,
					$SlideDuration : 500, 
					$DragOrientation : 3,
					
		            $ThumbnailNavigatorOptions: {
		                $Class: $JssorThumbnailNavigator$,
		                $ChanceToShow: 2
		            },
		            
					$ArrowNavigatorOptions : { 
						$Class : $JssorArrowNavigator$,
						$ChanceToShow : 1, 
						$AutoCenter : 2, 
						$Steps : 1
					}
				};
				var jssor_slider1 = new $JssorSlider$("slider1_container",
						options);

				// responsive code begin
				// you can remove responsive code if you don't want the
				// slider scales
				// while window resizes
				function ScaleSlider() {
					var parentWidth = $('#slider1_container').parent().width();
					if (parentWidth) {
						jssor_slider1.$ScaleWidth(parentWidth);
					} else
						window.setTimeout(ScaleSlider, 30);
				}
				// Scale slider after document ready
				ScaleSlider();

				// Scale slider while window
				// load/resize/orientationchange.
				$(window).bind("load", ScaleSlider);
				$(window).bind("resize", ScaleSlider);
				$(window).bind("orientationchange", ScaleSlider);
				// responsive code end
			}
		},

	});
	return SliderView;
});
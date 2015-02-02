define([ 'backbone', 'resthub', 'jssor-slider', 'hbs!template/slider' ],
		function(Backbone, Resthub, JssorSlider, sliderTemplate) {

			var SliderView = Resthub.View.extend({

				// Define view template
				template : sliderTemplate,

				initialize : function(args) {
					 // Initialize the collection
		            this.collection = args.photos;
		            
					// Render the view
					this.render();
				},

				render : function() {
					SliderView.__super__.render.apply(this, arguments);
					if(this.collection.length !== 0){
						
						var options = {
								$AutoPlay: true,                                   //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
								$SlideDuration: 500,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
								$DragOrientation: 3,
								$BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
									$Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
									$ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
									$AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
									$Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
									$Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
									$SpacingX: 10,                                  //[Optional] Horizontal space between each item in pixel, default value is 0
									$SpacingY: 10,                                  //[Optional] Vertical space between each item in pixel, default value is 0
									$Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
								},
								$ArrowNavigatorOptions: {                       //[Optional] Options to specify and enable arrow navigator or not
									$Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
									$ChanceToShow: 1,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
									$AutoCenter: 2,                                 //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
									$Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
								}
						};
						var jssor_slider1 = new $JssorSlider$("slider1_container", options);
						
						//responsive code begin
						//you can remove responsive code if you don't want the slider scales
						//while window resizes
						function ScaleSlider() {
							var parentWidth = $('#slider1_container').parent().width();
							if (parentWidth) {
								jssor_slider1.$ScaleWidth(parentWidth);
							}
							else
								window.setTimeout(ScaleSlider, 30);
						}
						//Scale slider after document ready
						ScaleSlider();
						
						//Scale slider while window load/resize/orientationchange.
						$(window).bind("load", ScaleSlider);
						$(window).bind("resize", ScaleSlider);
						$(window).bind("orientationchange", ScaleSlider);
						//responsive code end
					}
				},

			});
			return SliderView;
		});
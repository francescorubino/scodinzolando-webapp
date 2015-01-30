define(['backbone', 'model/photo'], function (Backbone, PhotoModel) {

    var PhotoCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: PhotoModel,
        url:'photo/list',
        
        initialize: function(args){
        	if(typeof args.activityId != 'undefined'){
        		this.url = 'photo/findByActivity?activityId=' + args.activityId;
        	}
        },

    });
    return PhotoCollection;
});

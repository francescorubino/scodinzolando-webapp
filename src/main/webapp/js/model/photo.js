define(['backbone'], function(Backbone) {
    var PhotoModel = Backbone.Model.extend({

    	url : 'photo',
        defaults: {
            name: "empty name"
        }

    });
    return PhotoModel;
});
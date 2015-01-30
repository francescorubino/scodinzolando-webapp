define(['backbone'], function(Backbone) {
    var ActivityModel = Backbone.Model.extend({

    	url : 'activity',
        defaults: {
            name: "empty name"
        }

    });
    return ActivityModel;
});
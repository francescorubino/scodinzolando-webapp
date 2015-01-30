define(['backbone', 'model/activity'], function (Backbone, ActivityModel) {

    var ActivityCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: ActivityModel,
        url:'activity/list'

    });
    return ActivityCollection;
});

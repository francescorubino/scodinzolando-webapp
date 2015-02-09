define(['backbone', 'model/photoGroup'], function (Backbone, PhotoGroupModel) {

    var GruppoFotoCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: PhotoGroupModel,
        url:'photogroup/list',
        

    });
    return GruppoFotoCollection;
});

define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/album-view' ],
function (Backbone, Resthub, myLabels, albumTemplate) {
    
    var AlbumView = Resthub.View.extend({
        
        // Define view template
        template: albumTemplate,
        labels : myLabels,
        
        initialize:function () {
           this.render();
        }

    });
    return AlbumView;
});
define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/activity-view' ],
function (Backbone, Resthub, myLabels, activityTemplate) {
    
    var ActivityView = Resthub.View.extend({
        
        // Define view template
        template: activityTemplate,
        labels : myLabels,
        
        initialize:function () {
           this.render();
        }

    });
    return ActivityView;
});
define([ 'backbone', 'resthub', 'i18n!nls/labels', 'hbs!template/courses-view' ],
function (Backbone, Resthub, myLabels, coursesTemplate) {
    
    var CoursesView = Resthub.View.extend({
        
        // Define view template
        template: coursesTemplate,
        labels : myLabels,
        
        initialize:function () {
           this.render();
        }

    });
    return CoursesView;
});
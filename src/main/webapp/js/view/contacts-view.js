define([ 'backbone', 'resthub', 'hbs!template/contacts' ],
function (Backbone, Resthub, contactsTemplate) {
    
    var ContactsView = Resthub.View.extend({
        
        // Define view template
        template: contactsTemplate,

        initialize:function () {
           this.render();
        }

    });
    return ContactsView;
});
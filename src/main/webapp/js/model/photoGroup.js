define(['backbone'], function(Backbone) {
    var PhotoGroupModel = Backbone.Model.extend({

    	url : "photogroup",
        
        initialize: function(args){
        	if(typeof args.url != 'undefined'){
        		this.url = args.url;
        	}
        	if(typeof args.id != 'undefined'){
        		this.url += "/" + args.id;
        	}
        }       

    });
    return PhotoGroupModel;
});
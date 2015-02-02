define([ 'backbone', 'resthub', 'i18n!nls/labels', 
         'model/activity', 'collection/photo-collection', 
         'hbs!template/activity-detail-view', 'view/slider-view', 'colorbox'],
function (Backbone, Resthub, myLabels, ActivityModel, PhotoCollection, activityDetailTemplate, SliderView) {
    
    var ActivityDetailView = Resthub.View.extend({
        
        // Define view template
        template: activityDetailTemplate,
        labels : myLabels,
        
        initialize:function (args) {
        	this.id = args.id == null ? null : args.id;
        	this.popup = args.popoup = null ? false : args.popup;
        	if(typeof this.id != 'undefined'){
        		this.model = new ActivityModel({id : this.id});
        		var self = this;
    			this.listenTo(this.model, 'sync', this.loadPhoto);
                this.model.fetch();
        	}
        },
        
        loadPhoto : function(){
        	this.collection = new PhotoCollection({
        		'activityId' : this.model.id
        	});
        	this.listenTo(this.collection, 'sync', this.render);
            this.collection.fetch();
        },
        
        render : function(){
        	ActivityDetailView.__super__.render.apply(this, arguments);
        	
        	new SliderView({
				root : ($('#overlay')),
				photos : this.collection
			});
        	
        	if(this.popup){
        		$.colorbox({
    				html : this.root,
    				title: this.model.get('name'),
    				width : "80%",
    				height: "80%"
    			});
        	}
        }
    });
    return ActivityDetailView;
});
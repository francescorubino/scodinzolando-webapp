package it.scodinzolando.service;

import it.scodinzolando.service.facebook.JsonNodeBuilder;
import it.scodinzolando.service.facebook.JsonNodeVisitor;
import it.scodinzolando.service.facebook.album.AlbumBuilder;
import it.scodinzolando.service.facebook.album.AlbumVisitor;
import it.scodinzolando.service.facebook.events.EventsBuilder;
import it.scodinzolando.service.facebook.events.EventsVisitor;
import it.scodinzolando.service.facebook.photos.PhotoBuilder;
import it.scodinzolando.service.facebook.photos.PhotoVisitor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.social.facebook.api.Album;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Photo;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

	private static final String ACCESS_APP_TOKEN = "707708242680149|4db955f89c59e0e4ea31be8044852eaf";
	
	@Inject
	private Facebook facebook;
	
	@PostConstruct
	public void init(){
		this.facebook = new FacebookTemplate(ACCESS_APP_TOKEN);
	}

	public List<Event> getEvents(){
		JsonNodeBuilder builder = new EventsBuilder(facebook);
		JsonNodeVisitor visitor = new EventsVisitor(facebook, builder);
		visitor.visit();
		return (List<Event>) builder.getData();
	}
	
	public List<Event> getEvents(Date since, Date until){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		JsonNodeBuilder builder = new EventsBuilder(facebook);
		JsonNodeVisitor visitor = new EventsVisitor(facebook, builder);
		if(since!= null) 
			visitor.addQueryParam("since", dateFormat.format(since));
		if(until != null)
			visitor.addQueryParam("until", dateFormat.format(until));
		visitor.visit();
		return (List<Event>) builder.getData();
	}
	
	public List<Album> getAlbum(){
		JsonNodeBuilder builder = new AlbumBuilder(facebook);
		JsonNodeVisitor visitor = new AlbumVisitor(facebook, builder);
		visitor.visit();
		return (List<Album>) builder.getData();
	}

	public List<Photo> getPhotosByAlbum(String albumId) {
		JsonNodeBuilder builder = new PhotoBuilder(facebook);
		JsonNodeVisitor visitor = new PhotoVisitor(facebook, builder, albumId);
		visitor.visit();
		return (List<Photo>) builder.getData();
	}

}

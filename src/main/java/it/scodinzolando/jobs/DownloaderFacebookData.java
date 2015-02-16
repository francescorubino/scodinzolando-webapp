package it.scodinzolando.jobs;

import java.util.Calendar;
import java.util.List;

import it.scodinzolando.model.CalendarEvent;
import it.scodinzolando.model.PhotoGroup;
import it.scodinzolando.service.CalendarEventService;
import it.scodinzolando.service.FacebookService;
import it.scodinzolando.service.PhotoGroupService;
import it.scodinzolando.service.PhotoService;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Album;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Photo;
import org.springframework.stereotype.Component;

@Component("downloaderFacebookData")
public class DownloaderFacebookData {

	@Inject
	private FacebookService facebookService;
	
	@Inject
	private PhotoGroupService photoGroupService;
	
	@Inject
	private PhotoService photoService;
	
	@Inject
	private CalendarEventService calendarEventService;
	
	public void downloadData() {
        downloadPhotos();
        downloadEvents();
    }

	private void downloadEvents() {
		System.out.println("Scarico eventi da facebook..");
        Calendar calendar = Calendar.getInstance();
		List<Event> events = facebookService.getEvents(calendar.getTime(), null);
		for (Event e : events) {
			CalendarEvent event = calendarEventService.findByFacebookId(e.getId());
			if(event == null){
				event = new CalendarEvent(); 
				event.setFacebookId(e.getId());
				event.setStart(e.getStartTime());
				event.setEnd(e.getEndTime());
				event.setTitle(e.getName());
				this.calendarEventService.createCalendarEvent(event);
			}
		}
	}

	private void downloadPhotos() {
		System.out.println("Scarico album da facebook..");
        List<Album> album = facebookService.getAlbum();
        
        System.out.println("Scarico foto da facebook..");
        for (Album a : album) {
        	String idAlbum = a.getId(); 
        	PhotoGroup group = this.photoGroupService.findByFacebookId(idAlbum);
        	if(group == null){
        		group = new PhotoGroup(); 
        		group.setDescription(a.getDescription());
        		group.setName(a.getName());
        		group.setFacebookId(a.getId());

        		boolean foundNewPhotos = false; 
        		List<Photo> photos = facebookService.getPhotosByAlbum(a.getId());	
        		for (Photo p : photos) {
        			String idPhoto = p.getId();
        			it.scodinzolando.model.Photo photo = photoService.findByFacebookId(idPhoto);
        			if(photo == null){
        				photo = new it.scodinzolando.model.Photo();
        				photo.setFacebookId(idPhoto);
        				photo.setName(p.getName());
        				photo.setDescription(p.getLink());
        				photo.setPath(p.getSource());
        				photo.setPhotoGroup(group);
        				group.getPhotos().add(photo);
        				foundNewPhotos = true;
        			}
        		}
        		if(foundNewPhotos){
        			this.photoGroupService.createPhotoGroup(group);
        		}
        	}
        	
		}
	}
}

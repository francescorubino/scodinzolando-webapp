package it.scodinzolando.service;

import it.scodinzolando.ScodinzolandoWebappApplication;
import it.scodinzolando.utils.FacebookTranslator;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.social.facebook.api.Album;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Photo;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScodinzolandoWebappApplication.class)
@WebAppConfiguration
public class FacebookServiceTest {

	@Inject
	private FacebookService facebookService;

	@Test
	public void testByService() {
		List<Event> events = facebookService.getEvents();
		for (Event event : events) {
			System.out.println(event.getId());
			System.out.println(event.getStartTime());
		}
	}

	@Test
	public void testFindXtEventsBySince() {
//		2015-10-10
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, Calendar.OCTOBER, 10);
		List<Event> events = facebookService.getEvents(calendar.getTime(), null);
		for (Event event : events) {
			System.out.println(event.getId());
			System.out.println(event.getStartTime());
		}
		Assert.assertEquals(2, events.size());
	}

	@Test
	public void testFindEventsByUntil() {
		//		2013-05-06
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.MAY, 6);
		List<Event> events = facebookService.getEvents(null, calendar.getTime());
		for (Event event : events) {
			System.out.println(event.getId());
			System.out.println(event.getStartTime());
		}
		Assert.assertEquals(1, events.size());
	}

	@Test
	public void testFindEventsBySinceAndUntil() {
		//		since = 2015-10-01 & until = 2015-10-31
		Calendar since = Calendar.getInstance();
		since.set(2015, Calendar.OCTOBER, 1);
		Calendar until = Calendar.getInstance();
		until.set(2015, Calendar.OCTOBER, 31);
		List<Event> events = facebookService.getEvents(since.getTime(), until.getTime());
		for (Event event : events) {
			System.out.println(event.getId());
			System.out.println(event.getStartTime());
		}
		Assert.assertEquals(1, events.size());
	}
	
	@Test
	public void testFindAlbum() {
		List<Album> album = facebookService.getAlbum();
		for (Album current : album) {
			System.out.println(current.getId());
		}
	}
	
	@Test
	public void testFindPhoto() {
		List<Album> album = facebookService.getAlbum();
		List<Photo> photos = facebookService.getPhotosByAlbum(album.get(0).getId());
		for (Photo current : photos) {
			System.out.println(current.getId());
			System.out.println(current.getSource());
		}
	}

	@Test
	public void testFacebookTranslator() {
		List<Album> album = facebookService.getAlbum();
		List<Photo> photos = facebookService.getPhotosByAlbum(album.get(0).getId());
		Photo fbPhoto = photos.get(0);
		it.scodinzolando.model.Photo photo = FacebookTranslator.fbToPhoto(fbPhoto);
		Assert.assertEquals(fbPhoto.getSource(), photo.getPath());
		
	}
}

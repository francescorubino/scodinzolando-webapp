package it.scodinzolando.mvc;

import it.scodinzolando.model.Photo;
import it.scodinzolando.service.PhotoService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/photo")
public class PhotoController {

	@Inject
	private PhotoService photoService;
	
	@RequestMapping(value = "/findByActivity", method = RequestMethod.GET)
	public List<Photo> findByName(@RequestParam("activityId") Long activityId) {
		return this.photoService.getPhotoByActivityId(activityId);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Photo> getPhotos() {
		return this.photoService.getPhotos();
	}
}

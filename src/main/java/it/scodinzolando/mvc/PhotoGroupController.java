package it.scodinzolando.mvc;

import it.scodinzolando.model.PhotoGroup;
import it.scodinzolando.service.PhotoGroupService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/photogroup")
public class PhotoGroupController {
	@Inject
	private PhotoGroupService photoGroupService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public PhotoGroup getPhotoGroup(@PathVariable("id") Long id) {
		return this.photoGroupService.getPhotoGroup(id);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<PhotoGroup> getActivities() {
		return this.photoGroupService.getPhotoGroups();
	}
}

package it.scodinzolando.mvc;

import it.scodinzolando.model.Activity;
import it.scodinzolando.service.ActivityService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

	@Inject
	private ActivityService activityService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Activity getActivity(@PathVariable("id") Long id) {
		return this.activityService.getActivity(id);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Activity> getActivities() {
		return this.activityService.getActivies();
	}
	
	@RequestMapping(value = "/findByType", method = RequestMethod.GET)
	public List<Activity> findByType(@RequestParam("type") String type) {
		return this.activityService.getActivityByType(type);
	}
}

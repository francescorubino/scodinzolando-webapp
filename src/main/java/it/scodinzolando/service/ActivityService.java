package it.scodinzolando.service;

import it.scodinzolando.model.Activity;
import it.scodinzolando.repository.ActivityRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class ActivityService {

	@Inject
	private ActivityRepository activityRepository;

	public Activity getActivity(Long id) {
		return activityRepository.findById(id);
	}

	public List<Activity> getActivityByName(String name) {
		return activityRepository.findByName(name);
	}

	public List<Activity> getActivies() {
		return Lists.newArrayList(activityRepository.findAll());
	}

	public Activity createActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	public void deleteActivity(Long id) {
		activityRepository.delete(id);
	}

}

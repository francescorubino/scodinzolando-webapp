package it.scodinzolando.service;

import it.scodinzolando.model.Photo;
import it.scodinzolando.repository.PhotoRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class PhotoService {

	@Inject
	private PhotoRepository photoRepository;

	public Photo getPhoto(Long id) {
		return photoRepository.findById(id);
	}

	public List<Photo> getPhotoByName(String name) {
		return photoRepository.findByName(name);
	}

	public List<Photo> getPhotos() {
		return Lists.newArrayList(photoRepository.findAll());
	}

	public List<Photo> getPhotoByActivityId(Long activityId) {
		return photoRepository.findByActivity_id(activityId);
	}
	
	public List<Photo> getPhotoByGroupId(Long groupId) {
		return photoRepository.findByPhotoGroup_id(groupId);
	}

	public Photo createPhoto(Photo photo) {
		return photoRepository.save(photo);
	}

	public void deletePhoto(Long id) {
		photoRepository.delete(id);
	}
}

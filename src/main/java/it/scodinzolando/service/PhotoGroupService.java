package it.scodinzolando.service;

import it.scodinzolando.model.PhotoGroup;
import it.scodinzolando.repository.PhotoGroupRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class PhotoGroupService {

	@Inject
	private PhotoGroupRepository photoGroupRepository;

	public PhotoGroup getPhotoGroup(Long id) {
		return photoGroupRepository.findById(id);
	}

	public List<PhotoGroup> getPhotoGroups() {
		return Lists.newArrayList(photoGroupRepository.findAll());
	}

	public List<PhotoGroup> findByName(String name) {
		return photoGroupRepository.findByName(name);
	}

	public PhotoGroup createPhotoGroup(PhotoGroup photoGroup) {
		return photoGroupRepository.save(photoGroup);
	}

	public void deletePhotoGroup(Long id) {
		photoGroupRepository.delete(id);
	}
	
	public PhotoGroup findByFacebookId(String facebookId){
		return photoGroupRepository.findByFacebookId(facebookId);
	}

}

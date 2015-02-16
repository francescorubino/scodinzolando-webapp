package it.scodinzolando.repository;

import it.scodinzolando.model.Photo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
	public Photo findById(long id);

	public List<Photo> findByName(String name);

	public List<Photo> findByActivity_id(long id);
	
	public List<Photo> findByPhotoGroup_id(long id);
	
	public Photo findByFacebookId(String facebookId);
}

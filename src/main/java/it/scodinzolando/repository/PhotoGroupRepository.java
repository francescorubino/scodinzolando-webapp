package it.scodinzolando.repository;

import it.scodinzolando.model.PhotoGroup;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoGroupRepository extends CrudRepository<PhotoGroup, Long>{

	public PhotoGroup findById(long id);
	
	public List<PhotoGroup> findByName(String name);	

}

package it.scodinzolando.repository;

import it.scodinzolando.model.Activity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

	public Activity findById(long id);

	public List<Activity> findByName(String name);
}

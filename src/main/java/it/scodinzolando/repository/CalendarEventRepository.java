package it.scodinzolando.repository;

import it.scodinzolando.model.CalendarEvent;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventRepository extends CrudRepository<CalendarEvent, Long> {
	public CalendarEvent findById(Long id);

	public List<CalendarEvent> findByTitle(String title);

	public CalendarEvent findByFacebookId(String facebookId);
	
	public List<CalendarEvent> findByStartBetween(Date start, Date end);
}

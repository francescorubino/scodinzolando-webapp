package it.scodinzolando.service;

import it.scodinzolando.model.CalendarEvent;
import it.scodinzolando.repository.CalendarEventRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class CalendarEventService {

	@Inject
	private CalendarEventRepository calendarEventRepository;

	public CalendarEvent getCalendarEvent(Long id) {
		return calendarEventRepository.findById(id);
	}

	public List<CalendarEvent> getCalendarEventByTitle(String title) {
		return calendarEventRepository.findByTitle(title);
	}

	public List<CalendarEvent> getCalendarEvents() {
		return Lists.newArrayList(calendarEventRepository.findAll());
	}

	public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
		return calendarEventRepository.save(calendarEvent);
	}

	public void deleteCalendarEvent(Long id) {
		calendarEventRepository.delete(id);
	}
	
	public CalendarEvent findByFacebookId(String facebookId){
		return calendarEventRepository.findByFacebookId(facebookId);
	}
	
	public List<CalendarEvent> findByStartDate(Date start, Date end){
		return calendarEventRepository.findByStartBetween(start, end);
	}

}

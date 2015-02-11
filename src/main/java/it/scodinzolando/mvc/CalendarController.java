package it.scodinzolando.mvc;

import it.scodinzolando.model.CalendarEvent;
import it.scodinzolando.service.FacebookService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Event;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

	@Inject
	private FacebookService facebookService;

	@RequestMapping(value = "eventslist", method = RequestMethod.GET)
	public List<CalendarEvent> getEvents() {
		List<Event> fbEvents = facebookService.getEvents();
		List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
		return convertEvents(fbEvents, calendarEvents);
	}

	@RequestMapping(value = "events", method = RequestMethod.GET)
	public List<CalendarEvent> findByDate(@RequestParam("start") String start,
			@RequestParam("end") String end) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date since = null;
		Date until = null;
		try {
			since = format.parse(start);
			until = format.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Event> fbEvents = facebookService.getEvents(since, until);
		List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
		return convertEvents(fbEvents, calendarEvents);
	}

	private List<CalendarEvent> convertEvents(List<Event> fbEvents,
			List<CalendarEvent> calendarEvents) {
		for (Event event : fbEvents) {
			calendarEvents.add(new CalendarEvent(Long.valueOf(event.getId()),
					event.getName(), event.getStartTime(), event.getEndTime()));
		}
		return calendarEvents;

	}
}
package it.scodinzolando.service.facebook.events;

import it.scodinzolando.service.facebook.JsonNodeBuilder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public class EventsBuilder extends JsonNodeBuilder {

	private List<Event> events = new ArrayList<Event>();

	public EventsBuilder(Facebook facebook) {
		super(facebook);
	}

	@Override
	public void build(JsonNode data) {
		String id = data.get("id").toString().replaceAll("\"", "");
		events.add(facebook.eventOperations().getEvent(id.toString()));
	}

	@Override
	public List<Event> getData() {
		return events;
	}

}

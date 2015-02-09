package it.scodinzolando.service.facebook.events;

import it.scodinzolando.service.facebook.JsonNodeBuilder;
import it.scodinzolando.service.facebook.JsonNodeVisitor;

import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public class EventsVisitor extends JsonNodeVisitor {

	private static final String SCODINZOLANDO_ID_PAGE = "383458228409772";

	public EventsVisitor(Facebook facebook, JsonNodeBuilder builder) {
		super(facebook, builder);
	}

	@Override
	public ResponseEntity<JsonNode> executeQuery(String url) {
		if(url == null)
			url = getUrl(SCODINZOLANDO_ID_PAGE + "/events");
		else
			url = String.format("%s&%s", url, getUrlParameters());
		System.err.println("URL: " + url);
		return facebook.restOperations().getForEntity(url, JsonNode.class, new Object[0]);
	}

}

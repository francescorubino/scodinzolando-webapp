package it.scodinzolando.service.facebook.album;

import it.scodinzolando.service.facebook.JsonNodeBuilder;
import it.scodinzolando.service.facebook.JsonNodeVisitor;

import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public class AlbumVisitor extends JsonNodeVisitor {

	private static final String SCODINZOLANDO_ID_PAGE = "383458228409772";

	public AlbumVisitor(Facebook facebook, JsonNodeBuilder builder) {
		super(facebook, builder);
	}

	@Override
	public ResponseEntity<JsonNode> executeQuery(String url) {
		if(url == null)
			url = getUrl(SCODINZOLANDO_ID_PAGE + "/albums");
		else
			url = String.format("%s&%s", url, getUrlParameters());
		return facebook.restOperations().getForEntity(url, JsonNode.class, new Object[0]);
	}

}

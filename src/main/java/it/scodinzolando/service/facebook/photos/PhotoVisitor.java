package it.scodinzolando.service.facebook.photos;

import it.scodinzolando.service.facebook.JsonNodeBuilder;
import it.scodinzolando.service.facebook.JsonNodeVisitor;

import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public class PhotoVisitor extends JsonNodeVisitor {

	private String albumId;

	public PhotoVisitor(Facebook facebook, JsonNodeBuilder builder, String albumId) {
		super(facebook, builder);
		this.albumId = albumId;
	}

	@Override
	public ResponseEntity<JsonNode> executeQuery(String url) {
		if(url == null)
			url = getUrl(albumId + "/photos");
		else
			url = String.format("%s&%s", url, getUrlParameters());
		System.err.println("URL: " + url);
		return facebook.restOperations().getForEntity(url, JsonNode.class, new Object[0]);
	}

}

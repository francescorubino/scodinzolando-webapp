package it.scodinzolando.service.facebook.photos;

import it.scodinzolando.service.facebook.JsonNodeBuilder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Photo;

import com.fasterxml.jackson.databind.JsonNode;

public class PhotoBuilder extends JsonNodeBuilder {

	private List<Photo> photos = new ArrayList<Photo>();

	public PhotoBuilder(Facebook facebook) {
		super(facebook);
	}

	@Override
	public void build(JsonNode data) {
		String id = data.get("id").toString().replaceAll("\"", "");
		photos.add(facebook.mediaOperations().getPhoto(id.toString()));
	}

	@Override
	public List<Photo> getData() {
		return photos;
	}

}

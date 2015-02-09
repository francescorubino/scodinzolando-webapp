package it.scodinzolando.service.facebook.album;

import it.scodinzolando.service.facebook.JsonNodeBuilder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.facebook.api.Album;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public class AlbumBuilder extends JsonNodeBuilder {

	private List<Album> album = new ArrayList<Album>();

	public AlbumBuilder(Facebook facebook) {
		super(facebook);
	}

	@Override
	public void build(JsonNode data) {
		String id = data.get("id").toString().replaceAll("\"", "");
		album.add(facebook.mediaOperations().getAlbum(id.toString()));
	}

	@Override
	public List<Album> getData() {
		return album;
	}

}

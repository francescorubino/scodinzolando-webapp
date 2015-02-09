package it.scodinzolando.service.facebook;

import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class JsonNodeBuilder {

	public Facebook facebook;
	
	public JsonNodeBuilder(Facebook facebook) {
		super();
		this.facebook = facebook;
	}


	public abstract void build(JsonNode data);
	public abstract Object getData();
	
}

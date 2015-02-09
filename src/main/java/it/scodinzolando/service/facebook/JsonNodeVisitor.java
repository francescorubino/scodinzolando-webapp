package it.scodinzolando.service.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class JsonNodeVisitor {

	public final static String BASE_URL = "https://graph.facebook.com/v2.2";
	protected Facebook facebook;
	protected JsonNodeBuilder builder;
	protected Integer maxDepth = null; 
	protected Map<String, String> queryParams = new HashMap<String, String>();

	public JsonNodeVisitor(Facebook facebook, JsonNodeBuilder builder) {
		this.facebook = facebook;
		this.builder = builder;
	}

	public void visit() {
		visit(null, 0);
	}

	private void visit(String url, int depth) {
		if(maxDepth != null && depth > maxDepth)
			return;
		
		ResponseEntity<JsonNode> response = executeQuery(url);
		JsonNode jsonNode = response.getBody();
		for (JsonNode child : jsonNode.get("data")) {
			builder.build(child);
		}
		// gestisco paginazione
		JsonNode paging = jsonNode.get("paging");
		if(paging == null)
			return;
		
		JsonNode next = paging.get("next");
		if(next == null)
			return;
		
		visit(next.toString().replaceAll("\"", ""), depth++);

	}

	protected String getUrl(String suffixUrl){
		return String.format("%s/%s?%s", BASE_URL, suffixUrl,getUrlParameters());
	}
	
	protected String getUrlParameters() {
		List<String> parameters = new ArrayList<String>(); 
		for(String parameterName : this.queryParams.keySet()){
			parameters.add(String.format("%s=%s",parameterName,this.queryParams.get(parameterName)));
		}
		return StringUtils.join(parameters, "&");
	}
	
	public void addQueryParam(String parameterName, String parameterValue){
		this.queryParams.put(parameterName, parameterValue);
	}
	
	
	public Integer getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(Integer maxDepth) {
		this.maxDepth = maxDepth;
	}

	public abstract ResponseEntity<JsonNode> executeQuery(String url);
}

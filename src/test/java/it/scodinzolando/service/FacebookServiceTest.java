package it.scodinzolando.service;

import it.scodinzolando.ScodinzolandoWebappApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.JsonNode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScodinzolandoWebappApplication.class)
@WebAppConfiguration
public class FacebookServiceTest {

	private static String ACCESS_TOKEN = "205921867ab7191ca0ed6119722c769d";
	private static String SCODINZOLANDO_ID_PAGE = "383458228409772";
	
	
	@Inject
	private Facebook facebook;
	
	private static String getUrl(String url){
		return String.format("https://graph.facebook.com/v2.2/%s", url);
	}
	@Test
	public void testGetEvents(){
		facebook = new FacebookTemplate(ACCESS_TOKEN);
		
//		PagedList<Event> result;
		List<Event> list = new ArrayList<Event>();
		ResponseEntity<JsonNode> result = facebook.restOperations().getForEntity(getUrl(SCODINZOLANDO_ID_PAGE + "/events"), JsonNode.class, new Object[0]);
		System.err.println("Result: " +result.getBody().toString());
		JsonNode jsonNode = result.getBody();
		for (JsonNode child : jsonNode.get("data")) {
			String id = child.get("id").toString().replaceAll("\"", "");
			System.out.println(id.toString());
			list.add(facebook.eventOperations().getEvent(id.toString()));
		}
		
		for (Event event : list) {
			System.out.println(event.getDescription());
			System.out.println(event.getStartTime());
		}
		Assert.assertTrue(true);
	}
}

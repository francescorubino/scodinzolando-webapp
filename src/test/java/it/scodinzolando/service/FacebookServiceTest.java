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

	@Inject
	private Facebook facebook;
	
	@Test
	public void test(){
		String accessToken = "CAACEdEose0cBAO6mjwy3KZBRhfPWDu0yNzheHjqoCZCbJUfAsgdKFQtLSeqZBsvfZBQn8zxwum2e1pQgB2WRxuxZBsl0spZBoNYoOB0jNTpdSiSIGtBXvgpLnwxBIwK8cswgc5EXDZBHNsyC8IlZCcZAKdioAZBj1Nd1uBI6TQImQA8aMY7Y4ndMLgQGgjyvZBgQHolSIPsTimSNwZDZD";
		facebook = new FacebookTemplate(accessToken );
		
//		PagedList<Event> result;
		List<Event> list = new ArrayList<Event>();
		ResponseEntity<JsonNode> result = facebook.restOperations().getForEntity("https://graph.facebook.com/v2.2/383458228409772/events", JsonNode.class, new Object[0]);
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

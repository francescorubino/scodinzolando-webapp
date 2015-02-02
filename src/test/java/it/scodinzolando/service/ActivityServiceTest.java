package it.scodinzolando.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import it.scodinzolando.ScodinzolandoWebappApplication;
import it.scodinzolando.model.Activity;
import it.scodinzolando.model.Photo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScodinzolandoWebappApplication.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public class ActivityServiceTest {

	@Inject
	private ActivityService activityService;
	
	@Inject
	private CsvReaderService csvReaderService;
	
	@Test
	public void createActivity() throws IOException{
		String csv = getClass().getClassLoader().getResource("scodinzolando/attivita.csv").getPath();
		char separator = ';';
		char quote = '"';
		List<String[]> results = csvReaderService.csvReader(csv, separator, quote );
		for (String[] row : results) {
			Activity activity = new Activity();
			activity.setName(row[0]);
			activity.setDescription(row[1]);
			String[] photos = row[2].split(",");
			for(int i = 0; i<photos.length; i++){
				Photo photo = new Photo(); 
				photo.setName(String.format("foto%s", i));
				photo.setDescription(String.format("Descrizione foto %s", i));
				photo.setPath(photos[i].trim());
				photo.setActivity(activity);
				activity.getPhotos().add(photo);
			}
			this.activityService.createActivity(activity);
		}
		Assert.assertNotNull(results);
	}
	
}

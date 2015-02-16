package it.scodinzolando.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import it.scodinzolando.ScodinzolandoWebappApplication;
import it.scodinzolando.model.CalendarEvent;
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
public class CalendarEventServiceTest {

	@Inject
	private CalendarEventService calendarEventService;
	
	@Test
	public void testGetByStartAndEndDate(){
		Calendar start = Calendar.getInstance();
		start.set(2015,Calendar.FEBRUARY, 1);
		Calendar end = Calendar.getInstance();
		end.set(2015,Calendar.MARCH, 1);
		List<CalendarEvent> result = calendarEventService.findByStartDate(start.getTime(), end.getTime());
		Assert.assertEquals(1, result.size());
	}
	
}

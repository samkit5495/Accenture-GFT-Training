package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {

	private List<Object[]> eventList;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		eventServiceImpl = null;
		visitor = null;
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Ignore
	public void testGetAllEvents() {
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */	
		assertEquals(8, eventServiceImpl.getAllEvents().size());
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this method
		 * for appropriate return type
		 */	
		visitor=new Visitor();
		visitor.setVisitorId(1001);
		visitor.setUserName("bsmith");
		visitor.setPassword("password");
		visitor.setFirstName("Bob");
		visitor.setLastName("Smith");
		visitor.setEmail("bsmith@email.com");
		visitor.setPhoneNumber("748937487");
		visitor.setAddress(null);
		boolean result=eventServiceImpl.checkEventsofVisitor(visitor, 1001, 10001);
		assertEquals(false, result);
	}

	/**
	 * Test case to test the method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this method
		 */	
		try{
			eventServiceImpl.updateEventDeletions(1001, 10001);
		}
		catch (Exception e) {
			// TODO: handle exception
				assertEquals(e.getMessage(), "Records not updated properly");
		}
	}

	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getAllEventCoordinators and assert the size of return type of this method
		 */		
		assertEquals(5, eventServiceImpl.getAllEventCoordinators().size());
	}

	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent and assert the event id of this event with 
		 * passed event id 
		 */		
		int eventId = 1001;
		int sessionId = 10001;
		assertEquals(eventId, eventServiceImpl.getEvent(eventId, sessionId).getEventid());
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Call insertEvent
		 * Create event object by setting appropriate values
		 * Assert the status of insertEvent method
		 */		
		Event event = new Event();
		event.setName("abc");
		event.setDescription("abc");
		event.setPlace("abc");
		event.setDuration("10");
		event.setEventtype("abc");
		event.setSeatsavailable("100");
		event.setEventSession(2);
		event.setEventCoordinatorId(103);
		assertEquals(2, eventServiceImpl.insertEvent(event));
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call updateEvent method
		 * Assert the status of updateEvent method
		 */	
		int eventId = 1003;
		int sessionId = 10003;
		Event event = eventServiceImpl.getEvent(eventId, sessionId);
		event.setEventtype("cooool");
		assertEquals(1, eventServiceImpl.updateEvent(event));
	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Ignore
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call deleteEvent method
		 * Assert the status of deleteEvent method
		 */	
		int eventId = 1004;
		int sessionId = 10004;
		assertEquals(1, eventServiceImpl.deleteEvent(eventId, sessionId));
	}

}

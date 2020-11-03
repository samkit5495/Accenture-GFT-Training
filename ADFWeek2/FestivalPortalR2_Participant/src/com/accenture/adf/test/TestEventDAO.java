package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 * 
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Object[]> showAllEvents;
	private EventDAO dao;

	/**
	 * Sets up database connection before other methods are executed in this
	 * class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here  
		 */
		FERSDataConnection.closeConnection();
	}

	/**
	 * Sets up the objects required in other methods
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Object[]>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		showAllEvents = null;
		dao = null;
	}

	/**
	 * Positive test case to test the method showAllEvents
	 */
	@Test
	public void testShowAllEvents_Positive() {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */	
		try {
			showAllEvents = dao.showAllEvents();
			assertEquals(8, showAllEvents.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Junit test case to test positive case for updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		
		int eventId=1006;
		int eventSesssionId = 1006;
		int testSeatsAvailableBefore=-1,testSeatsAvailableAfter=-1;
		try {
			connection = FERSDataConnection.createConnection();
			String sql = "SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, eventSesssionId);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				testSeatsAvailableBefore = resultSet.getInt("SEATSAVAILABLE");
			}
			dao.updateEventDeletions(eventId, eventSesssionId);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				testSeatsAvailableAfter = resultSet.getInt("SEATSAVAILABLE");
			}
			assertEquals(testSeatsAvailableBefore+1, testSeatsAvailableAfter);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Negative test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Negative() {
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */
		int eventid= 9;
		int eventSessionId=9;
		try {
			dao.updateEventDeletions(eventid,eventSessionId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Records not updated properly", e.getMessage());
		}
	}

	/**
	 * Positive test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */	
		int eventId=1006;
		int eventSessionId = 10006;
		int testSeatsAvailableBefore=-1,testSeatsAvailableAfter=-1;
		try {
			connection = FERSDataConnection.createConnection();
			String sql = "SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTSESSIONID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, eventSessionId);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				testSeatsAvailableBefore = resultSet.getInt("SEATSAVAILABLE");
			}
			dao.updateEventNominations(eventId,eventSessionId);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				testSeatsAvailableAfter = resultSet.getInt("SEATSAVAILABLE");
			}
			assertEquals(testSeatsAvailableBefore-1, testSeatsAvailableAfter);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Negative test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Negative() {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
		int eventid= 9;
		int eventSessionId = 9;
		try {
			dao.updateEventNominations(eventid,eventSessionId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Records not updated properly", e.getMessage());
		}
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */	
		Visitor visitor = new Visitor();
		visitor.setVisitorId(1001);
		int eventid=1001;
		int eventSessionId = 10001;
		boolean registered=false;
		try {
			registered = dao.checkEventsofVisitor(visitor, eventid, eventSessionId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false, registered);
	}
	
	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator(){
		/**
		 * @TODO: Call getEventCoordinator method
		 * Assert the size of return type arraylist
		 */		
		try {
			assertEquals(5, dao.getEventCoordinator().size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent(){
		/**
		 * @TODO: Call getEvent method 
		 * Assert the returned Event type with the passed value of event id
		 */		
		int eventId = 1001;
		int sessionId = 10001;
		try {
			Event event = dao.getEvent(eventId, sessionId);
			assertEquals("Tour", event.getEventtype());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent(){
		/**
		 * @TODO: Create Event object by setting appropriate values
		 * Call insertEvent method by passing this event object
		 * Assert the status of return type of this insertEvent method
		 */		
		Event event = new Event();
		event.setEventid(1010);
		event.setName("a");
		event.setDescription("a");
		event.setPlace("a");
		event.setDuration("10");
		event.setEventtype("a");
		event.setEventCoordinatorId(101);
		event.setEventSession(4);
		event.setSeatsavailable("200");
		try {
			int status = dao.insertEvent(event);
			assertEquals(4, status);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent(){
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method
		 * Update the values of event object
		 * Call updateEvent method by passing this modified event as object
		 * Assert the status of return type of updateEvent method
		 */			
		int eventId = 1003;
		int sessionId = 10003;
		try {
			Event event = dao.getEvent(eventId, sessionId);
			event.setEventtype("cooool");
			assertEquals(1, dao.updateEvent(event));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Junit test case for deleteEvent
	 */
	@Ignore
	public void testDeleteEvent(){
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method		 * 
		 * Call deleteEvent method by passing this event id and event session id as object
		 * Assert the status of return type of updateEvent method
		 */		
		int eventId = 1004;
		int sessionId = 10004;
		try {
			assertEquals(1, dao.deleteEvent(eventId, sessionId));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FERSGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

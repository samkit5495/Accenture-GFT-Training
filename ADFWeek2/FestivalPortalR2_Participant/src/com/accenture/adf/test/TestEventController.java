package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.EventController;

/**
 * Junit test class for EventController
 * 
 */
public class TestEventController {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ModelAndView modelAndView;
	private EventController controller;

	/**
	 * Sets up initial objects required in other methods
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new EventController();
		response = new MockHttpServletResponse();		
	}

	/**
	 * Deallocate the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		modelAndView = null;
		controller = null;
		response = null;
	}

	/**
	 * Test case to test the positive scenario for getAvailableEvents method
	 */
	@Test
	public void testGetAvailableEvents_Positive() {

		try {
			request = new MockHttpServletRequest("GET", "/catalog.htm");
			modelAndView = controller.getAvailableEvents(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
	}

	/**
	 * Executes the negative scenario for getAvailableEvents method
	 */
	@Test
	public void testGetAvailableEvents_Negative() {
		/**
		 * @TODO: Call getAvailableEvents methods  by passing request as null
		 * and assert it for appropriate model view name
		 */	
		try {
			modelAndView = controller.getAvailableEvents(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
			
		}
	}
	
	/**
	 * Test case to test the positive scenario for displayEvent method
	 */
	@Test
	public void testDisplayEvent_Positive() {
		/**
		 * @TODO: Call displayEvent methods and assert
		 * it for appropriate model view name
		 */	
		try {
			request = new MockHttpServletRequest("GET", "/displayEvent.htm");
			String eventId = "1001";
			request.setParameter("eventId",eventId);
			String sessionId = "10001";
			request.setParameter("sessionId",sessionId);
			modelAndView = controller.displayEvent(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/addEvent.jsp", modelAndView.getViewName());
	}

	/**
	 * Executes the negative scenario for displayEvent method
	 */
	@Test
	public void testDisplayEvent_Negative() {
		/**
		 * @TODO: Call displayEvent methods  by passing request as null
		 * and assert it for appropriate model view name
		 */	
		try {
			modelAndView = controller.displayEvent(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
			
		}
	}	
	
	/**
	 * Test case to test the positive scenario for updateEvent method
	 */
	@Test
	public void testUpdateEvent_Positive() {
		/**
		 * @TODO: Call updateEvent methods and assert
		 * it for appropriate model view name
		 */	
		try {
			request = new MockHttpServletRequest("GET", "/updateEvent.htm");
			request.setParameter("eventId","1003");
			request.setParameter("sessionId","10003");
			request.setParameter("eventName","fds");
			request.setParameter("desc","fds");
			request.setParameter("place","sa");
			request.setParameter("duration","ssgr");
			request.setParameter("eventType","gg");
			request.setParameter("ticket","sag");
			request.setParameter("isAdd","false");	
			modelAndView = controller.updateEvent(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/addEvent.jsp", modelAndView.getViewName());
	}

	/**
	 * Executes the negative scenario for updateEvent method
	 */
	@Test
	public void testUpdateEvent_Negative() {
		/**
		 * @TODO: Call updateEvent methods  by passing request as null
		 * and assert it for appropriate model view name
		 */	
		try {
			modelAndView = controller.updateEvent(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
			
		}
	}
	
	/**
	 * Test case to test the positive scenario for displayEvent method
	 */
	@Test
	public void testDeleteEvent_Positive() {
		/**
		 * @TODO: Call deleteEvent methods and assert
		 * it for appropriate model view name
		 */
		try {
			request = new MockHttpServletRequest("GET", "/deleteEvent.htm");
			String eventId = "1006";
			request.setParameter("eventId",eventId);
			String sessionId = "10006";
			request.setParameter("sessionId",sessionId);
			modelAndView = controller.deleteEvent(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
	}

	/**
	 * Executes the negative scenario for displayEvent method
	 */
	@Test
	public void testDeleteEvent_Negative() {
		/**
		 * @TODO: Call deleteEvent methods  by passing request as null
		 * and assert it for appropriate model view name
		 */	
		try {
			modelAndView = controller.deleteEvent(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", e.getMessage());
			
		}
	}		

}

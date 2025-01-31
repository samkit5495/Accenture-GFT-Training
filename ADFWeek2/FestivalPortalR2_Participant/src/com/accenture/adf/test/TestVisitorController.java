package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * Junit test case to test the class VisitorController
 * 
 */
public class TestVisitorController {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession session;
	private ModelAndView modelAndView;
	private VisitorController controller;
	private VisitorDAO visitorDao;

	/**
	 * Set up initial methods required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new VisitorController();
		session = new MockHttpSession();
		response = new MockHttpServletResponse();
		visitorDao = new VisitorDAO();
	}

	/**
	 * Deallocate objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		modelAndView =null;
		controller=null;
		session=null;
		response=null;
		visitorDao=null;
	}

	/**
	 * Positive test case to test the method newVisitor
	 */
	@Ignore
	public void testNewVisitor_Positive() {
		try {
			request = new MockHttpServletRequest("GET", "/newVistor.htm");

			request.setParameter("USERNAME", "ylee");
			request.setParameter("PASSWORD", "password");
			request.setParameter("FIRSTNAME", "TestVFname");
			request.setParameter("LASTNAME", "lname");
			request.setParameter("EMAIL", "mail");
			request.setParameter("PHONENO", "11111");
			request.setParameter("ADDRESS", "testAddress");
			modelAndView = controller.newVisitor(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/registration.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case to test the method newVisitor
	 */
	@Test
	public void testNewVisitor_Negative() {
		/**
		 * @TODO: Call newVisitor method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET", "/newVistor.htm");
		try {
			modelAndView = controller.newVisitor(null,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
	}

	/**
	 * Positive test case to test the method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set request parameters for USERNAME and PASSWORD for valid values
		 * Call searchVisitor method and assert model view name 
		 */	
		request = new MockHttpServletRequest("GET","/searchVisitor.htm");
		request.setParameter("USERNAME", "admin");
		request.setParameter("PASSWORD", "admin");
		try {
			modelAndView=controller.searchVisitor(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("/visitormain.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case of invalid user for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative_InvalidUser() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set request parameters for USERNAME and PASSWORD for invalid values
		 * Call searchVisitor method and assert model view name 
		 */	
		request = new MockHttpServletRequest("GET","/searchVisitor.htm");
		request.setParameter("USERNAME", "ylee");
		request.setParameter("PASSWORD", "passwordttt");
		try {
			modelAndView=controller.searchVisitor(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Invalid Username / Password.",modelAndView.getModel().get("ERROR"));
	}
		
	

	/**
	 * Negative test case for method searchVisitor
	 */
	@Test
	public void testSearchVisitor_Negative() {
		/**
		 * @TODO: Call searchVisitor method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET","/searchVisitor.htm");
		try {
			modelAndView=controller.searchVisitor(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,modelAndView.getViewName());
	}
	

	/**
	 * Positive test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for USERNAME and PASSWORD for valid values
		 * Call registerVisitor method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET", "/eventreg.htm");
		try {
			Visitor visitor=visitorDao.searchUser("admin", "admin");
			request.getSession(true).setAttribute("VISITOR", visitor);
			//request.setParameter("USERNAME","vd31595");
			//request.setParameter("PASSWORD","abc123");
			request.setParameter("eventId","1002");
			//request.setAttribute("eventid", 1002);
			request.setParameter("sessionId","10002");
			modelAndView=controller.registerVisitor(request, response);
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
		assertEquals("/visitormain.jsp", modelAndView.getViewName());
	}	

	/**
	 * Negative test case for method registerVisitor
	 */
	@Test
	public void testRegisterVisitor_Negative() {
		/**
		 * @TODO: Call registerVisitor method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET", "/eventreg.htm");
		try {
			modelAndView=controller.registerVisitor(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,modelAndView.getViewName());
	}

	/**
	 * Positive test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for all valid user values
		 * Call updateVisitor method and assert model view name 
		 */	
		request = new MockHttpServletRequest("GET", "/updatevisitor.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("ylee", "password");
			request.getSession(true).setAttribute("VISITOR", visitor);
			request.setParameter("firstname", "VAIBHAV");
			request.setParameter("lastname","DEOKAR");
			request.setParameter("email","vd31595@gmail.com");
			modelAndView=controller.updateVisitor(request, response);
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
		assertEquals("/updatevisitor.jsp", modelAndView.getViewName());
	}

	/**
	 * Negative test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor_Negative() {
		/**
		 * @TODO: Call updateVisitor method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET", "/eventreg.htm");
		try {
			modelAndView=controller.updateVisitor(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,modelAndView.getViewName());
	}

	/**
	 * Positive test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for all USERNAME, PASSWORD and eventId values
		 * Call unregisterEvent method and assert model view name 
		 */	
		request = new MockHttpServletRequest("GET", "/eventunreg.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("ylee", "password");
			request.getSession(true).setAttribute("VISITOR", visitor);
			request.setParameter("eventId", "1002");
			request.setParameter("eventsessionid","10002");
			modelAndView=controller.unregisterEvent(request, response);
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
		assertEquals("/visitormain.jsp", modelAndView.getViewName());
		
	}

	/**
	 * Negative test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent_Negative() {
		/**
		 * @TODO: Call unregisterEvent method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET", "/eventunreg.htm");
		try {
			modelAndView=controller.unregisterEvent(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
		
	}

	/**
	 * Positive test case for search events by name
	 */
	@Test
	public void testSearchEventsByName_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for eventname
		 * Call searchEventsByName method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET","/searchEventByName.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("ylee", "password");
			request.getSession(true).setAttribute("VISITOR", visitor);
			request.setParameter("eventname","NCCL Semi Finals");
			modelAndView=controller.searchEventsByName(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("/visitormain.jsp", modelAndView.getViewName());
	}

	/**
	 * Positive test case for search events by name catalog
	 */
	@Test
	public void testSearchEventsByNameCatalog_Positive() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for eventname
		 * Call searchEventsByNameCatalog method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET","/searchEventByNameCatalog.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("ylee", "password");
			request.getSession(true).setAttribute("VISITOR", visitor);
			request.setParameter("eventname","NCCL Semi Finals");
			modelAndView=controller.searchEventsByNameCatalog(request, response);
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
		assertEquals("/eventCatalog.jsp",modelAndView.getViewName());
	}

	/**
	 * Test case for show events in asc order
	 */
	@Test
	public void testShowEventsAsc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsAsc method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET","/displayasc.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("ylee", "password");
			request.getSession(true).setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsAsc(request, response);
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
		assertEquals("/visitormain.jsp",modelAndView.getViewName());
		
	}

	/**
	 * Test case for show events in desc order
	 */
	@Test
	public void testShowEventsDesc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsDesc method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET","/displaydesc.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("vd31595", "abc123");
			request.getSession(true).setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsDesc(request, response);
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
		assertEquals("/visitormain.jsp",modelAndView.getViewName());
	}

	/**
	 * Test case for show events catalog asc order
	 */
	@Test
	public void testShowEventsCatalogAsc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsCatalogAsc method and assert model view name 
		 */		
		request = new MockHttpServletRequest("GET","/displaycatalogasc.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("vd31595", "abc123");
			request.getSession(true).setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsCatalogAsc(request, response);
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
		assertEquals("/eventCatalog.jsp",modelAndView.getViewName());
	}

	/**
	 * Test case for show events catalog desc
	 */
	@Test
	public void testShowEventsCatalogDesc() {
		/**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		
		 * Call showEventsCatalogDesc method and assert model view name 
		 */	
		request = new MockHttpServletRequest("GET","/displaycatalogdesc.htm");
		Visitor visitor;
		try {
			visitor = visitorDao.searchUser("vd31595", "abc123");
			request.getSession(true).setAttribute("VISITOR", visitor);
			modelAndView=controller.showEventsCatalogDesc(request, response);
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
		assertEquals("/eventCatalog.jsp",modelAndView.getViewName());
	}

	/**
	 * Negative test case for search events by name
	 */
	@Test
	public void testSearchEventsByName_Negative() {
		/**
		 * @TODO: Call searchEventsByName method by passing request object as null and 
		 * asserting the model view name
		 */	
		request = new MockHttpServletRequest("GET","/searchEventByName.htm");
		try {
			modelAndView=controller.searchEventsByName(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,modelAndView.getViewName());
	}

	/**
	 * Negative test case for search events by name catalog
	 */
	@Test
	public void testSearchEventsByNameCatalog_Negative() {
		/**
		 * @TODO: Call searchEventsByNameCatalog method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = new MockHttpServletRequest("GET","/searchEventByNameCatalog.htm");
		try {
			modelAndView=controller.searchEventsByNameCatalog(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(null, modelAndView.getViewName());
	}

	/**
	 * Negative test case for show events in asc order
	 */
	@Test
	public void testShowEventsAsc_Negative() {
		/**
		 * @TODO: Call showEventsAsc method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = new MockHttpServletRequest("GET","/displayasc.htm");
		try {
			modelAndView=controller.showEventsAsc(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
		
	}

	/**
	 * Negative test case for show events in desc order
	 * 
	 */
	@Ignore
	public void testShowEventsDesc_Negative() {
		/**
		 * @TODO: Call showEventsDesc method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = new MockHttpServletRequest("GET","/displaydesc.htm");
		try {
			modelAndView=controller.showEventsDesc(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
	}

	/**
	 * Negative test case for show events catalog in asc order
	 */
	@Ignore
	public void testShowEventsCatalogAsc_Negative() {
		/**
		 * @TODO: Call showEventsCatalogAsc method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = new MockHttpServletRequest("GET","/displaycatalogasc.htm");
		try {
			modelAndView=controller.showEventsCatalogAsc(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
	}

	/**
	 * Negative test case for show events catalog in desc order
	 */
	@Ignore
	public void testShowEventsCatalogDesc_Negative() {
		/**
		 * @TODO: Call showEventsCatalogDesc method by passing request object as null and 
		 * asserting the model view name
		 */		
		request = new MockHttpServletRequest("GET","/displaycatalogdesc.htm");
		try {
			modelAndView=controller.showEventsCatalogDesc(null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, modelAndView.getViewName());
	}
	
	
	/**
	 * Positive test case for change password
	 */
	/*@Test
	public void testChangePassword_Positive(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*		
	}
	
	*//**
	 * Negative test case for change password with password as null
	 *//*
	@Test
	public void testChangePassword_PasswordNull(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Do not set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*	
	}
	
	*//**
	 * Negative test case for change password with visitor as null
	 *//*
	@Test
	public void testChangePassword_VisitorNull(){
		*//**
		 * @TODO: Create MockHttpServletRequest object 
		 * Do not set visitor object in VISITOR session by calling searchUser method from visitorDAO		 
		 * Set request parameters for password
		 * Call changePassword method and assert status as success
		 *//*		
	}*/
	
	/**
	 * Positive test case for change password
	 */
	@Test
	public void testChangePassword_Positive(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("ylee", "password");	
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);
			request.setParameter("password", "password3");
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("success", modelAndView.getModelMap().get("status"));
		request.setParameter("password", "password");
		modelAndView = controller.changePassword(request, response);
	}
	
	/**
	 * Negative test case for change password with password as null
	 */
	@Test
	public void testChangePassword_PasswordNull(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = visitorDao.searchUser("ylee", "password");			
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);			
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("error", modelAndView.getModelMap().get("status"));
	}
	
	/**
	 * Negative test case for change password with visitor as null
	 */
	@Test
	public void testChangePassword_VisitorNull(){
		try{
			request = new MockHttpServletRequest("GET", "/changePWD.htm");
			Visitor visitor = new Visitor();			
			session.setAttribute("VISITOR", visitor);
			request.setSession(session);
			request.setParameter("password", "password");
			modelAndView = controller.changePassword(request, response);		
		}catch(Exception exception){
			fail("Exception");
		}
		assertEquals("error", modelAndView.getModelMap().get("status"));
	}
}

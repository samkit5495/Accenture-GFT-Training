package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Object[]> registeredEvents;

	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Object[]>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitor=null;
		visitorDAO=null;
		registeredEvents=null;
		
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */		
		visitor.setVisitorId(1008);
		visitor.setUserName("abha");
		visitor.setPassword("abc123");
		visitor.setFirstName("abha");
		visitor.setLastName("kamble");
		visitor.setEmail("abha@gmail.com");
		visitor.setPhoneNumber("8657996883");
		visitor.setAdmin(true);
		
		try {
			visitorDAO.insertData(visitor);
			visitor=visitorDAO.searchUser("abha","abc123");
			
			
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
		
		assertEquals("abha", visitor.getUserName());
		
	}	

	/**
	 * Test case for method searchUser
	 */
	@Test
	public void testSearchUser() {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */		
		try {
			visitor=visitorDAO.searchUser("ylee","password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("ylee", visitor.getUserName());
	}

	/**
	 * Test case for method registerVisitorToEvent
	 */
	@Test
	public void testRegisterVisitorToEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */		
		try {
			visitor=visitorDAO.searchUser("abha","abc123");
			visitorDAO.registerVisitorToEvent(visitor,1003,10003);
			registeredEvents=visitorDAO.registeredEvents(visitor);
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
		boolean res=false;
		for(Object[] e:registeredEvents){
			if(10003==Integer.parseInt(e[7].toString())){
				res=true;
			}
		}
		
		assertEquals(true,res);
		
		
		
		
	}	

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		try {
			visitor=visitorDAO.searchUser("abha","abc123");
			registeredEvents=visitorDAO.registeredEvents(visitor);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean res=false;
		for(Object[] e:registeredEvents){
			if(1003==Integer.parseInt(e[0].toString())){
				res=true;
			}
		}
		
		assertEquals(true,res);
			}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */		
		try {
			visitor=visitorDAO.searchUser("abha","abc123");
			visitorDAO.updateVisitor(visitor);
			visitor.setEmail("kamble@gmail.com");
			visitorDAO.updateVisitor(visitor);
			visitor=visitorDAO.searchUser("abha","abc123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("kamble@gmail.com", visitor.getEmail());
		
	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		try {
			visitor=visitorDAO.searchUser("abha","abc123");
			visitorDAO.unregisterEvent(visitor, 1002,10001);
			registeredEvents=visitorDAO.registeredEvents(visitor);
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
		
		boolean res=true;
		for(Object[] e:registeredEvents){
			if("Vaibhav".equals(e[6])){
				res=false;
			}
		}
		
		assertEquals(true,res);
	}
	
	/**
	 * Test case for method change password
	 */
	/*@Test
	public void testChangePassword_VisitorNull() {
		*//**
		 * @TODO: Call changePassword method by passing visitor object as null
		 *//*		
	}
	*/
	/**
	 * Test case for method change password
	 */
	@Test
	public void testChangePassword_VisitorNull() {
		try {
			visitor = null;
			visitorDAO.changePassword(visitor);
		} catch (SQLException exception) {
			fail("SQL Exception");
		} catch (ClassNotFoundException exception) {
			fail("Class Not Found Exception");
		} catch (Exception exception) {
			fail("NULL Exception");
		}
	}

}

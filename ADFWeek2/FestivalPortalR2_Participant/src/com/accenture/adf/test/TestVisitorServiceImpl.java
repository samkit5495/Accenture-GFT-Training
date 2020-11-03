package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventFacade;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.businesstier.service.VisitorFacade;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;
	private EventFacade eventFacade;
	private EventDAO eventDAO;
	private VisitorDAO visitorDAO;

	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitorList=null;
		visitor=null;
		visitorServiceImpl=null;
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */		
		VisitorFacade visitorService=new VisitorServiceImpl();
		
		Visitor visitor=new Visitor();
		visitor.setVisitorId(1010);
		visitor.setUserName("abha");
		visitor.setPassword("abha");
		visitor.setFirstName("abha");
		visitor.setLastName("abha");
		visitor.setEmail("abha@gmail.com");
		visitor.setPhoneNumber("8657996883");
		visitor.setAddress(null);
		boolean result=visitorService.createVisitor(visitor);
		assertEquals(true, result);
	}
	

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		/**
		 * @TODO: Call searchVisitor method by passing the appropriate arguments 
		 * and then asserting the returned type visitor username with the argument passed
		 */	
		VisitorFacade visitorService=new VisitorServiceImpl();
		Visitor visitor=new Visitor();
		visitor=visitorService.searchVisitor("abha", "abha");
		assertEquals("abha", visitor.getUserName());
	}

	/**
	 * Test case for method RegisterVisitor
	 */
	@Test
	public void testRegisterVisitor() {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */	
		ArrayList<Object[]> eventlist2=visitorServiceImpl.showRegisteredEvents(visitor);
		visitor=visitorServiceImpl.searchVisitor("abha","abha");
		visitorServiceImpl.RegisterVisitor(visitor, 1004, 10004);
		ArrayList<Object[]> eventlist1=visitorServiceImpl.showRegisteredEvents(visitor);
		
		assertEquals(eventlist2.size()+1,eventlist1.size());
		
		
		

		
	}

	/**
	 * Test case for method showRegisteredEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		/**
		 * @TODO: Call showRegisteredEvents method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of showRegisteredEvents method 
		 */	
		List<Object[]> visitorList=new ArrayList<Object[]>();
		visitor=visitorServiceImpl.searchVisitor("abha","abha");
		visitorList=visitorServiceImpl.showRegisteredEvents(visitor);
		boolean result=false;
		for(Object[] o:visitorList){
			
			if(10002==Integer.parseInt(o[8].toString())){
				result=true;
			}
		}
		
		assertEquals(true,result);
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */	
		visitor=visitorServiceImpl.searchVisitor("abha","abha");
		int status=visitorServiceImpl.updateVisitorDetails(visitor);
		boolean result=false;
		if(status>=1){
			result=true;
		}
		assertEquals(true,result);
	}

	/**
	 * Test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */		
		 visitor=visitorServiceImpl.searchVisitor("abha", "abha");
		 ArrayList<Object[]> eventlist1=visitorServiceImpl.showRegisteredEvents(visitor);
		visitorServiceImpl.unregisterEvent(visitor,1002,10002);
		//visitor=visitorServiceImpl.searchVisitor("vd31595", "abc123");
		ArrayList<Object[]> eventlist2=visitorServiceImpl.showRegisteredEvents(visitor);
		assertEquals(eventlist1.size(),eventlist2.size()+1);
		
	}

}

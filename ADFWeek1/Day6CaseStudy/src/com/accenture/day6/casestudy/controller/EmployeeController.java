package com.accenture.day6.casestudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.day6.casestudy.model.Employee;
import com.accenture.day6.casestudy.service.EmployeeServiceFacade;
import com.accenture.day6.casestudy.service.EmployeeServiceIMPL;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int dept = Integer.parseInt(request.getParameter("deptNo"));
		
		EmployeeServiceFacade service=new EmployeeServiceIMPL();
		
		List<Employee> employeeList = service.searchEmployee(dept);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("employeeList", employeeList);
//		RequestDispatcher rd=request.getRequestDispatcher("ListEmployee.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("ListEmployeeJSTL.jsp");
		rd.forward(request, response);
		
	}

}

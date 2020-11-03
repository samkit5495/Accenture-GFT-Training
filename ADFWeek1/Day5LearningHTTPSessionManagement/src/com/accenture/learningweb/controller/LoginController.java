package com.accenture.learningweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.learningweb.model.User;
import com.accenture.learningweb.service.LoginServiceFacade;
import com.accenture.learningweb.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("Servlet getting initialized");
    }
    
    @Override
    public void destroy() {
    	System.out.println("Servlet getting destroyed");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hey u r in doGet");
		
		String txtUsername = request.getParameter("txtUsername");
		String txtPassword = request.getParameter("txtPassword");
		
		LoginServiceFacade service=new LoginServiceImpl();
		
		User user=new User(txtUsername,txtPassword);
		
		PrintWriter pw=response.getWriter();
		
		
		if(service.validateUser(user)){
//			pw.println("<h1>Login Successful</h1>");
//			response.sendRedirect("Success.html");
//			response.sendRedirect("https://portal.accenture.com");
			RequestDispatcher rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
		} else{
			pw.println("<h1 style='color:red;'>Login Failed</h1>");
//			response.sendRedirect("Error.html");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
//			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hey u r in doPost");
	}

}

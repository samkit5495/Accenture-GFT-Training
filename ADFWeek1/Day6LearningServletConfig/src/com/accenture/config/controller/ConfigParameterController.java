package com.accenture.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigParameterController
 */
public class ConfigParameterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig cpcConfig=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigParameterController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
		this.cpcConfig=config;
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("DBURL: ").append(cpcConfig.getInitParameter("DBURL"));
		response.getWriter().append("LogURL: ").append(cpcConfig.getInitParameter("LogURL"));
		
		
		ServletContext context=cpcConfig.getServletContext();
		
		context.setAttribute("Counter", "0");
		
		String username = context.getInitParameter("Username");
		String password = context.getInitParameter("Password");
		
		response.getWriter().append("Username").append(username);
		response.getWriter().append("Password").append(password);
		
		response.sendRedirect("AnotherController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

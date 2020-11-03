package com.accenture.day5.casestudy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.day5.casestudy.model.Voter;
import com.accenture.day5.casestudy.service.VoterServiceFacade;
import com.accenture.day5.casestudy.service.VoterServiceIMPL;

/**
 * Servlet implementation class VoterController
 */
public class VoterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterController() {
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
		HttpSession session=null;
		String operation = request.getParameter("operation");
		PrintWriter pw=response.getWriter();
		if("VOTE".equals(operation)){
			int voterId = Integer.parseInt(request.getParameter("voterId"));
			boolean vote = "on".equals(request.getParameter("vote"));
			VoterServiceFacade service=new VoterServiceIMPL();
			Voter voter = service.searchVoter(voterId);
			if(voter==null){
				pw.write("VoterId not found!!!");
			} else {
				session=request.getSession();
				if(vote){
					if(voter.getVoterAge()>=18){
						voter.setVote(vote);
						if(service.vote(voter))
							pw.write("Successfully Voted");
						else
							pw.write("Error");
					}else{
						pw.write("Cannot Vote : age less than 18");
					}	
				}
//				pw.write(voter.toString());
				session.setAttribute("voter", voter);
			}
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		} else if("LOGOUT".equals(operation)){
			RequestDispatcher rd=request.getRequestDispatcher("VotingSystem.html");
			rd.include(request, response);
			pw.write("Logged Out");
		}
	}

}

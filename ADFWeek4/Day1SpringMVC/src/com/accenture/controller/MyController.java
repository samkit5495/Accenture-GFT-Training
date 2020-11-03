package com.accenture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.User;

@Controller
public class MyController {

	@RequestMapping("myRequest.htm")
	public ModelAndView myRequest(){
		ModelAndView m = new ModelAndView();
//		m.setViewName("Login.html");
		m.setViewName("Login");
		return m;
	}
	
	@RequestMapping("login.htm")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView m=new ModelAndView();
		if(new User(request.getParameter("uname"),request.getParameter("password")).validateUser())
		{
//			m.setViewName("Welcome.html");
			m.setViewName("Welcome");
		}
		else
		{
//			m.setViewName("Error.html");
			m.setViewName("Error");
		}
		return m;
	}
}

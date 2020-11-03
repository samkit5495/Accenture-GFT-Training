package com.accenture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.Person;

@Controller
public class PersonController {

	@RequestMapping("getPerson.htm")
	public ModelAndView createPerson(ModelMap m){
		Person p = new Person();
		m.addAttribute("PERSON",p);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("person");
		return mv;
	}
	
	@RequestMapping("person_data.htm")
	public ModelAndView personalDetails(@ModelAttribute("PERSON") Person p){
		System.out.println(p);
		ModelAndView mv=new ModelAndView();
		mv.addObject("p",p);
		mv.setViewName("showPerson");
		return mv;
	}
}

package com.accenture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private Validator validator;
	
	
	@RequestMapping("getEmployee.do")
	public ModelAndView createEmployee(ModelMap mp){
		Employee e = new Employee();
		mp.addAttribute("EMPLOYEE", e);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("employee");
		return mv;
	}
	
	@RequestMapping("validate.do")
	public ModelAndView validate(@ModelAttribute("EMPLOYEE") Employee e, BindingResult errors){
		ModelAndView mv=new ModelAndView();
		validator.validate(e, errors);
		if(errors.hasErrors()){
			mv.setViewName("employee");
		} else {
			mv.setViewName("displayEmployee");
			mv.addObject("e",e);
		}
		return mv;
	}
}

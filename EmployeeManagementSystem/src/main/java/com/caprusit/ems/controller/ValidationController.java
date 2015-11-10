package com.caprusit.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caprusit.ems.service.ValidationService;

@Controller
public class ValidationController {
	
	@Autowired
	ValidationService validationservice;
	
	@RequestMapping(value="/getAllEmpIds",method=RequestMethod.POST)
	public @ResponseBody String getAllEmployeeIds(){
		
		return validationservice.getAllEmployeeIds();
		
	}
	
	@RequestMapping(value="/getLoggedInEmpIds",method=RequestMethod.POST)
	public @ResponseBody String getLoggedInEmployeeIds(){
				
		return validationservice.getLoggedInEmoloyeeIds();
		
	}
	
	@RequestMapping(value="/getLoggedOutEmpIds",method=RequestMethod.POST)
	public @ResponseBody String getLoggedOutEmployeeIds(){
		
		System.out.println("loggedin emp controller");
			
		return validationservice.getLoggedOutEmployeeIds();
		
	}
	

}

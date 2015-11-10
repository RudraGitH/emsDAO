package com.caprusit.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caprusit.ems.domain.LoginTest;
import com.caprusit.ems.service.IAttendanceService;

@Controller
@RequestMapping(value="/log")
public class AttendanceController {
	
	@Autowired
	private IAttendanceService attendanceService;

	private static Logger logger=Logger.getLogger(AttendanceController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap modelMap) {
		
		logger.info("in attendance controlller");
      
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Integer login(@RequestBody LoginTest test) {

		System.out.println("testlogin" + test);


		return attendanceService.logInOrLogOut(test);
		

	}
}

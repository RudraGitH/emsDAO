package com.caprusit.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.caprusit.ems.service.ISecurityService;

@Controller
public class SecurityController {

	@Autowired
	private ISecurityService securityService;

	
	public String init(ModelMap modelMap) {

		return "login";
	}

}
package com.caprusit.ems.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.service.ISecurityService;

@Controller
public class SecurityController {

	@Autowired
	private ISecurityService securityService;

	
private Logger logger = Logger.getLogger(SecurityController.class);
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.GET)
	public String adminLogin(){
		
		return "AdminLogin";
	}

	@RequestMapping(value = "/adminHome", method = RequestMethod.POST)
	public @ResponseBody Integer adminLogin(@RequestBody Admin admin, HttpServletRequest request) {

		logger.info("in admin security controller");
		logger.info("admin username: " + admin.getAdminId() + " password: " + admin.getPassword());

		int status = securityService.login(admin);
		if (status == 1)
			request.getSession().setAttribute("adminId", admin.getAdminId());

		return status;
	}

	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET)
	public ModelAndView getAdminHomePage(HttpServletRequest request) {

		logger.info("inside getAdminHomePage()");

		HttpSession session = request.getSession(false);

		logger.info("session: " + session);
		if (session != null)
			logger.info("admin id in session: " + session.getAttribute("adminId"));

		return ((session != null) && (session.getAttribute("adminId") != null)) ? new ModelAndView("AdminDashBoard")
				: new ModelAndView("AdminLogin");


	}

	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			logger.info("invalidating session ");
			session.invalidate();
		}

		logger.error("admin logout successfull :" + request.getSession(false));

		return "AdminLogin";

	}

	@RequestMapping(value = "/uploadEmployeeDetailsExcelFile", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody String uploadEmployeeDetailsExcelFile(MultipartHttpServletRequest request) {

		logger.info("inside uploadEmployeeDetailsExcelFile()");
		Iterator<String> itr = request.getFileNames();
		MultipartFile file = request.getFile(itr.next());
		String result=new String();
		logger.info("file name:"+file.getOriginalFilename());
        try {
        	logger.info("fhfhfhfh-----");
			result= securityService.uploadEmployeeDetailsExcelFile(file.getInputStream(),file.getOriginalFilename());
			logger.info("result : "+result);
			
		} 
        catch (Exception e) {
			
			e.printStackTrace();
			
		}
        return result;
		
	}
	

	
}
package com.caprusit.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.SecurityDAOImpl;
import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;
import com.caprusit.ems.domain.User;

@Service
public class SecurityServiceImpl implements ISecurityService{
	
	@Autowired
	private SecurityDAOImpl securityDAOImpl;
	

	public String login(Object object) {
		
		if(object.getClass().equals(com.caprusit.ems.domain.User.class)){
			System.out.println("in SecurityServiceImpl");
			System.out.println(object.getClass());
			
			User user=(User)object;
			securityDAOImpl.login(user);
			
		}else{
			
		}
		return null;
		


	}


	public String forgotPassword(Admin admin, Employee employee) {
		

		
		return null;
	}


	public String changePassword(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}

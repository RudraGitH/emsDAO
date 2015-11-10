package com.caprusit.ems.dao;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

public interface ISecurityDAO {

	public String login(Object object);
	public String forgotPassword(Admin admin,Employee employee);
	public String changePassword(Admin admin);
}

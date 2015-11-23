package com.caprusit.ems.dao;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

public interface ISecurityDAO {

	public String login(Admin admin);
	public String forgotPassword(Admin admin,Employee employee);
	public String changePassword(Admin admin);
	public int saveEmployee(Employee emp);
}

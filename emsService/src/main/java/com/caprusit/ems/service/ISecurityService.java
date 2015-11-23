package com.caprusit.ems.service;

import java.io.InputStream;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

public interface ISecurityService {

	public int login(Admin admin);
	public String forgotPassword(Admin admin,Employee employee);
	public String changePassword(Admin admin);
	public String uploadEmployeeDetailsExcelFile(InputStream excelInputStream,String fileName);
}

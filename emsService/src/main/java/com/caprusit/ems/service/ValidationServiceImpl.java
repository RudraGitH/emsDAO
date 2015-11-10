package com.caprusit.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.ValidationDAO;
import com.caprusit.ems.domain.EmployeeData;
import com.google.gson.Gson;

@Service
public class ValidationServiceImpl implements ValidationService {
	
	@Autowired
	ValidationDAO validationDAO;

	public String getAllEmployeeIds() {
		
	
		List<Object> allEmpData=validationDAO.getAllEmploeeIds();
		/*System.out.println("list size"+allEmpData.size());*/
		
		List<EmployeeData> listOfAllEmpIds=new ArrayList<EmployeeData>();
		
		for(Object data:allEmpData){
			
			Object [] array=(Object [])data;			
			EmployeeData emp=new EmployeeData();			
			emp.setEmpId((Integer)array[0]);
			emp.setEmpName((String)array[1]+" "+(String)array[2]);		
			listOfAllEmpIds.add(emp);
			
		}
		
	
		
		return convertToJson(listOfAllEmpIds);
		
		
	}

	public String getLoggedInEmoloyeeIds() {

        List<Object> loggedInList=validationDAO.getLoggedInEmployeeIds();
        System.out.println("list size loggedinemp"+loggedInList.size());
        		
		return convertToJson(loggedInList);
	}

	public String getLoggedOutEmployeeIds() {
		
		 List<Object> loggedOutList=validationDAO.getLoggedOutEmoloyeeIds();
	        System.out.println("list size logged out emp"+loggedOutList.size());
	        
			
			return convertToJson(loggedOutList);
	}
	
	private String convertToJson(Object obj){
		
		Gson gson=new Gson();
		return gson.toJson(obj);
		
	}

}

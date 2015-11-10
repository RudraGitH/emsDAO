package com.caprusit.ems.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.IAttendanceDAO;
import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.LoginTest;
import com.caprusit.ems.domain.User;



@Service
public class AttendanceServiceImpl implements IAttendanceService{

	@Autowired
	private IAttendanceDAO attendanceDAO;
	
	public boolean inTime(Attendance attendance) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean outTime(Attendance attendance) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	public int logInOrLogOut(LoginTest test){
		
		User user=new User();
		user.setEid(test.getId());
		
		if(test.getType().equalsIgnoreCase("login")){
			
			System.out.println("login executing ");
			
			Attendance att=new Attendance();
			Date date=new Date();
			
			att.setAttendanceDate(date);
			att.setAttendanceId(34);
			att.setDayIndicator(1);
			att.setStartTime(date);
			att.setWorkingHours(0);
			att.setEmployeeId(user.getEid());
			
			
				return attendanceDAO.inTime(att);
			
		}else{
		
			System.out.println("log-out executing ");
			
			return attendanceDAO.outTime(user);
			
		}
	
		


	}

}

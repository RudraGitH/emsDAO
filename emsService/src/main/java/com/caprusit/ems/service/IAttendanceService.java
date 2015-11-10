package com.caprusit.ems.service;

import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.LoginTest;

public interface IAttendanceService {

	public boolean inTime(Attendance attendance);

	public boolean outTime(Attendance attendance);

	public int logInOrLogOut(LoginTest test);
	
}

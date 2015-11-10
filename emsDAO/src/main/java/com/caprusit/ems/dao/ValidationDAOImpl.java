package com.caprusit.ems.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.Employee;

@Repository
public class ValidationDAOImpl implements ValidationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Object> getAllEmploeeIds() {

		Session session = sessionFactory.openSession();

		Criteria allEmployeeIdsCriteria = session.createCriteria(Employee.class);

		Projection allEmployeeIdsProjection1 = Projections.property("employeeId");
		Projection allEmployeeIdsProjection2 = Projections.property("firstName");
		Projection allEmployeeIdsProjection3 = Projections.property("lastName");

		ProjectionList validationProjectionList = Projections.projectionList();
		validationProjectionList.add(allEmployeeIdsProjection1);
		validationProjectionList.add(allEmployeeIdsProjection2);
		validationProjectionList.add(allEmployeeIdsProjection3);

		allEmployeeIdsCriteria.setProjection(validationProjectionList);

		List<Object> allEmpData = allEmployeeIdsCriteria.list();
		
		

		session.close();

		return allEmpData;

	}

	
	public List<Object> getLoggedInEmployeeIds() {

		/*to get logged-in emploee IDs we have to pass 2 */
		return executeCriteria(2);
		

	}

	public List<Object> getLoggedOutEmoloyeeIds() {
		
		/*to get logged-out emploee IDs we have to pass 1 */
		return executeCriteria(1);
	}
	
	private Date getTodayDate(){
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
				
	}
	
	private List<Object> executeCriteria(int type){
		
		Session session = sessionFactory.openSession();

		Criteria employeeIdsCriteria = session.createCriteria(Attendance.class);

		Projection employeeIdsProjection = Projections.property("employeeId");

		Date today= getTodayDate();
		
		Criterion criterion_toady = Restrictions.eq("attendanceDate", today);
		double workingHours=0;
		Criterion criterion_workingHours = (type == 1) ? Restrictions.gt("workingHours",workingHours): Restrictions.eq("workingHours",workingHours);
		
		Criterion conditon=Restrictions.and(criterion_toady,criterion_workingHours);
		ProjectionList employeeIdsProjectionList = Projections.projectionList();
		employeeIdsProjectionList.add(employeeIdsProjection);

		employeeIdsCriteria.setProjection(employeeIdsProjectionList);
		employeeIdsCriteria.add(conditon);

		List<Object> loggedInList = employeeIdsCriteria.list();
		
		session.close();

		return loggedInList;
		
	}

}

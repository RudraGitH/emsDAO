package com.caprusit.ems.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;
import com.caprusit.ems.domain.User;

@Repository
public class SecurityDAOImpl implements ISecurityDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public String login(Object object) {
		
		if(object.getClass().equals(com.caprusit.ems.domain.User.class)){
			
			System.out.println("in dao");
			
			User user=(User)object;
			Session session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			Criterion criterion=Restrictions.eq("employeeId", user.getEid());
			Projection projection=Projections.property("firstName");
			criteria.add(criterion);
			criteria.setProjection(projection);
			Object obj=criteria.list();
			
			System.out.println("object read from db: "+obj);
			
		}else{
			
		}
		return null;
		
	}

	
	public String forgotPassword(Admin admin, Employee employee) {
		
		return null;
	}


	public String changePassword(Admin admin) {
		
		return null;
	}

}

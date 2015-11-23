package com.caprusit.ems.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

@Repository
public class SecurityDAOImpl implements ISecurityDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger=Logger.getLogger(SecurityDAOImpl.class);	
	
	public String login(Admin admin) {		
			
			System.out.println("in dao");
			
			Session session=sessionFactory.openSession();
			
			Criteria criteria=session.createCriteria(Admin.class);
			Criterion criterion=Restrictions.eq("adminId",admin.getAdminId());
			Projection projection=Projections.property("password");
			criteria.add(criterion);
			criteria.setProjection(projection);
			
			
			List<String> passwordList=criteria.list();
			
			logger.info("admin password: "+ passwordList);
			
			String adminPass=(passwordList.size() > 0) ? passwordList.get(0).toString():"notValid";
		
		    return adminPass;
		
	}

	
	public String forgotPassword(Admin admin, Employee employee) {
		
		return null;
	}


	public String changePassword(Admin admin) {
		
		return null;
	}


	public int saveEmployee(Employee emp) {
		
		try {
			Session session=sessionFactory.openSession();
			Transaction ts=session.beginTransaction();
			session.saveOrUpdate(emp);
			ts.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}


}

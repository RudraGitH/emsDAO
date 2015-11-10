package com.caprusit.ems.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.Employee;


@Configuration
public class ParentConfigBean {
	
	@Value("${driverClassName}")
	private String driverClassName;

	@Value("${url}")
	private String url;

	@Value("${userName}")    
	private String userName;

	@Value("${password}")
	private String password;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() throws Exception{
		
		LocalSessionFactoryBean  factory= new LocalSessionFactoryBean ();
		factory.setDataSource(dataSource());
		factory.setAnnotatedClasses(Employee.class,Attendance.class);
		Properties p=new Properties();
		
	    p.load(new ClassPathResource("hibernate.properties").getInputStream()); //load gives FileNotFound and IOException

		factory.setHibernateProperties(p);
		System.out.println("local session factory created"+factory);
		
		return  factory;
		
		
		
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer placeholderConfigurer() {
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();

		Resource resource = new ClassPathResource("database.properties");

		placeholderConfigurer.setLocation(resource);
		return placeholderConfigurer;

	}
	
}

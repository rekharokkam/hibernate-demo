package com.learning.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{

	/*Applying Singleton Pattern*/
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory (){
		try{
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");//Needed only for .xml file
			
//			configuration.addAnnotatedClass(User.class);//Needed only for hibernate.properties file
			
//			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build()); //This is for hibernate.properties file
			
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		}catch (Exception e)
		{
			e.printStackTrace(System.err);
			throw new RuntimeException("There was an error building the session factory");
		}
	}
	
	public static SessionFactory getSessionFactory (){
		return sessionFactory;
	}
}

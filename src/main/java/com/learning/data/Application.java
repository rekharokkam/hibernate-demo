package com.learning.data;

import java.util.Date;

import org.hibernate.Session;

import com.learning.data.entities.User;

public class Application
{

	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
		
		User user = new User ();
		user.setBirthDate(new Date());
		user.setCreatedBy("rrokkam");
		user.setCreatedDate(new Date());
		user.setEmailAddress("xyz@yahoo.com");
		user.setFirstName("gavin");
		user.setLastName("king");
		user.setLastUpdatedBy("rrokkam");
		user.setLastUpdatedDate(new Date());
		
		session.getTransaction().begin();
		session.save(user);
//		session.getTransaction().commit();
//		
System.out.println("UserId : " + user.getUserId());		
		
		session.close();
	}
}

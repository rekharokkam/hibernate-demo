package com.learning.data;

import java.util.Date;

import org.hibernate.Session;

//import com.learning.data.entities.TimeTest;

import com.learning.data.entities.User;

public class Application
{

	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		User user = new User ();
		user.setBirthDate(new Date());
		user.setCreatedBy("rrokkam");
		user.setCreatedDate(new Date());
		user.setEmailAddress("9.10@yahoo.com");
		user.setFirstName("9");
		user.setLastName("10");
		user.setLastUpdatedBy("rrokkam");
		user.setLastUpdatedDate(new Date());
		
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();//Transaction should be commited for changes to be permanent

		session.refresh(user);
		
System.out.println(user);		
		
		
//		session.beginTransaction();
//		User dbUser = (User)session.get(User.class, user.getUserId());
//System.out.println("DB User : \n" + dbUser);		
//		dbUser.setFirstName("Joe");
//		session.update(dbUser);
//		session.getTransaction().commit();

//System.out.println("\nAfter Update : \n" + session.get(User.class, user.getUserId()));
		
		
		
		/* Learning TimeStamp @Temporal annotation*/
//		try{
//			session.beginTransaction();
//			TimeTest timeTest = new TimeTest(new Date ());
//			session.save(timeTest);
//			session.getTransaction().commit();
//			
//			session.refresh(timeTest);
//			
//System.out.println(timeTest);			
//			
//		}catch (Exception e){
//			e.printStackTrace(System.err);
//		}finally{
//			session.close();
//			HibernateUtil.getSessionFactory().close();
//		}
	}
}

package com.learning.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.hibernate.jdbc.Work;

import com.learning.data.entities.Address;
import com.learning.data.entities.Bank;

//import com.learning.data.entities.TimeTest;

import com.learning.data.entities.User;

public class Application
{

	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			/* Testing Isolation level*/
			session.doWork(new Work()
			{
				
				public void execute(Connection conn) throws SQLException
				{
					System.out.println("Default Isolation level : " + Environment.isolationLevelToString(conn.getTransactionIsolation()));
				}
			});
			
			
//			Bank bank = new Bank ();
//			bank.setName("Federal trust");
//			bank.setAddressLine1("33 wall Street");
//			bank.setAddressLine2("Suite 302");
//			bank.setCity("New York");
//			bank.setState("NY");
//			bank.setZipCode("27914");
//			bank.setCreatedBy("rrokkam");
//			bank.setCreatedDate(new Date());
//			bank.setLastUpdatedBy("rrokkam");
//			bank.setLastUpdatedDate(new Date());
//			bank.setInternational(false);
//			bank.getContacts().put("MANAGER", "Joe");
//			bank.getContacts().put("TELLER", "Mary");
//			
//			Transaction transaction = session.beginTransaction();
//			session.save(bank);
//			transaction.commit();
			
//			User user = new User ();
//			user.setAge(22);
//			user.setBirthDate(new Date());
//			user.setCreatedBy("rrokkam");
//			user.setCreatedDate(new Date());
//			user.setEmailAddress("9.10@yahoo.com");
//			user.setFirstName("9");
//			user.setLastName("10");
//			user.setLastUpdatedBy("rrokkam");
//			user.setLastUpdatedDate(new Date());
//			
//			Address userAddress1 = new Address ();
//			userAddress1.setAddressLine1("line1");
//			userAddress1.setAddressLine2("line2");
//			userAddress1.setCity("Philadelphia");
//			userAddress1.setState("PA");
//			userAddress1.setZipCode("12345");
//
//			Address userAddress2 = new Address ();
//			userAddress2.setAddressLine1("line3");
//			userAddress2.setAddressLine2("line4");
//			userAddress2.setCity("New York");
//			userAddress2.setState("NY");
//			userAddress2.setZipCode("45643");
//
//			user.getAddress().add(userAddress1);
//			user.getAddress().add(userAddress2);
//			
//			session.getTransaction().begin();
//			session.save(user);
//			session.getTransaction().commit();//Transaction should be commited for changes to be permanent
//	
//			session.refresh(user);
			
//System.out.println(user);		
		
		
//			session.beginTransaction();
//			User dbUser = (User)session.get(User.class, user.getUserId());
//	System.out.println("DB User : \n" + dbUser);		
//			dbUser.setFirstName("Joe");
//			session.update(dbUser);
//			session.getTransaction().commit();

//System.out.println("\nAfter Update : \n" + session.get(User.class, user.getUserId()));
		
		
		
		/* Learning TimeStamp @Temporal annotation*/
		
//			session.beginTransaction();
//			TimeTest timeTest = new TimeTest(new Date ());
//			session.save(timeTest);
//			session.getTransaction().commit();
//			
//			session.refresh(timeTest);
//			
//System.out.println(timeTest);		
		
//			
		}catch (Exception e){
			e.printStackTrace(System.err);
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}

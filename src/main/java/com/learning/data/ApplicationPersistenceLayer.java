package com.learning.data;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.dao.HibernateUserDao;
import com.learning.data.dao.interfaces.UserDao;
import com.learning.data.entities.Address;
import com.learning.data.entities.Credential;
import com.learning.data.entities.User;

public class ApplicationPersistenceLayer
{
	public static void main(String[] args)
	{
		Session session = null;
		Transaction tx = null;
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			
			UserDao userDao = new HibernateUserDao(session);
			tx = session.beginTransaction();
			
			userDao.save(createUser());
			
			tx.commit();
			
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}
	
	private static User createUser() {
		User user = new User();
		Address address = createAddress();
		user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}
	
	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUserName("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("corporate");
		return address;
	}

}

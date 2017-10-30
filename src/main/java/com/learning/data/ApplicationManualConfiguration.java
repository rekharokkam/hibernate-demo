package com.learning.data;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learning.data.entities.AccountType;

/*
 * Manual configuration demo
 */
public class ApplicationManualConfiguration
{
	public static void main(String[] args)
	{
		/* Configuration */
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(AccountType.class);
		
		configuration.setProperties(new Properties () {
			{
				put ("hibernate.connection.username", "infinite");
				put ("hibernate.connection.password", "skills");
				put ("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
				put ("hibernate.connection.url", "jdbc:mysql://localhost:3306/ifinances");
			}
		});
		
		/* Building session factory */
		SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		
		/* Obtain session and call persistence methods*/
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		AccountType accountType = new AccountType();
//		
//		accountType.setName("Checking");
//		accountType.setCreatedDate(new Date());
//		accountType.setLastUpdatedDate(new Date());
//		accountType.setCreatedBy("rrokkam");
//		accountType.setLastUpdatedBy("rrokkam");
//		
//		session.save(accountType);
		
		session.getTransaction().commit();
		
		session.close();
	}
}

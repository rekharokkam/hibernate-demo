package com.learning.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.dao.HibernateUserCredentialViewDao;
import com.learning.data.dao.interfaces.UserCredentialViewDao;

public class ApplicationView
{
	public static void main(String[] args)
	{
		Session session = null;
		Transaction tx = null;
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			UserCredentialViewDao userCredentialViewDao = new HibernateUserCredentialViewDao(session);
			
			System.out.println(userCredentialViewDao.findById(1L));
			
			tx.commit();
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

package com.learning.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.dao.HibernateUserCredentialViewDao;
import com.learning.data.dao.interfaces.UserCredentialViewDao;
import com.learning.data.entities.UserCredentialView;

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
			
//			System.out.println(userCredentialViewDao.findById(1L));
			List<UserCredentialView> userCredentialViews = userCredentialViewDao.findByUserName("jon");
			for (UserCredentialView userCredentialView: userCredentialViews){
				System.out.println(userCredentialView.getFirstName());
			}
			
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

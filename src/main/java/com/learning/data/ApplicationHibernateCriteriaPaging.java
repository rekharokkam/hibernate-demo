package com.learning.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.learning.data.entities.Transaction;

public class ApplicationHibernateCriteriaPaging
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		int pageNumber = 3;
		int pageSize = 4;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Transaction.class);
			
			criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);
			
			List<Transaction> transactions = criteria.
					addOrder(Order.desc("title")).list();
			
			for (Transaction trans : transactions){
				System.out.println(trans.getTitle());
			}
			
			tx.commit();
		} catch (Exception exception) {
			exception.printStackTrace(System.err);
			tx.rollback();
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}
}

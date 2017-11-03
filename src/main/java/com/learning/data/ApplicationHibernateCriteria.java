package com.learning.data;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.learning.data.entities.Transaction;

public class ApplicationHibernateCriteria
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Criterion criterion1 = Restrictions.le("amount", new BigDecimal("20.00"));
			Criterion criterion2 = Restrictions.eq("transactionType", "Withdrawl");
			
			List<Transaction> transactions = session.
					createCriteria(Transaction.class).
					add(Restrictions.and(criterion1, criterion2)). //either this way to add restrictions OR add them individually
//					add (criterion1).
//					add(criterion2).
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

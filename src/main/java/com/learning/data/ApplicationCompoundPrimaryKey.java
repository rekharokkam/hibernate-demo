package com.learning.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.entities.Currency;
import com.learning.data.entities.ids.CurrencyId;

public class ApplicationCompoundPrimaryKey
{
	public static void main(String[] args)
	{
		Session session = null;
		Session session2 = null;
		
		Transaction tx = null;
		Transaction tx2 = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Currency currency = new Currency();
			currency.setCountryName("Canada");
			currency.setName("Dollar");
			currency.setSymbol("$");
			
			session.persist(currency);
			
			tx.commit();
			
			session2 = HibernateUtil.getSessionFactory().openSession();
			tx2 = session2.beginTransaction();
			
			Currency dbCurrency = (Currency)session2.get(Currency.class, new CurrencyId("Dollar", "Canada"));
			System.out.println("Currency fetched from DB : " + dbCurrency.getName());
			
			tx2.commit();
			
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
			
			if (null != tx2){
				tx2.rollback();
			}
		} finally {
			session.close();
			session2.close();
			HibernateUtil.closeSessionFactory();
		}
	}
}

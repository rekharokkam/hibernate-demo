package com.learning.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.entities.Currency;
import com.learning.data.entities.Market;

public class ApplicationCompoundJoinColumns
{
	public static void main(String[] args)
	{
		Session session = null;
		Transaction tx = null;
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.getTransaction();
			
			tx.begin();
			
			Currency japanCurrency = new Currency();
			japanCurrency.setCountryName("Japan");
			japanCurrency.setName("Yen");
			japanCurrency.setSymbol("Y");
			
			Market market = new Market ();
			market.setMarketName("Japan Stock Exchange");
			market.setCurrency(japanCurrency);

			session.persist(market);
			
			tx.commit();
			
			Market dbMarket = (Market) session.get(Market.class, market.getMarketId());
			System.out.println(dbMarket.getCurrency().getName());
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}
}

package com.learning.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.entities.Bond;
import com.learning.data.entities.Stock;

public class ApplicationSuperClass
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
			
			Stock stock = createStock();
			session.save (stock);
			
			Bond bond = createBond();
			session.save(bond);
			
			tx.commit();
			
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}

	}
	
	private static Bond createBond() {
		Bond bond = new Bond();
		bond.setInterestRate(new BigDecimal("123.22"));
		bond.setIssuer("JP Morgan Chase");
		bond.setMaturityDate(new Date());
		bond.setPurchaseDate(new Date());
		bond.setName("Long Term Bond Purchases");
		bond.setValue(new BigDecimal("10.22"));
		return bond;
	}

	private static Stock createStock(){
		Stock stock = new Stock();
		stock.setIssuer("Allen Edmonds");
		stock.setName("Private American Stock Purchases");
		stock.setPurchaseDate(new Date());
		stock.setQuantity(new BigDecimal("1922"));
		stock.setSharePrice(new BigDecimal("100.00"));
		return stock;
	}

}

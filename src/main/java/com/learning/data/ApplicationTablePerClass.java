package com.learning.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.entities.Bond;
import com.learning.data.entities.Investment;
import com.learning.data.entities.Portfolio;
import com.learning.data.entities.Stock;

public class ApplicationTablePerClass
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
			
			Portfolio portfolio = new Portfolio();
			portfolio.setName("First Investments");
			
			Stock stock = createStock();
			stock.setPortfolio(portfolio);
			
			Bond bond = createBond();
			bond.setPortfolio(portfolio);
			
			portfolio.getInvestments().add(stock);
			portfolio.getInvestments().add(bond);
			
			session.save (stock);
			session.save(bond);
			
			tx.commit();
			
			Portfolio dbPortfolio = (Portfolio)session.get(Portfolio.class, portfolio.getPortfolioId());
			session.refresh(dbPortfolio);
			
			for (Investment investment : dbPortfolio.getInvestments()){
				System.out.println(investment.getName());
			}
			
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

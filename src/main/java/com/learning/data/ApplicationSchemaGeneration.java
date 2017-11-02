package com.learning.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.dao.HibernateBankDao;
import com.learning.data.dao.interfaces.BankDao;
import com.learning.data.entities.Bank;

public class ApplicationSchemaGeneration
{
	public static void main(String[] args)
	{
		Session session = null;
		Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			
			tx = session.beginTransaction();
			
			BankDao bankDao = new HibernateBankDao(session);
			bankDao.save(createBank());
			
			tx.commit();
			
		}catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
			
		}finally{
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}
	
	private static Bank createBank() {
		Bank bank = new Bank();
		bank.setName("First United Federal");
		bank.setAddressLine1("103 Washington Plaza");
		bank.setAddressLine2("Suite 332");
		bank.setCity("New York");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipCode("10000");
		return bank;
	}


}

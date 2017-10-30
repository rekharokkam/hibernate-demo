package com.learning.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.data.entities.Account;
//import com.learning.data.entities.AccountType;

public class ApplicationEnumeration
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
//			Account account = createNewAccount();
//			account.setAccountType(AccountType.SAVING);
//			
//			session.save(account);
			
			
			Account dbAccount = (Account) session.get(Account.class, 1L);
			System.out.println(dbAccount.getName());
			System.out.println(dbAccount.getAccountType());
			
			tx.commit();
			
		} catch (Exception exception){
			tx.rollback();
			exception.printStackTrace(System.err);
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}

	}
	
	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}

}

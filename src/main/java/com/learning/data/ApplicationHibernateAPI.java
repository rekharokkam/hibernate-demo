package com.learning.data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
//import org.hibernate.SessionFactory;

import com.learning.data.entities.Account;
import com.learning.data.entities.Bank;
//import com.learning.data.entities.Bank;
import com.learning.data.entities.Transaction;

public class ApplicationHibernateAPI
{
	public static void main(String[] args)
	{
		//This is demo for Entity different states and transition into different states. Its not working Code - starts here
//		Bank bank = new Bank (); //Transient State. Object is created using new Operator and constructor
//		//Set Bank Other properties
//		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession(); //Persistence Context 1
//		org.hibernate.Transaction tx = session.beginTransaction();
//		session.save(bank); //Persistence State
//		tx.commit(); //Persistence Context will sync Object model with Database model. New Bank will be visible in the database
//		session.close ();//Close Persistence Context 1. Bank Object is now in Detached State
//		
//		Session session2 = factory.openSession();//Persistence Context 2
//		org.hibernate.Transaction tx2 = session.beginTransaction();
//		session2.delete(bank);//Removed state from Detached State. Only hibernate allows this NOT JPA
//		tx2.commit(); //Persistence Context will sync with database removing the bank Entity.
//		session.close();//Persistence Context 2 is closed.
		
		//This is demo for Entity different states and transition into different states. Its not working code - ends here
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		//---------Entity State change from Transient to Persistent and How Entity gets associated with Persistence COntext - starts here
//		Account account = createNewAccount();
//		
//		Transaction shoeTransaction = createShoePurchase(account);
//		Transaction beltTransaction = createNewBeltPurchase(account);
//		
//		account.getTransactions().add(shoeTransaction);
//		account.getTransactions().add(beltTransaction);
//		
//		System.out.println(session.contains(account));
//		System.out.println(session.contains(shoeTransaction));
//		System.out.println(session.contains(beltTransaction));
		
		try{
			
//			session.save(account);
//			
//			System.out.println(session.contains(account));
//			System.out.println(session.contains(shoeTransaction));
//			System.out.println(session.contains(beltTransaction));
			
//			//---------Entity State change from Transient to Persistent and How Entity gets associated with Persistence Context - ends here
			

		//----------2 retrieve methods - get() and load() testing starts here
//			Bank bank = (Bank)session.get(Bank.class, 123L);//When we pass in a non-existant Id then hibernate will return null. Hence when we try to access getName on null Object "NullPointerException is thrown.
//			Bank bank = (Bank)session.get(Bank.class, 1L);
//			System.out.println("Method executed");
//			bank = (Bank) session.get(Bank.class, 1L);//Hibernate retrieves the Object from the Persistence Cache instead of hitting the database. In the output there is only one SQL statement
//			System.out.println(bank.getName());
		

//			Bank bank = (Bank)session.load(Bank.class, 1L);
//			System.out.println("Method executed");//This is printed first. Then SQL statement because load() method returns a proxy and actual database call happens only after the first time data is retrieved. getName() in this example
//			bank = (Bank) session.load(Bank.class, 1L);//Hibernate retrieved the Object from Cache instead of the database.
//			System.out.println(bank.getName());
			//----------2 retrieve methods - get() and load () testing ends here
			
			//Modifying the Persistent Entity - Starts here 
			
//			Bank bank = (Bank)session.get(Bank.class, 3L);
//			bank.setName("New Hope Bank");
//			bank.setLastUpdatedBy("Rekha");
			//No need of calling any method on the session Object. tx.commit() will take care of persisting these changes to database.
			
			//Modifying the Persistent Entity - Ends here 
			
			
			//Removing an Entity - Starts here
//			Bank bank = (Bank)session.get(Bank.class, 2L);
//			System.out.println(session.contains(bank));
//			
//			session.delete(bank);
//			
//			System.out.println("Method invocation");
//			System.out.println(session.contains(bank));
//			
			//Removing an Entity - Ends here
			
			//Re-Attaching a detached session - starts here
//			Bank bank = (Bank) session.get(Bank.class, 1L);
//			tx.commit();
//			session.close();//Bank Object is now detached.
//			
//			Session session2 = HibernateUtil.getSessionFactory().openSession();
//			org.hibernate.Transaction tx2 = session2.beginTransaction();
//			
//			//check if the new session contains the bank Object
//			System.out.println(session2.contains(bank));
//			session2.update(bank);//Re-Attach the detached bank Object
//			bank.setName("Test Bank");
//			bank.setLastUpdatedBy("Rekha");
//			
//			System.out.println("Method Invocation");
//			System.out.println(session2.contains(bank));
//			tx2.commit();
//			session2.close();
			//Re-Attaching a detached session - ends here

			//SaveOrUpdate demo - starts here
//			Bank detachedBank = (Bank)session.get(Bank.class, 1L);
//			tx.commit();
//			session.close();
//			
//			Bank transientBank = createBank();
//			Session session2 = HibernateUtil.getSessionFactory().openSession();
//			org.hibernate.Transaction tx2 = session2.beginTransaction();
//			
//			session2.saveOrUpdate(transientBank);
//			session2.saveOrUpdate(detachedBank);
//			
//			detachedBank.setName("re-attached Bank");
//			
//			tx2.commit();
//			session2.close();
			
			//SaveOrUpdate demo - ends here
			
			//flush() Method demo - starts here
			Bank bank = (Bank)session.get(Bank.class, 1L);
			bank.setName("Something different again for Exception");
			System.out.println("Calling Flush");
			session.flush();
			
			bank.setAddressLine1("Another Address Line again for Exception");
			System.out.println("Calling Commit");
			
			throwRuntimeException ();
			
			tx.commit();
			//flush() method demo - ends here
			
		}catch (Exception e){
			tx.rollback();
			e.printStackTrace(System.err);
			
		}finally {
//			session.close();
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
	
	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
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
	
	private static void throwRuntimeException (){
		throw new RuntimeException("On purpose");
	}

}

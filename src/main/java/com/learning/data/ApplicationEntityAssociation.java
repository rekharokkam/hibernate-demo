package com.learning.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;

import com.learning.data.entities.Account;
import com.learning.data.entities.Address;
import com.learning.data.entities.Budget;
import com.learning.data.entities.Credential;
import com.learning.data.entities.Transaction;
import com.learning.data.entities.User;

public class ApplicationEntityAssociation
{
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
//			Transaction tx = session.beginTransaction();
//
//			User user = new User();
//			user.setFirstName("Kevin11");
//			user.setLastName("Bowersox11");
//			user.setAge(30);
//			user.setBirthDate(new Date());
//			user.setCreatedBy("Kevin11 Bowersox11");
//			user.setCreatedDate(new Date());
//			user.setEmailAddress("kevin.bowersox@navy.mil");
//			user.setLastUpdatedDate(new Date());
//			user.setLastUpdatedBy("Kevin Bowersox");
//
//			Credential credential = new Credential();
//			credential.setUserName("kevin");
//			credential.setPassword("kevin");
//			credential.setUser(user);
//			
//			user.setCredential(credential);
//			session.save(credential);
			
//			tx.commit();
//			
//			User fetchedUser = (User)session.get(User.class, credential.getUser().getUserId());
//			
//			System.out.println(fetchedUser);
			
			
			org.hibernate.Transaction tx = session.beginTransaction();
//			Account account = createNewAccount();
//			
//			Budget budget = new Budget ();
//			budget.setName("Emergency Fund");
//			budget.setPeriod("Yearly");
//			budget.setGoalAmount(new BigDecimal(10000.00));
//			
//			budget.getTransactions().add(createNewBeltPurchase(account, budget));
//			budget.getTransactions().add(createShoePurchase(account, budget));
//			
//			session.save(budget);
			
			Account account = createNewAccount();
			Account account2 = createNewAccount();
			
			User user = createUser();
			User user2 = createUser();
			
			account.getUsers().add(user);
			account.getUsers().add(user2);
			
			account2.getUsers().add(user);
			account2.getUsers().add(user2);
			
			user.getAccounts().add(account);
			user.getAccounts().add(account2);
			
			user2.getAccounts().add(account);
			user2.getAccounts().add(account2);
			
			session.save(account);
			session.save(account2);

//			
			tx.commit();
			
			//Testing Bi-Directional flow by fetching a transaction from db through session
//			Budget budget1 = (Budget)session.get(Budget.class, new Long (11));
//			System.out.println(budget1.getName());
			
			
		}catch (Exception e){
			e.printStackTrace(System.err);
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	private static Transaction createNewBeltPurchase(Account account, Budget budget) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
//		beltPurchase.setBudget(budget);
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

	private static Transaction createShoePurchase(Account account, Budget budget) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
//		shoePurchase.setBudget(budget);
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
	
	private static User createUser() {
		User user = new User();
		Address address = createAddress();
		user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUserName("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("corporate");
		return address;
	}
}

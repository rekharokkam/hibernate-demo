package com.learning.data;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.learning.data.entities.Bank;

public class ApplicationJPAAPI
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		EntityTransaction tx = null;
		
		try{
			emf = Persistence.createEntityManagerFactory("infinite-finances");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
//			Bank bank = createBank();
//			em.persist(bank);
			
//			Bank bank = em.find(Bank.class,1L); // find Method is similar to get() method on Session Object in Hibernate. 
//			System.out.println(em.contains(bank));//Checking to see if the bank entity is in the persistence context
//			System.out.println(bank.getName());
			
//			Bank bank = em.find(Bank.class,12L); // find () method returns null Object for a non-existent Object similar to get () method in hibernate
//			System.out.println(em.contains(bank));//Checking to see if the bank entity is in the persistence context
//			System.out.println(bank.getName());//throws NullPointerException as bank object is null
			
//			Bank bank = em.getReference(Bank.class, 1L); //getReference() method is similar to load () method in hibernate.
			//getReference() method returns a proxy Object and holds off on database call until a getter method id invoked
//			System.out.println(em.contains(bank));
//			System.out.println(bank.getName());

//			Bank bank = em.getReference(Bank.class, 12L); //since getReference() returns a proxy Object, when we invoke getter method we get EntityNotFoundException 
//			System.out.println(em.contains(bank));
//			System.out.println(bank.getName());

			//Any time an Entity in the persistence Context is modified DO NOT CALL any methods on Session/EntityManager. tx.commit() will sync the changes with db.
//			Bank bank = em.find(Bank.class, 1L);
//			System.out.println("Prior to update : " + bank.getName());
//			bank.setName("Another demonstration");//JPA/Hibernate recognizes that this Object is dirtied and syncs with the database when tx is committed.
			
//			Bank bank = em.find (Bank.class, 1L);
//			System.out.println("Does Persistence Context contains the bank entity before Remove operation : " + em.contains(bank));
//			
//			em.remove(bank);//Entity moves from persistent state to removed state.
//			
//			System.out.println("Does Persistence Context contains the bank entity after Remove operation : " + em.contains(bank));
			
			//merge() method works exactly like the merge() in hibernate.
			Bank bank = em.find(Bank.class, 2L);//Looks for the entity in the persistence cache first if not found looks in the database. 
			em.detach(bank);
			System.out.println("After detaching is Bank entity found in the persistence context :: " + em.contains(bank));
			
			bank.setName("Something else");
			
			/*
			 * merge() method takes an entity and returns an entity. 
			 * This method first looks for the parameter Object in the persistence Context if not found queries the database to fetch the Object.
			 * If the Object was found in database then merges the changes made on the parameter Object with the Object fetched from Database and
			 * adds the returned Object onto persistence Context and on tx.commit() these changes will be persisted.
			 * If the Object was NOT found in database or Persistence Context then treats the parameter Object as transient and places the Object in 
			 * persistence context and returns the obj placed in the persistence context, inserts a new record on tx.commit().
			 * 
			 * bank2 is the object in persistence context NOT bank Obj
			 */
			Bank bank2 = em.merge(bank);
			
			bank.setName("Something else 2");//This never gets persisted into db as bank is not the persistent object.
			
			tx.commit();//Any changes in the persistence Context are synced with db
			
		} catch (Exception exception){
			exception.printStackTrace(System.err);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
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

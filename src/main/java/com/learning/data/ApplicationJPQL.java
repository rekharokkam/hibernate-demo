package com.learning.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.learning.data.entities.Account;
import com.learning.data.entities.Transaction;

public class ApplicationJPQL
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		Scanner scanner = new Scanner (System.in);
		
		try{
			emf = Persistence.createEntityManagerFactory("infinite-finances");
			em = emf.createEntityManager();
			
			tx = em.getTransaction();
			tx.begin();
			
//			TypedQuery<Transaction> transactionQuery = em.createQuery("from Transaction t order by t.title", Transaction.class);//Basic Query
//			TypedQuery<Transaction> transactionQuery = em.createQuery("from Transaction t "
//					+ " where (t.amount between 75 and 100) and t.title like '%s'"
//					+ " order by t.title", Transaction.class); // Expression Query
//			TypedQuery<Transaction> transactionQuery = em.createQuery("from Transaction t "
//					+ " where (t.amount between :firstAmount and :secondAmount) and t.title like '%s'"
//					+ " order by t.title", Transaction.class);//Named Parameter
//
//			System.out.println("Please enter first amount");
//			transactionQuery.setParameter("firstAmount", new BigDecimal(scanner.next()));
//
//			System.out.println("Please enter second amount");
//			transactionQuery.setParameter("secondAmount", new BigDecimal(scanner.next()));

//			TypedQuery<Transaction> transactionQuery = em.createQuery("from Transaction t "
//					+ " where (t.amount between ?1 and ?2) and t.title like '%s'"
//					+ " order by t.title", Transaction.class);//Position Parameter
//
//			transactionQuery.setParameter(1, new BigDecimal(75));
//			transactionQuery.setParameter(2, new BigDecimal(100));
//			
//			List<Transaction> transactions = transactionQuery.getResultList();
//			
//			for (Transaction trans : transactions){
//				System.out.println(trans.getTitle());
//			}

			
			
//			TypedQuery<Account> accountQuery = em.createQuery ("select distinct a from Transaction t "
//					+ " join t.account a"
//					+ " where t.amount > 500 and t.transactionType = 'Deposit'", Account.class); //Explicit Join Query. No need of ON clause as Hibernate will build it from @ManyToOne relationship
			
//			Query query = em.createQuery("select distinct t.account.name, concat (concat (t.account.bank.name, ' '), t.account.bank.address.state) "
//					+ "from Transaction t "
//					+ "where t.amount > 500 and t.transactionType = 'withdrawl'");
			
			Query namedQuery = em.createNamedQuery("Account.byWithdrawlAmount");
			namedQuery.setParameter("amount", new BigDecimal("99"));
			
			List<Object[]> discreetStrings = namedQuery.getResultList();
			for (Object[] objects : discreetStrings){
				System.out.println(objects[0]);
				System.out.println(objects[1]);
			}
			
			tx.commit();
			
		}catch (Exception exception){
			exception.printStackTrace(System.err);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
			scanner.close();
		}
	}
}
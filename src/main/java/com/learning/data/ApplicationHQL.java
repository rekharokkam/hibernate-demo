package com.learning.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learning.data.entities.Account;

public class ApplicationHQL
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
//			Query transactionQuery = session.createQuery("select t from Transaction t order by t.title");//Basic Query
//			Query transactionQuery = session.createQuery("select t from Transaction t where t.amount > 75 and t.transactionType = 'Withdrawl'");//Expression
//			Query transactionQuery = session.createQuery ("select t from Transaction t where t.amount > ? and t.transactionType = 'Withdrawl'");//Position Parameters
//			Query transactionQuery = session.createQuery ("select t from Transaction t where t.amount > :amount and t.transactionType = 'Withdrawl'");//Named Parameters
//			
//			System.out.println("Please specify an amount");
//			
//			transactionQuery.setParameter("amount", new BigDecimal(scanner.next()));
//			List<Transaction> transactions = transactionQuery.list();
			
//			for (Transaction trans : transactions){
//				System.out.println(trans.getTitle());
//			}
			
//			Query transactionQuery = session.createQuery ("select distinct t.account from Transaction t "
//					+ "where t.amount > 500 and lower(t.transactionType) = 'Deposit'"); //Implicit transaction with function for case-insensitivity

			Query transactionQuery = session.getNamedQuery("Account.largeDeposits");
			
			List<Account> accounts = transactionQuery.list();
			System.out.println("Query has been executed");
			for (Account account : accounts){
				System.out.println(account.getName());
				System.out.println(account.getBank().getName());
			}
			
			tx.commit();
		} catch (Exception exception) {
			exception.printStackTrace(System.err);
			tx.rollback();
		} finally {
			session.close();
			HibernateUtil.closeSessionFactory();
			scanner.close();
		}
	}
}

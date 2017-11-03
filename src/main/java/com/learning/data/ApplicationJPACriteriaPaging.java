package com.learning.data;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.learning.data.entities.Transaction;

public class ApplicationJPACriteriaPaging
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("infinite-finances");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Transaction> criteriaQuery = criteriaBuilder.createQuery(Transaction.class);
			
			Root<Transaction> root = criteriaQuery.from(Transaction.class);
			Path<BigDecimal> amountPath = root.get("amount");
			Path<String> transactionTypePath = root.get("transactionType");
			
			criteriaQuery.select(root).
			where(criteriaBuilder.
					and(criteriaBuilder.le(amountPath, new BigDecimal("20.00")), criteriaBuilder.equal(transactionTypePath, "Withdrawl")));
			
			TypedQuery<Transaction> query = em.createQuery(criteriaQuery);
			List<Transaction> transactions = query.getResultList();
			
			for (Transaction trans : transactions){
				System.out.println(trans.getTitle());
			}
			
			
			tx.commit();
		} catch (Exception exception) {
			exception.printStackTrace(System.err);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}

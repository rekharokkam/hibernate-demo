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

public class ApplicationJPACriteria
{
	public static void main(String[] args)
	{
		int pageNumber = 3;
		int pageSize = 4;
		
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
			criteriaQuery.select(root);

			TypedQuery<Transaction> query = em.createQuery(criteriaQuery);
			query.setFirstResult ((pageNumber -1) * pageSize);
			query.setMaxResults(pageSize);
			
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

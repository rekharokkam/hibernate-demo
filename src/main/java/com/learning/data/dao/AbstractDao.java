package com.learning.data.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import com.learning.data.HibernateUtil;
import com.learning.data.dao.interfaces.Dao;

public class AbstractDao <T, ID extends Serializable> implements Dao<T, ID>
{
	private Session session;
	private Class<T> persistenceClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(Session session)
	{	
		persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.session = session;
	}
	
	@Override
	public List<T> findAll()
	{
		return findByCriterion();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriterion (Criterion ... criterions){
		Criteria criteria = getSession().createCriteria(persistenceClass);
		
		for (Criterion criterion : criterions){
			criteria.add(criterion);
		}
		
		return (List<T>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id)
	{
		return (T)getSession().load(getPersistenceClass(), id);
	}

	@Override
	public T save(T entity)
	{
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity)
	{
		getSession().delete(entity);
	}

	@Override
	public void flush()
	{
		getSession().flush();
	}

	@Override
	public void clear()
	{
		getSession().clear();
	}

	@Override
	public void setSession(Session session)
	{
		this.session = session;
	}
	
	protected Session getSession (){
		if (null == session){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		return session;
	}
	
	protected Class<T> getPersistenceClass (){
		return this.persistenceClass;
	}
}

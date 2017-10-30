package com.learning.data.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.learning.data.dao.interfaces.Dao;

public class AbstractDao <T, ID extends Serializable> implements Dao<T, ID>
{
	private Class<T> persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public AbstractDao()
	{
		this.persistentClass = (Class<T>)( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id)
	{
		return null;
	}

	@Override
	public List<T> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T entity)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Session session)
	{
		// TODO Auto-generated method stub
		
	}
	
}

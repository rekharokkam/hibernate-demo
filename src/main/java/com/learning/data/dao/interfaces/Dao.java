package com.learning.data.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface Dao <T, ID>
{
	public List <T> findAll ();
	
	public T findById (ID id);
	
	public T save (T entity);
	
	public void delete (T entity);
	
	public void flush ();
	
	public void clear ();
	
	public void setSession (Session session);
	
}

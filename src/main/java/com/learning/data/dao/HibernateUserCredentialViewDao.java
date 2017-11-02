package com.learning.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.learning.data.dao.interfaces.UserCredentialViewDao;
import com.learning.data.entities.UserCredentialView;

public class HibernateUserCredentialViewDao extends AbstractDao<UserCredentialView, Long> implements UserCredentialViewDao
{
	public HibernateUserCredentialViewDao(Session session)
	{
		super (session);
	}
	public UserCredentialView save(UserCredentialView entity)
	{
		//do nothing
		return null;
	}

	public void delete(UserCredentialView entity)
	{
		//do nothing
	}

	@Override
	public List<UserCredentialView> findByUserName(String userName)
	{
		List<UserCredentialView> userCredentials = new ArrayList<>();
		
		//Implementation goes here
		
		return userCredentials;
	}

}

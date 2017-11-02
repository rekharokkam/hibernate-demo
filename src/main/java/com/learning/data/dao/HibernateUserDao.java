package com.learning.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.learning.data.dao.interfaces.UserDao;
import com.learning.data.entities.User;

public class HibernateUserDao extends AbstractDao<User, Long> implements UserDao
{
	public HibernateUserDao(Session session)
	{
		super (session);
	}
	
	@Override
	public List<User> findByFirstName (String firstName){
		List<User> users = new ArrayList<>();
		
		
		//Implementation goes here
		
		return users;
	}
}

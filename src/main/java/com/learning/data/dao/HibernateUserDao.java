package com.learning.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.learning.data.dao.interfaces.UserDao;
import com.learning.data.entities.User;

public class HibernateUserDao extends AbstractDao<User, Long> implements UserDao
{
	public HibernateUserDao(Session session)
	{
		super (session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByFirstName (String firstName){
		
		Query query = super.getSession().createQuery("select u from User u where firstName like :firstName");
		query.setParameter("firstName",firstName);
		List<User> users = query.list();
			
		return users;
	}
}

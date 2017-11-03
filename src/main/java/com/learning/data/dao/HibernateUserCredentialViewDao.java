package com.learning.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.learning.data.dao.interfaces.UserCredentialViewDao;
import com.learning.data.entities.UserCredentialView;

//As this is a Read Only Dao mask all the Write Operations
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCredentialView> findByUserName(String userName)
	{
		return super.getSession().createCriteria(UserCredentialView.class).
			add(Restrictions.eq("userName", userName)).list();
	}
}

package com.learning.data.dao;

import org.hibernate.Session;

import com.learning.data.dao.interfaces.BankDao;
import com.learning.data.entities.Bank;

public class HibernateBankDao extends AbstractDao<Bank, Long> implements BankDao
{
	public HibernateBankDao(Session session)
	{
		super (session);
	}
}

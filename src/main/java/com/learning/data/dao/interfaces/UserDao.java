package com.learning.data.dao.interfaces;

import java.util.List;

import com.learning.data.entities.User;

public interface UserDao extends Dao<User, Long>
{
	public List<User> findByFirstName (String firstName);
}

package com.learning.data.dao.interfaces;

import java.util.List;

import com.learning.data.entities.UserCredentialView;

public interface UserCredentialViewDao extends Dao<UserCredentialView, Long>
{
	public List<UserCredentialView> findByUserName (String userName); 
}

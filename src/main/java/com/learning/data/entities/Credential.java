package com.learning.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="credential")
public class Credential
{
	@Id
	@Column (name="credential_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long credentialId;
	
	//What this means is that when we persist Credential we also want to persist the User with in this field. This will cause both the entities to be persisted at the same time.
	@OneToOne(cascade=CascadeType.ALL) 
	// name indicates the field name on this entity which is the foreign key to another table. It always indicates the foreign key field on the Source entity.
	// referencedColumnName indicates the primary key on the target Object.
	@JoinColumn (name="USER_ID", referencedColumnName="USER_ID")
	private User user;
	
	
	@Column (name="username")
	private String userName;
	
	@Column (name="password")
	private String password;
	
	/**
	 * @return the credentialId
	 */
	public Long getCredentialId()
	{
		return credentialId;
	}
	/**
	 * @param credentialId the credentialId to set
	 */
	public void setCredentialId(Long credentialId)
	{
		this.credentialId = credentialId;
	}
	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}
	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
}

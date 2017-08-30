package com.learning.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="account_type")
public class AccountType
{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ACCOUNT_TYPE_ID")
	private Long accountTypeId;
	
	@Column (name="NAME")
	private String name;
	
	@Column (name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	
	@Column (name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column (name="CREATED_DATE")
	private Date createdDate;
	
	@Column (name="CREATED_BY")
	private String createdBy;
	/**
	 * @return the accountTypeId
	 */
	public Long getAccountTypeId()
	{
		return accountTypeId;
	}
	/**
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(Long accountTypeId)
	{
		this.accountTypeId = accountTypeId;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the lastUpdatedDate
	 */
	public Date getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}
	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}
	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate()
	{
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Account Type Id : ").append(getAccountTypeId());
		sb.append("Account Type Name : ").append(getName());
		sb.append("Last Updated Date : ").append(getLastUpdatedDate());
		sb.append("Last Updated By : ").append(getLastUpdatedBy());
		sb.append("Created Date : ").append(getCreatedDate());
		sb.append("Created By : ").append(getCreatedBy());
		return sb.toString();
	}
}

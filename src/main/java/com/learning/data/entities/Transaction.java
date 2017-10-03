package com.learning.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="transaction")
public class Transaction
{
	@Id
	@Column (name="transaction_id")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long transactionId;
	
	@Column (name="transaction_type")
	private String transactionType;
	
	@Column (name="title")
	private String title;
	
	@Column (name="amount")
	private BigDecimal amount;
	
	@Column (name="initial_balance")
	private BigDecimal initialBalance;
	
	@Column (name="closing_balance")
	private BigDecimal closingBalance;
	
	@Column (name="notes")
	private String notes;
	
	@Column (name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column (name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column (name="created_by")
	private String createdBy;
	
	@Column (name="created_date")
	private Date createdDate;
	
	//This attribute is required only for bi-directional relationship
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="ACCOUNT_ID")
	private Account account;
	
	/*
	 * @JoinTable - In the case of OneToMany relationship, Owning entity is the entity with the @JoinTable Annotation. 
	 * In this case Budget Entity is the owning entity as it has @JoinTable Annotation. You can choose which side will have @JoinTable Annotation.
	 * 
	 * I tried adding below @ManyToOne and @JoinTable Annotations, they work just fine.
	 * 
	 * 		com.learning.data.entityassociation.ApplicationEntityAssociation.java
	 * 
	 * 		Budget budget1 = (Budget)session.get(Budget.class, new Long (11));
	 *		System.out.println(budget1.getName());
	 */
//	@ManyToOne 
//	@JoinTable (name="budget_transaction", joinColumns=@JoinColumn(name="transaction_id"), inverseJoinColumns=@JoinColumn(name="budget_id"))
//	private Budget budget;

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId()
	{
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType()
	{
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the initialBalance
	 */
	public BigDecimal getInitialBalance()
	{
		return initialBalance;
	}

	/**
	 * @param initialBalance the initialBalance to set
	 */
	public void setInitialBalance(BigDecimal initialBalance)
	{
		this.initialBalance = initialBalance;
	}

	/**
	 * @return the closingBalance
	 */
	public BigDecimal getClosingBalance()
	{
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(BigDecimal closingBalance)
	{
		this.closingBalance = closingBalance;
	}

	/**
	 * @return the notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
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
	 * @return the account
	 */
	public Account getAccount()
	{
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account)
	{
		this.account = account;
	}

	/**
	 * @return the budget
	 */
//	public Budget getBudget()
//	{
//		return budget;
//	}

	/**
	 * @param budget the budget to set
	 */
//	public void setBudget(Budget budget)
//	{
//		this.budget = budget;
//	}
}

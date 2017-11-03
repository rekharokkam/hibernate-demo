package com.learning.data.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="account")
@NamedQueries ({
	@NamedQuery (name="Account.largeDeposits" , query="select distinct t.account from Transaction t "
			+ "where t.amount > 500 and lower(t.transactionType) = 'Deposit'"),
	@NamedQuery (name="Account.byWithdrawlAmount", query="select distinct t.account.name, concat (concat (t.account.bank.name, ' '), t.account.bank.address.state) "
					+ "from Transaction t "
					+ "where t.amount > :amount and t.transactionType = 'withdrawl'")
})

public class Account
{
	@Id
	@Column (name="account_id")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long accountId;
	
//	@OneToMany (cascade=CascadeType.ALL)//This mapping is only unidirectional
	// By default in case of OneToMany unidirectional flow, nullable = true.
	// Adding nullable = false is important in OneToMany unidirectional relationship as Account_id will not get populated automatically and exception is thrown
//	@JoinColumn (name="ACCOUNT_ID", nullable=false)
	
	//new Mapping for Bi-directional flow
	@OneToMany (cascade=CascadeType.ALL, mappedBy="account")
	private List<Transaction> transactions = new ArrayList<>();
	
	@ManyToOne (fetch=FetchType.LAZY)//fetches the element on need basis
	@JoinColumn (name="BANK_ID", referencedColumnName="BANK_ID")
	private Bank bank;
	
	@Enumerated(EnumType.STRING)
	@Column (name="ACCOUNT_TYPE")
	private AccountType accountType;
	
	@Column (name="name")
	private String name;
	
	@Column (name="initial_balance")
	private BigDecimal initialBalance;
	
	@Column (name="current_balance")
	private BigDecimal currentBalance;
	
	@Column (name="open_date")
	private Date openDate;
	
	@Column (name="close_date")
	private Date closeDate;
	
	@Column (name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column (name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column (name="created_by")
	private String createdBy;
	
	@Column (name="created_date")
	private Date createdDate;
	
	@ManyToMany (cascade=CascadeType.ALL)
	@JoinTable (name="user_account", joinColumns=@JoinColumn(name="account_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users = new HashSet<>();

	/**
	 * @return the accountId
	 */
	public Long getAccountId()
	{
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId)
	{
		this.accountId = accountId;
	}

	/**
	 * @return the bank
	 */
	public Bank getBank()
	{
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank)
	{
		this.bank = bank;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType()
	{
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType)
	{
		this.accountType = accountType;
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
	 * @return the currentBalance
	 */
	public BigDecimal getCurrentBalance()
	{
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(BigDecimal currentBalance)
	{
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the openDate
	 */
	public Date getOpenDate()
	{
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate)
	{
		this.openDate = openDate;
	}

	/**
	 * @return the closeDate
	 */
	public Date getCloseDate()
	{
		return closeDate;
	}

	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(Date closeDate)
	{
		this.closeDate = closeDate;
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
	 * @return the transactions
	 */
	public List<Transaction> getTransactions()
	{
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions)
	{
		this.transactions = transactions;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers()
	{
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
}

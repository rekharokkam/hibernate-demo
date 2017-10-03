package com.learning.data.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="budget")
public class Budget
{
	@Id
	@Column (name="budget_id")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long budget_id;
	
	@Column (name="name")
	private String name;
	
	@Column (name="goal_amount")
	private BigDecimal goalAmount;
	
	@Column (name="period")
	private String period;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinTable (name="budget_transaction", joinColumns=@JoinColumn (name="budget_id"), inverseJoinColumns=@JoinColumn (name="transaction_id"))
	private List<Transaction> transactions = new ArrayList<>();

	/**
	 * @return the budget_id
	 */
	public Long getBudget_id()
	{
		return budget_id;
	}

	/**
	 * @param budget_id the budget_id to set
	 */
	public void setBudget_id(Long budget_id)
	{
		this.budget_id = budget_id;
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
	 * @return the goalAmount
	 */
	public BigDecimal getGoalAmount()
	{
		return goalAmount;
	}

	/**
	 * @param goalAmount the goalAmount to set
	 */
	public void setGoalAmount(BigDecimal goalAmount)
	{
		this.goalAmount = goalAmount;
	}

	/**
	 * @return the period
	 */
	public String getPeriod()
	{
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period)
	{
		this.period = period;
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
	
	
	
}

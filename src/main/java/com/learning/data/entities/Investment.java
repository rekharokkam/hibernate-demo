package com.learning.data.entities;

//import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
//import javax.persistence.MappedSuperclass;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.TableGenerator;
//import javax.persistence.TableGenerator;

@Entity
@Table (name="investment")
//@MappedSuperclass //This is commented because same class is used for Table per class demo
//@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="INVESTMENT_TYPE")
public abstract class Investment
{
	@Id
	@Column (name="INVESTMENT_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	
//	@GeneratedValue (strategy=GenerationType.TABLE, generator="key_generator") // Do not need this for SINgle_table inheritence strategy
//	@TableGenerator (name="key_generator" ,table="ifinances_keys", pkColumnName="PK_NAME", valueColumnName="PK_VALUE")
	private Long investmentId;//This Id was added for Table Per class demo. Also Bond_Id and Stock_Id in the tables BOND and STOCK were renamed to INVESTMENT_ID
	
	@Column(name = "NAME")
	public String name;
	
	@Column(name = "ISSUER")
	public String issuer;
	
	@Column(name = "PURCHASE_DATE")
	public Date purchaseDate;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="PORTFOLIO_ID", referencedColumnName="PORTFOLIO_ID")
	private Portfolio portfolio;
	
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
	 * @return the issuer
	 */
	public String getIssuer()
	{
		return issuer;
	}

	/**
	 * @param issuser the issuer to set
	 */
	public void setIssuer(String issuer)
	{
		this.issuer = issuer;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate()
	{
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the investmentId
	 */
	public Long getInvestmentId()
	{
		return investmentId;
	}

	/**
	 * @param investmentId the investmentId to set
	 */
	public void setInvestmentId(Long investmentId)
	{
		this.investmentId = investmentId;
	}

	/**
	 * @return the portfolio
	 */
	public Portfolio getPortfolio()
	{
		return portfolio;
	}

	/**
	 * @param portfolio the portfolio to set
	 */
	public void setPortfolio(Portfolio portfolio)
	{
		this.portfolio = portfolio;
	}
}
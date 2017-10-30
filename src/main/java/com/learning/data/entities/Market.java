package com.learning.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="market")
public class Market
{
	@Id
	@Column (name="MARKET_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long marketId;
	
	@Column (name="MARKET_NAME")
	private String marketName;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumns ({
		@JoinColumn (name="CURRENCY_NAME", referencedColumnName="NAME"), 
		@JoinColumn (name="COUNTRY_NAME", referencedColumnName="COUNTRY_NAME")
	})
	private Currency currency;

	/**
	 * @return the marketId
	 */
	public Long getMarketId()
	{
		return marketId;
	}

	/**
	 * @param marketId the marketId to set
	 */
	public void setMarketId(Long marketId)
	{
		this.marketId = marketId;
	}

	/**
	 * @return the marketName
	 */
	public String getMarketName()
	{
		return marketName;
	}

	/**
	 * @param marketName the marketName to set
	 */
	public void setMarketName(String marketName)
	{
		this.marketName = marketName;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency()
	{
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}
}

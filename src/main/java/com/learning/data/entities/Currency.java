package com.learning.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.learning.data.entities.ids.CurrencyId;

@Entity
@Table (name="currency")
@IdClass (CurrencyId.class)
public class Currency
{
	@Id
	@Column (name="NAME")
	private String name;
	
	@Id
	@Column (name="COUNTRY_NAME")
	private String countryName;
	
	@Column (name="SYMBOL")
	private String symbol;

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
	 * @return the countryName
	 */
	public String getCountryName()
	{
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}
}

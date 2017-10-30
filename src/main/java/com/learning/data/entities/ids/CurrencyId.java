package com.learning.data.entities.ids;

import java.io.Serializable;

@SuppressWarnings ("serial")
public class CurrencyId implements Serializable //Just a marker interface to indicate to JPA that this is an ID class
{
	private String name;
	
	private String countryName;
	
	public CurrencyId() {
	}

	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}
	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @return the countryName
	 */
	public final String getCountryName()
	{
		return countryName;
	}
}

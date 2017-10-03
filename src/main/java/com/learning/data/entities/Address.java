package com.learning.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	@Column (name="ADDRESS_LINE_1")
	public String addressLine1;
	
	@Column (name="ADDRESS_LINE_2")
	public String addressLine2;
	
	@Column (name="CITY")
	public String city;
	
	@Column (name="STATE")
	public String state;
	
	@Column (name="ZIP_CODE")
	public String zipCode;
	
	@Column (name="ADDRESS_TYPE")
	public String addressType;

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1()
	{
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2()
	{
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}



	/**
	 * @return the zipCode
	 */
	public String getZipCode()
	{
		return zipCode;
	}



	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType()
	{
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType)
	{
		this.addressType = addressType;
	}
	
	
}
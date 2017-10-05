package com.learning.data.entities;

//import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="bank")
public class Bank
{
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="BANK_ID")
	private Long bankId;
	
	@Column (name="NAME")
	private String name;
	
//	private List<String> contacts = new LinkedList<String>(); //This is a Collection Value Type that maps to its own table bank_contact
	
	@Column (name="IS_INTERNATIONAL")
	private boolean international;
	
	@Embedded //Indicates it is composite value type
	private Address address = new Address();

	@Column (name="CREATED_BY")
	private String createdBy;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name="CREATED_DATE")
	private Date createdDate;
	
	@Column (name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	
	/*
	 * This is an example of Collection Value Type holding Basic Value Types
	 * 
	 * Create a table that holds the repeatable values so that First Normal Form is implemented.
	 * Ex - One bank can have many contacts so splitting the contacts into a separate table makes sure the database is in first Normal Form
	 * 
	 * Bank_contact table holds all the contacts for each bank
	 * 
	 * This list represents Collection Value Type of basic Types
	 */
//	@ElementCollection // Map a Collection of Basic/Composite Value Types
//	@CollectionTable (name="bank_contact", joinColumns=@JoinColumn(name="BANK_ID")) //To provide more meta-data information
//	@Column(name="NAME")//Name of the column on the COllection table
//	private List<String> contacts = new ArrayList<String>();
	
	/*
	 * Example of Map Collection of Collection Value Type holding Basic Value Types
	 */
	@ElementCollection
	@CollectionTable (name="bank_contact",joinColumns=@JoinColumn(name="BANK_ID"))
	@Column(name="NAME")
	@MapKeyColumn(name="POSITION_TYPE")
	private Map<String, String> contacts = new HashMap<String, String>();
	
	
	/**
	 * @return the bankId
	 */
	public Long getBankId()
	{
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId)
	{
		this.bankId = bankId;
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
	 * @return the international
	 */
	public boolean isInternational()
	{
		return international;
	}

	/**
	 * @param international the international to set
	 */
	public void setInternational(boolean international)
	{
		this.international = international;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1()
	{
		return address.addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1)
	{
		this.address.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2()
	{
		return address.addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2)
	{
		this.address.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return address.city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.address.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return address.state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.address.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode()
	{
		return address.zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode)
	{
		this.address.zipCode = zipCode;
	}

	public void setAddressType (String addressType){
		this.address.addressType = addressType;
	}
	
	public String getAddressType (){
		return address.addressType;
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
	 * @return the address
	 */
	public Address getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}

	/**
	 * @return the contacts
	 */
	public Map<String, String> getContacts()
	{
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Map<String, String> contacts)
	{
		this.contacts = contacts;
	}

//	/**
//	 * @return the contacts
//	 */
//	public List<String> getContacts()
//	{
//		return contacts;
//	}
//
//	/**
//	 * @param contacts the contacts to set
//	 */
//	public void setContacts(List<String> contacts)
//	{
//		this.contacts = contacts;
//	}
}

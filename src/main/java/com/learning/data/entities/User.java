package com.learning.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table (name="finances_user")
@Access (value=AccessType.FIELD)
public class User
{
	@Id
	/*
	 * @GeneratedValue (strategy=GenerationType.AUTO) OR @GeneratedValue
	 * Default generator is AUTO - Hibernate picks the appropriate type based on the database used. Ex - if using Oracle then uses Sequence, if using mysql uses identity 
	 * 
	 * Table - strategy is relatively fast and most of the dbs support this appraoch as it is just a table in the database
	 * Sequence - faster but not all dbs support it
	 * Identity - slow , all dbs dont support it
	 */
//	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="user_table_generator")
	@TableGenerator (name="user_table_generator", table="ifinances_keys", pkColumnName="PK_NAME", valueColumnName="PK_VALUE")
	@Column (name="USER_ID")
	private Long userId;
	
	@Column (name="FIRST_NAME")
	private String firstName;
	
	@Column (name="LAST_NAME")
	private String lastName;
	
//	@Basic //Provides same functionality as nullable=false but the difference is that this annotation doesn't specify that a "not null" constraint should be added if Hibernate were to generate the DDL
	@Column (name="BIRTH_DATE", nullable=false)//Instead of a database throwing exception if this field is set Hibernate throws exception
	private Date birthDate;
	
	@Column (name="EMAIL_ADDRESS")
	private String emailAddress;
	
	/*
	 * In order to achieve this made changes to table structure 
	 * alter table finances_user
	 *	modify column LAST_UPDATED_BY varchar(45) null;
	 */
	@Column (name="LAST_UPDATED_BY", insertable=false)// This attribute prevents data being inserted into this column while executing an INSERT statement
	private String lastUpdatedBy;
	
	/*
	 * To achieve this made changes to table structure
	 * alter table finances_user
	 *	modify column LAST_UPDATED_DATE datetime null;
	 */
	@Column (name="LAST_UPDATED_DATE", insertable=false)
	private Date lastUpdatedDate;
	
	@Column (name="CREATED_BY", updatable=false)// This attribute prevents data being updated into this column while executing an UPDATE statement
	private String createdBy;
	
	@Column (name="CREATED_DATE", updatable=false)
	private Date createdDate;
	
	@Transient //This column tells hibernate not to use this column in query building
	private boolean valid;
	
	/*
	 * This is HIBERNATE specific annotation
	 *	This formula does not appear in INSERT and UPDATE. It gets executed only after a select has been fired against a Database. 
	 *	Refresh the Object in the session context to get an updated calculation if There was an Insert/Update to the related fields
	 *
	 *	Formula uses native Query - this causes coupling ourselves to a database and migration might not be easy
	 */
	@Formula ("lower(datediff(curdate(), birth_date)/365)") 
	private int age;
	
	@ElementCollection //Collection Value Type of Composite(Embedded) Value Type
	@CollectionTable (name="user_address", joinColumns=@JoinColumn(name="USER_ID"))
	//Overrides the Composite Value Type values to match the current table structure
	@AttributeOverrides ({@AttributeOverride (name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_1")),
		@AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_2")),
		@AttributeOverride(name="city", column=@Column(name="CITY")),
		@AttributeOverride(name="state", column=@Column(name="STATE")),
		@AttributeOverride(name="zipCode", column=@Column(name="ZIP_CODE"))})
	private List<Address> address = new ArrayList<Address>();
	
	/**
	 * @return the userId
	 */
	public Long getUserId()
	{
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
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
	 * @return the valid
	 */
	public boolean isValid()
	{
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}
	
	/**
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * @return the address
	 */
	public List<Address> getAddress()
	{
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address)
	{
		this.address = address;
	}
	
	@Override
	public String toString(){
		StringBuilder sb  = new StringBuilder();
		sb.append("\tUser Id : ").append(getUserId());
		sb.append("\tFirst Name : ").append(getFirstName());
		sb.append("\tLast Name : ").append(getLastName());
		sb.append("\temail : ").append(getEmailAddress());
		sb.append("\tbirth date : ").append(getBirthDate());
		sb.append("\tCreated By : ").append(getCreatedBy());
		sb.append("\tCreated Date : ").append(getCreatedDate());
		sb.append("\tUpdated BY : ").append(getLastUpdatedBy());
		sb.append("\tUpdated Date : ").append(getLastUpdatedDate());
		sb.append("\tValid : ").append(isValid());
		sb.append("\tAge : ").append(getAge());
		return sb.toString();
	}
}

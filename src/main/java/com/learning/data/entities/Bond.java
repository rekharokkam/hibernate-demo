package com.learning.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue (value="BND") //If this value is not mentioned then default value is the class name
//@Table (name="bond") // Removed for SINgle_table strategy 
public class Bond extends Investment
{
//	@Id
//	@Column (name="BOND_ID")
//	@GeneratedValue (strategy=GenerationType.AUTO)
//	private Long bondId;
	
	@Column (name="VALUE")
	private BigDecimal value;
	
	@Column (name="INTEREST_RATE")
	private BigDecimal interestRate;
	
	@Temporal (value = TemporalType.DATE)
	@Column (name="MATURITY_DATE")
	private Date maturityDate;

//	/**
//	 * @return the bondId
//	 */
//	public Long getBondId()
//	{
//		return bondId;
//	}
//
//	/**
//	 * @param bondId the bondId to set
//	 */
//	public void setBondId(Long bondId)
//	{
//		this.bondId = bondId;
//	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value)
	{
		this.value = value;
	}

	/**
	 * @return the interestRate
	 */
	public BigDecimal getInterestRate()
	{
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(BigDecimal interestRate)
	{
		this.interestRate = interestRate;
	}

	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate()
	{
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate)
	{
		this.maturityDate = maturityDate;
	}
}

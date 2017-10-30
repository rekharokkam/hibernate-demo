package com.learning.data.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@DiscriminatorValue (value="ST") //If this value is not mentioned then default value is the class name
//@Table (name="stock") // Removed for SINgle_table strategy 
public class Stock extends Investment
{
//	@Id
//	@Column (name="STOCK_ID")
//	@GeneratedValue (strategy=GenerationType.AUTO)
//	private Long stockId;
	
	@Column (name="SHARE_PRICE")
	private BigDecimal sharePrice;
	
	@Column (name="QUANTITY")
	private BigDecimal quantity;
	
//	/**
//	 * @return the stockId
//	 */
//	public Long getStockId()
//	{
//		return stockId;
//	}
//	/**
//	 * @param stockId the stockId to set
//	 */
//	public void setStockId(Long stockId)
//	{
//		this.stockId = stockId;
//	}

	/**
	 * @return the sharePrice
	 */
	public BigDecimal getSharePrice()
	{
		return sharePrice;
	}
	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(BigDecimal sharePrice)
	{
		this.sharePrice = sharePrice;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity()
	{
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity)
	{
		this.quantity = quantity;
	}
}

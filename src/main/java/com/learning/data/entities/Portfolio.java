package com.learning.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="portfolio")
public class Portfolio
{
	@Id
	@Column (name="PORTFOLIO_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long portfolioId;
	
	@Column (name="NAME")
	private String name;
	
	@OneToMany (mappedBy="portfolio")//didnt use cascade.All here as Teacher didnt have it
	private List<Investment> investments = new ArrayList<>();

	/**
	 * @return the portfolioId
	 */
	public Long getPortfolioId()
	{
		return portfolioId;
	}

	/**
	 * @param portfolioId the portfolioId to set
	 */
	public void setPortfolioId(Long portfolioId)
	{
		this.portfolioId = portfolioId;
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
	 * @return the investments
	 */
	public List<Investment> getInvestments()
	{
		return investments;
	}

	/**
	 * @param investments the investments to set
	 */
	public void setInvestments(List<Investment> investments)
	{
		this.investments = investments;
	}
	
	
}

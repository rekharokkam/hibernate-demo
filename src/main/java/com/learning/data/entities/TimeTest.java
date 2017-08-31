package com.learning.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="time_test")
public class TimeTest
{
	@Id
	@GeneratedValue //By default the generationType is AUTO
	@Column (name="TIME_TEST_ID")
	private Long timeTestId;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name="DATETIME_COLUMN")
	private Date dateTimeColumn;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name="TIMESTAMP_COLUMN")
	private Date timeStampColumn;
	
	@Temporal (TemporalType.DATE)//This annotation reduces the quirky nature of Date and displays the values like java.sql.Date/Time 
	@Column (name="DATE_COLUMN")
	private Date dateColumn;
	
	@Temporal (TemporalType.TIME)
	@Column (name="TIME_COLUMN")
	private Date timeColumn;
	
	@Column (name="SQL_DATETIME_COLUMN")
	private java.sql.Timestamp sqlDateTimeColumn;
	
	@Column (name="SQL_TIMESTAMP_COLUMN")
	private java.sql.Timestamp sqlTimeStampColumn;
	
	@Column (name="SQL_DATE_COLUMN")
	private java.sql.Date sqlDateColumn;
	
	@Column (name="SQL_TIME_COLUMN")
	private java.sql.Time sqlTimeColumn;
	
	public TimeTest(Date date)
	{
		this.dateTimeColumn = date;
		this.timeStampColumn = date;
		this.dateColumn = date;
		this.timeColumn = date;
		
		this.sqlDateTimeColumn = new java.sql.Timestamp(date.getTime());
		this.sqlTimeStampColumn = new java.sql.Timestamp(date.getTime());
		this.sqlDateColumn = new java.sql.Date(date.getTime());
		this.sqlTimeColumn = new java.sql.Time(date.getTime());
	}
	
	
	/**
	 * @return the timeTestId
	 */
	public Long getTimeTestId()
	{
		return timeTestId;
	}
	/**
	 * @param timeTestId the timeTestId to set
	 */
	public void setTimeTestId(Long timeTestId)
	{
		this.timeTestId = timeTestId;
	}
	/**
	 * @return the dateTimeColumn
	 */
	public Date getDateTimeColumn()
	{
		return dateTimeColumn;
	}
	/**
	 * @param dateTimeColumn the dateTimeColumn to set
	 */
	public void setDateTimeColumn(Date dateTimeColumn)
	{
		this.dateTimeColumn = dateTimeColumn;
	}
	/**
	 * @return the timeStampColumn
	 */
	public Date getTimeStampColumn()
	{
		return timeStampColumn;
	}
	/**
	 * @param timeStampColumn the timeStampColumn to set
	 */
	public void setTimeStampColumn(Date timeStampColumn)
	{
		this.timeStampColumn = timeStampColumn;
	}
	/**
	 * @return the dateColumn
	 */
	public Date getDateColumn()
	{
		return dateColumn;
	}
	/**
	 * @param dateColumn the dateColumn to set
	 */
	public void setDateColumn(Date dateColumn)
	{
		this.dateColumn = dateColumn;
	}
	/**
	 * @return the timeColumn
	 */
	public Date getTimeColumn()
	{
		return timeColumn;
	}
	/**
	 * @param timeColumn the timeColumn to set
	 */
	public void setTimeColumn(Date timeColumn)
	{
		this.timeColumn = timeColumn;
	}
	/**
	 * @return the sqlDateTimeColumn
	 */
	public Date getSqlDateTimeColumn()
	{
		return sqlDateTimeColumn;
	}
	/**
	 * @param sqlDateTimeColumn the sqlDateTimeColumn to set
	 */
	public void setSqlDateTimeColumn(java.sql.Timestamp sqlDateTimeColumn)
	{
		this.sqlDateTimeColumn = sqlDateTimeColumn;
	}
	/**
	 * @return the sqlTimeStampColumn
	 */
	public Date getSqlTimeStampColumn()
	{
		return sqlTimeStampColumn;
	}
	/**
	 * @param sqlTimeStampColumn the sqlTimeStampColumn to set
	 */
	public void setSqlTimeStampColumn(java.sql.Timestamp sqlTimeStampColumn)
	{
		this.sqlTimeStampColumn = sqlTimeStampColumn;
	}
	/**
	 * @return the sqlDateColumn
	 */
	public Date getSqlDateColumn()
	{
		return sqlDateColumn;
	}
	/**
	 * @param sqlDateColumn the sqlDateColumn to set
	 */
	public void setSqlDateColumn(java.sql.Date sqlDateColumn)
	{
		this.sqlDateColumn = sqlDateColumn;
	}
	/**
	 * @return the sqlTimeColumn
	 */
	public Date getSqlTimeColumn()
	{
		return sqlTimeColumn;
	}
	/**
	 * @param sqlTimeColumn the sqlTimeColumn to set
	 */
	public void setSqlTimeColumn(java.sql.Time sqlTimeColumn)
	{
		this.sqlTimeColumn = sqlTimeColumn;
	}
	
	@Override
	public String toString (){
		StringBuilder sb = new StringBuilder();
		sb.append("\n timeTestId : ").append(getTimeTestId());
		sb.append("\n Date time column : ").append(getDateTimeColumn());
		sb.append("\n timeStamp Column : ").append(getTimeStampColumn());
		sb.append("\n Date column : ").append(getDateColumn());
		sb.append("\n Time Column : ").append(getTimeColumn());
		sb.append("\n Sql date time column : ").append(getSqlDateTimeColumn());
		sb.append("\n SQL timeStampColumn : ").append(getSqlTimeStampColumn());
		sb.append("\n SQL Date Column : ").append(getSqlDateColumn());
		sb.append("\n SQL Time column : ").append(getSqlTimeColumn());
		return sb.toString();
	}
}

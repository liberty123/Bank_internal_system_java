package com.entity.vo;

import com.entity.WealthmanagementproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Financial product
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class WealthmanagementproductsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * product class
	 */
	
	private String productclassification;
		
	/**
	 * product  number
	 */
	
	private String productnumber;
		
	/**
	 * cover
	 */
	
	private String cover;
		
	/**
	 * Issuing institution
	 */
	
	private String issuinginstitution;
		
	/**
	 * Term Type
	 */
	
	private String termtype;
		
	/**
	 * operation pattern
	 */
	
	private String operationmode;
		
	/**
	 * Fundraising method
	 */
	
	private String fundraisingmethod;
		
	/**
	 * Fundraising currency
	 */
	
	private String fundraisingcurrency;
		
	/**
	 * Risk level
	 */
	
	private String risklevel;
		
	/**
	 * Investment nature
	 */
	
	private String investmentnature;
		
	/**
	 * Actual Days
	 */
	
	private String actualdays;
		
	/**
	 * Release time
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date releasetime;
		
	/**
	 * product details
	 */
	
	private String productdetails;
		

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * click num
	 */
	
	private Integer clicknum;
				
	
	/**
	 * setting:product class
	 */
	 
	public void setProductclassification(String productclassification) {
		this.productclassification = productclassification;
	}
	
	/**
	 *get:product class
	 */
	public String getProductclassification() {
		return productclassification;
	}
				
	
	/**
	 * setting:product  number
	 */
	 
	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}
	
	/**
	 *get:product  number
	 */
	public String getProductnumber() {
		return productnumber;
	}
				
	
	/**
	 * setting:cover
	 */
	 
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	/**
	 *get:cover
	 */
	public String getCover() {
		return cover;
	}
				
	
	/**
	 * setting:Issuing institution
	 */
	 
	public void setIssuinginstitution(String issuinginstitution) {
		this.issuinginstitution = issuinginstitution;
	}
	
	/**
	 *get:Issuing institution
	 */
	public String getIssuinginstitution() {
		return issuinginstitution;
	}
				
	
	/**
	 * setting:Term Type
	 */
	 
	public void setTermtype(String termtype) {
		this.termtype = termtype;
	}
	
	/**
	 *get:Term Type
	 */
	public String getTermtype() {
		return termtype;
	}
				
	
	/**
	 * setting:operation pattern
	 */
	 
	public void setOperationmode(String operationmode) {
		this.operationmode = operationmode;
	}
	
	/**
	 *get:operation pattern
	 */
	public String getOperationmode() {
		return operationmode;
	}
				
	
	/**
	 * setting:Fundraising method
	 */
	 
	public void setFundraisingmethod(String fundraisingmethod) {
		this.fundraisingmethod = fundraisingmethod;
	}
	
	/**
	 *get:Fundraising method
	 */
	public String getFundraisingmethod() {
		return fundraisingmethod;
	}
				
	
	/**
	 * setting:Fundraising currency
	 */
	 
	public void setFundraisingcurrency(String fundraisingcurrency) {
		this.fundraisingcurrency = fundraisingcurrency;
	}
	
	/**
	 *get:Fundraising currency
	 */
	public String getFundraisingcurrency() {
		return fundraisingcurrency;
	}
				
	
	/**
	 * setting:Risk level
	 */
	 
	public void setRisklevel(String risklevel) {
		this.risklevel = risklevel;
	}
	
	/**
	 *get:Risk level
	 */
	public String getRisklevel() {
		return risklevel;
	}
				
	
	/**
	 * setting:Investment nature
	 */
	 
	public void setInvestmentnature(String investmentnature) {
		this.investmentnature = investmentnature;
	}
	
	/**
	 *get:Investment nature
	 */
	public String getInvestmentnature() {
		return investmentnature;
	}
				
	
	/**
	 * setting:Actual Days
	 */
	 
	public void setActualdays(String actualdays) {
		this.actualdays = actualdays;
	}
	
	/**
	 *get:Actual Days
	 */
	public String getActualdays() {
		return actualdays;
	}
				
	
	/**
	 * setting:Release time
	 */
	 
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}
	
	/**
	 *get:Release time
	 */
	public Date getReleasetime() {
		return releasetime;
	}
				
	
	/**
	 * setting:product details
	 */
	 
	public void setProductdetails(String productdetails) {
		this.productdetails = productdetails;
	}
	
	/**
	 *get:product details
	 */
	public String getProductdetails() {
		return productdetails;
	}
				
	
	/**
	 * setting:最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 *get:最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * setting:click num
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 *get:click num
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}

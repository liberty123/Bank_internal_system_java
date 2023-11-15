package com.entity.model;

import com.entity.LoanproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * loanproduct
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class LoanproductsModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * product class
	 */
	
	private String productclassification;
		
	/**
	 * product image
	 */
	
	private String productimage;
		
	/**
	 * Product Properties
	 */
	
	private String productnature;
		
	/**
	 * Loan method
	 */
	
	private String loanmethod;
		
	/**
	 * lending rate
	 */
	
	private String loaninterestrate;
		
	/**
	 * Available loan amount
	 */
	
	private String loanamount;
		
	/**
	 * Release Date
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date releasedate;
		
	/**
	 * Branch name
	 */
	
	private String branchname;
		
	/**
	 * node address
	 */
	
	private String branchaddress;
		
	/**
	 * product 介绍
	 */
	
	private String productintroduction;
		

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
	 * setting:product image
	 */
	 
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	
	/**
	 *get:product image
	 */
	public String getProductimage() {
		return productimage;
	}
				
	
	/**
	 * setting:Product Properties
	 */
	 
	public void setProductnature(String productnature) {
		this.productnature = productnature;
	}
	
	/**
	 *get:Product Properties
	 */
	public String getProductnature() {
		return productnature;
	}
				
	
	/**
	 * setting:Loan method
	 */
	 
	public void setLoanmethod(String loanmethod) {
		this.loanmethod = loanmethod;
	}
	
	/**
	 *get:Loan method
	 */
	public String getLoanmethod() {
		return loanmethod;
	}
				
	
	/**
	 * setting:lending rate
	 */
	 
	public void setLoaninterestrate(String loaninterestrate) {
		this.loaninterestrate = loaninterestrate;
	}
	
	/**
	 *get:lending rate
	 */
	public String getLoaninterestrate() {
		return loaninterestrate;
	}
				
	
	/**
	 * setting:Available loan amount
	 */
	 
	public void setLoanamount(String loanamount) {
		this.loanamount = loanamount;
	}
	
	/**
	 *get:Available loan amount
	 */
	public String getLoanamount() {
		return loanamount;
	}
				
	
	/**
	 * setting:Release Date
	 */
	 
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	/**
	 *get:Release Date
	 */
	public Date getReleasedate() {
		return releasedate;
	}
				
	
	/**
	 * setting:Branch name
	 */
	 
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	
	/**
	 *get:Branch name
	 */
	public String getBranchname() {
		return branchname;
	}
				
	
	/**
	 * setting:node address
	 */
	 
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	
	/**
	 *get:node address
	 */
	public String getBranchaddress() {
		return branchaddress;
	}
				
	
	/**
	 * setting:product 介绍
	 */
	 
	public void setProductintroduction(String productintroduction) {
		this.productintroduction = productintroduction;
	}
	
	/**
	 *get:product
	 */
	public String getProductintroduction() {
		return productintroduction;
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

package com.entity.vo;

import com.entity.BankoutletEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Bank network
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class BankoutletVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Bank type
	 */
	
	private String banktype;
		
	/**
	 * node address
	 */
	
	private String branchaddress;
		
	/**
	 * Telephone
	 */
	
	private String contactphone;
		
	/**
	 * business hours
	 */
	
	private String businesshours;
		
	/**
	 * cover
	 */
	
	private String cover;
		
	/**
	 * brief introduction
	 */
	
	private String introduction;
				
	
	/**
	 * setting:Bank type
	 */
	 
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}
	
	/**
	 * get：Bank type
	 */
	public String getBanktype() {
		return banktype;
	}
				
	
	/**
	 * setting：node address
	 */
	 
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	
	/**
	 * get：node address
	 */
	public String getBranchaddress() {
		return branchaddress;
	}
				
	
	/**
	 * setting：Telephone
	 */
	 
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	
	/**
	 *get:Telephone
	 */
	public String getContactphone() {
		return contactphone;
	}
				
	
	/**
	 * setting:business hours
	 */
	 
	public void setBusinesshours(String businesshours) {
		this.businesshours = businesshours;
	}
	
	/**
	 *get:business hours
	 */
	public String getBusinesshours() {
		return businesshours;
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
	 * setting:brief introduction
	 */
	 
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 *get:brief introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
			
}

package com.entity.model;

import com.entity.CustomerEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * client
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class CustomerModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * full name
	 */
	
	private String name;
		
	/**
	 * Password
	 */
	
	private String password;
		
	/**
	 * gender
	 */
	
	private String gender;
		
	/**
	 * phone
	 */
	
	private String phonenumber;
		
	/**
	 * head sculpture
	 */
	
	private String touxiang;
		
	/**
	 * ID card
	 */
	
	private String idcard;
		
	/**
	 * intention
	 */
	
	private String intention;
		
	/**
	 * deposit
	 */
	
	private String deposit;
				
	
	/**
	 * setting:full name
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *get:full name
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * setting:Password
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 *get:Password
	 */
	public String getPassword() {
		return password;
	}
				
	
	/**
	 * setting:gender
	 */
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 *get:gender
	 */
	public String getGender() {
		return gender;
	}
				
	
	/**
	 * setting:phone
	 */
	 
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	/**
	 *get:phone
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
				
	
	/**
	 * setting:head sculpture
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 *get:head sculpture
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * setting:ID card
	 */
	 
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	/**
	 *get:ID card
	 */
	public String getIdcard() {
		return idcard;
	}
				
	
	/**
	 * setting:intention
	 */
	 
	public void setIntention(String intention) {
		this.intention = intention;
	}
	
	/**
	 *get:intention
	 */
	public String getIntention() {
		return intention;
	}
				
	
	/**
	 * setting:deposit
	 */
	 
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	
	/**
	 *get:deposit
	 */
	public String getDeposit() {
		return deposit;
	}
			
}

package com.entity.vo;

import com.entity.BankemployeeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Bank employees
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class BankemployeeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Employee Name
	 */
	
	private String employeename;
		
	/**
	 * Password
	 */
	
	private String password;
		
	/**
	 * department
	 */
	
	private String department;
		
	/**
	 * Professional title
	 */
	
	private String professionaltitle;
		
	/**
	 * gender
	 */
	
	private String gender;
		
	/**
	 * Telephone
	 */
	
	private String contactphone;
		
	/**
	 * network
	 */
	
	private String branch;
				
	
	/**
	 * setting:Employee Name
	 */
	 
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	/**
	 *get:Employee Name
	 */
	public String getEmployeename() {
		return employeename;
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
	 * setting:department
	 */
	 
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 *get:department
	 */
	public String getDepartment() {
		return department;
	}
				
	
	/**
	 * setting:Professional title
	 */
	 
	public void setProfessionaltitle(String professionaltitle) {
		this.professionaltitle = professionaltitle;
	}
	
	/**
	 *get:Professional title
	 */
	public String getProfessionaltitle() {
		return professionaltitle;
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
	 * setting:Telephone
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
	 * setting:network
	 */
	 
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/**
	 *get:network
	 */
	public String getBranch() {
		return branch;
	}
			
}

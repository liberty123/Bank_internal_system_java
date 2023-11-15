package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * Bank employees
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("bankemployee")
public class BankemployeeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BankemployeeEntity() {
		
	}
	
	public BankemployeeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@TableId
	private Long id;
	/**
	 * Employee ID
	 */
					
	private String employeeid;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * setting:Employee ID
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 *get:Employee ID
	 */
	public String getEmployeeid() {
		return employeeid;
	}
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

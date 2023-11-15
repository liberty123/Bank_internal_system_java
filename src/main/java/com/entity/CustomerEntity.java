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



@TableName("customer")
public class CustomerEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CustomerEntity() {
		
	}
	
	public CustomerEntity(T t) {
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
	 * client number
	 */
					
	private String customernumber;
	
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
	 * setting:client number
	 */
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	/**
	 *get:client number
	 */
	public String getCustomernumber() {
		return customernumber;
	}
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

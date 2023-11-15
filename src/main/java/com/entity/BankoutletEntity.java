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
 * Bank network
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("bankoutlet")
public class BankoutletEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BankoutletEntity() {
		
	}
	
	public BankoutletEntity(T t) {
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
	 * bank name
	 */
					
	private String bankname;
	
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
	 * setting:bank name
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 *get:bank name
	 */
	public String getBankname() {
		return bankname;
	}
	/**
	 * setting:Bank type
	 */
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}
	/**
	 *get:Bank type
	 */
	public String getBanktype() {
		return banktype;
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

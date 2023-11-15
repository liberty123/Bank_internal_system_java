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
 * Leave Application
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("leaveapplication")
public class LeaveapplicationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LeaveapplicationEntity() {
		
	}
	
	public LeaveapplicationEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
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
	 * Enter the correct phone number
	 */
					
	private String leavetype;
	
	/**
	 * starting time
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date starttime;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date endtime;
	
	/**
	 * 请假事由
	 */
					
	private String leavereason;
	

	private String sfsh;
	
	/**
	 * Reviewreply
	 */
					
	private String shhf;
	
	
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
	 * setting:Enter the correct phone number
	 */
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	/**
	 *get:Enter the correct phone number
	 */
	public String getLeavetype() {
		return leavetype;
	}
	/**
	 * setting:starting time
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	/**
	 *get:starting time
	 */
	public Date getStarttime() {
		return starttime;
	}
	/**
	 * setting:结束时间
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 *get:结束时间
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * setting:请假事由
	 */
	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}
	/**
	 *get:请假事由
	 */
	public String getLeavereason() {
		return leavereason;
	}
	/**
	 * setting:是否Review
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 *get:是否Review
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * setting:Reviewreply
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 *get:Reviewreply
	 */
	public String getShhf() {
		return shhf;
	}

}

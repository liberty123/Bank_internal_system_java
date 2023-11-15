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
 * order of the day
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("workschedule")
public class WorkscheduleEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WorkscheduleEntity() {
		
	}
	
	public WorkscheduleEntity(T t) {
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
	 * Event Progress
	 */
					
	private String eventprogress;
	
	/**
	 * update time
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date updatetime;
	
	/**
	 * job content
	 */
					
	private String workitems;
	

	private Long userid;
	
	
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
	 * setting:Event Progress
	 */
	public void setEventprogress(String eventprogress) {
		this.eventprogress = eventprogress;
	}
	/**
	 *get:Event Progress
	 */
	public String getEventprogress() {
		return eventprogress;
	}
	/**
	 * setting:update time
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 *get:update time
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * setting:job content
	 */
	public void setWorkitems(String workitems) {
		this.workitems = workitems;
	}
	/**
	 *get:job content
	 */
	public String getWorkitems() {
		return workitems;
	}
	/**
	 * setting:用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 *get:用户id
	 */
	public Long getUserid() {
		return userid;
	}

}

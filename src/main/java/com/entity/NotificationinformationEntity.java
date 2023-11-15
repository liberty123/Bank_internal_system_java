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
 * notification information
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("notificationinformation")
public class NotificationinformationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NotificationinformationEntity() {
		
	}
	
	public NotificationinformationEntity(T t) {
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
	 * notifier
	 */
					
	private String employeeid;
	
	/**
	 * client number
	 */
					
	private String customernumber;
	
	/**
	 * full name
	 */
					
	private String name;
	
	/**
	 * Notification Time
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date notificationtime;
	
	/**
	 * notification content
	 */
					
	private String notificationcontent;
	
	
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
	 * setting:notifier
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 *get:notifier
	 */
	public String getEmployeeid() {
		return employeeid;
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
	 * setting:Notification Time
	 */
	public void setNotificationtime(Date notificationtime) {
		this.notificationtime = notificationtime;
	}
	/**
	 *get:Notification Time
	 */
	public Date getNotificationtime() {
		return notificationtime;
	}
	/**
	 * setting:notification content
	 */
	public void setNotificationcontent(String notificationcontent) {
		this.notificationcontent = notificationcontent;
	}
	/**
	 *get:notification content
	 */
	public String getNotificationcontent() {
		return notificationcontent;
	}

}

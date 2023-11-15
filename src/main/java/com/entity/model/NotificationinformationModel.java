package com.entity.model;

import com.entity.NotificationinformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * notification information
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class NotificationinformationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

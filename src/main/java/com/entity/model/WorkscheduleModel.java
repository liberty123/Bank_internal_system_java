package com.entity.model;

import com.entity.WorkscheduleEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * order of the day
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class WorkscheduleModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

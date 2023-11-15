package com.entity.vo;

import com.entity.LeaveapplicationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Leave Application
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class LeaveapplicationVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date starttime;

		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date endtime;
		

	private String leavereason;
		
	/**
	 * Review
	 */
	
	private String sfsh;
		
	/**
	 * Reviewreply
	 */
	
	private String shhf;
				
	
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

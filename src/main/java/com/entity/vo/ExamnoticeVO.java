package com.entity.vo;

import com.entity.ExamnoticeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Examination Notice
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class ExamnoticeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Exam Type
	 */
	
	private String examtype;
		
	/**
	 * Exam time
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date examtime;
		
	/**
	 * Examination location
	 */
	
	private String examlocation;
		
	/**
	 * link
	 */
	
	private String link;
				
	
	/**
	 * setting:Exam Type
	 */
	 
	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}
	
	/**
	 *get:Exam Type
	 */
	public String getExamtype() {
		return examtype;
	}
				
	
	/**
	 * setting:Exam time
	 */
	 
	public void setExamtime(Date examtime) {
		this.examtime = examtime;
	}
	
	/**
	 *get:Exam time
	 */
	public Date getExamtime() {
		return examtime;
	}
				
	
	/**
	 * setting:Examination location
	 */
	 
	public void setExamlocation(String examlocation) {
		this.examlocation = examlocation;
	}
	
	/**
	 *get:Examination location
	 */
	public String getExamlocation() {
		return examlocation;
	}
				
	
	/**
	 * setting:link
	 */
	 
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 *get:link
	 */
	public String getLink() {
		return link;
	}
			
}

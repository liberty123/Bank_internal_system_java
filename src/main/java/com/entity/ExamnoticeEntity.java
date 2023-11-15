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
 * Examination Notice
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("examnotice")
public class ExamnoticeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ExamnoticeEntity() {
		
	}
	
	public ExamnoticeEntity(T t) {
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
	 * Exam topic 
	 */
					
	private String examtopic;
	
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
	 * setting:Exam topic 
	 */
	public void setExamtopic(String examtopic) {
		this.examtopic = examtopic;
	}
	/**
	 *get:Exam topic 
	 */
	public String getExamtopic() {
		return examtopic;
	}
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

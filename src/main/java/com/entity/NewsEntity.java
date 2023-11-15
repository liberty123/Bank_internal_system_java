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



@TableName("news")
public class NewsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NewsEntity() {
		
	}
	
	public NewsEntity(T t) {
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
	 * title
	 */
					
	private String title;
	
	/**
	 * brief introduction
	 */
					
	private String introduction;
	
	/**
	 * image
	 */
					
	private String picture;
	
	/**
	 * content
	 */
					
	private String content;
	
	
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
	 * setting:title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 *get:title
	 */
	public String getTitle() {
		return title;
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
	/**
	 * setting:image
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 *get:image
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * setting:content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 *get:content
	 */
	public String getContent() {
		return content;
	}

}

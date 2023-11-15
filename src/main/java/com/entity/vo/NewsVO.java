package com.entity.vo;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Notice Announcement
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class NewsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

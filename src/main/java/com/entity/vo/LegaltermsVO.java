package com.entity.vo;

import com.entity.LegaltermsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * legal provisions
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class LegaltermsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * cover
	 */
	
	private String cover;
		
	/**
	 * content
	 */
	
	private String content;
		
	/**
	 * Release Date
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date releasedate;
				
	
	/**
	 * setting:cover
	 */
	 
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	/**
	 *get:cover
	 */
	public String getCover() {
		return cover;
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
				
	
	/**
	 * setting:Release Date
	 */
	 
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	/**
	 *get:Release Date
	 */
	public Date getReleasedate() {
		return releasedate;
	}
			
}

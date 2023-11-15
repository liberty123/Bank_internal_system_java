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
 * legal provisions
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("legalterms")
public class LegaltermsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LegaltermsEntity() {
		
	}
	
	public LegaltermsEntity(T t) {
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
	 *  topic 
	 */
					
	private String topic;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date releasedate;
	
	
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
	 * setting: topic 
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 *get: topic 
	 */
	public String getTopic() {
		return topic;
	}
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

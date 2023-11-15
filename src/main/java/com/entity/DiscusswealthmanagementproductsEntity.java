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
 * wealthmanagementproducts评论表
 * 数据库通用operate实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
@TableName("discusswealthmanagementproducts")
public class DiscusswealthmanagementproductsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscusswealthmanagementproductsEntity() {
		
	}
	
	public DiscusswealthmanagementproductsEntity(T t) {
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
	 * 关联表id
	 */
					
	private Long refid;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	/**
	 * head sculpture
	 */
					
	private String avatarurl;
	
	/**
	 * Username
	 */
					
	private String nickname;
	
	/**
	 * No.Comment content
	 */
					
	private String content;
	
	/**
	 * Reply to content
	 */
					
	private String reply;
	
	
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
	 * setting:关联表id
	 */
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	/**
	 *get:关联表id
	 */
	public Long getRefid() {
		return refid;
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
	/**
	 * setting:head sculpture
	 */
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	/**
	 *get:head sculpture
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
	/**
	 * setting:Username
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 *get:Username
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * setting:No.Comment content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 *get:No.Comment content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * setting:Reply to content
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 *get:Reply to content
	 */
	public String getReply() {
		return reply;
	}

}

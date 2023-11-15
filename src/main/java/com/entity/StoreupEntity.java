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



@TableName("storeup")
public class StoreupEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public StoreupEntity() {
		
	}
	
	public StoreupEntity(T t) {
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
	 * 用户id
	 */
					
	private Long userid;
	

	private Long refid;
	
	/**
	 * 表名
	 */
					
	private String tablename;
	
	/**
	 * name
	 */
					
	private String name;
	
	/**
	 * image
	 */
					
	private String picture;
	

	private String type;
	
	/**
	 * Recommend Type
	 */
					
	private String inteltype;
	
	/**
	 * notes
	 */
					
	private String remark;
	
	
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
	 * setting:商品id
	 */
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	/**
	 *get:商品id
	 */
	public Long getRefid() {
		return refid;
	}
	/**
	 * setting:表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	/**
	 *get:表名
	 */
	public String getTablename() {
		return tablename;
	}
	/**
	 * setting:name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *get:name
	 */
	public String getName() {
		return name;
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
	 * setting:类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 *get:类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)
	 */
	public String getType() {
		return type;
	}
	/**
	 * setting:Recommend Type
	 */
	public void setInteltype(String inteltype) {
		this.inteltype = inteltype;
	}
	/**
	 *get:Recommend Type
	 */
	public String getInteltype() {
		return inteltype;
	}
	/**
	 * setting:notes
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 *get:notes
	 */
	public String getRemark() {
		return remark;
	}

}

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
 * precious metal
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("preciousmetals")
public class PreciousmetalsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PreciousmetalsEntity() {
		
	}
	
	public PreciousmetalsEntity(T t) {
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
	 * name
	 */
					
	private String name;
	
	/**
	 * cover
	 */
					
	private String cover;
	
	/**
	 * price
	 */
					
	private String price;
	
	
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
	 * setting:price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 *get:price
	 */
	public String getPrice() {
		return price;
	}

}

package com.entity.model;

import com.entity.StoreupEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class StoreupModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			

	private Long refid;
		

	
	private String tablename;
		

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

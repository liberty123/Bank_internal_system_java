package com.entity.vo;

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
public class StoreupVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			

	
	private Long refid;
		

	
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
				
	

	 
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	

	public Long getRefid() {
		return refid;
	}
				
	

	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	

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
				
	

	 
	public void setType(String type) {
		this.type = type;
	}
	

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

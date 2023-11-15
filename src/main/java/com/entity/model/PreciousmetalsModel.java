package com.entity.model;

import com.entity.PreciousmetalsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * precious metal
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class PreciousmetalsModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * cover
	 */
	
	private String cover;
		
	/**
	 * price
	 */
	
	private String price;
				
	
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

package com.entity.view;

import com.entity.WealthmanagementproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Financial product
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("wealthmanagementproducts")
public class WealthmanagementproductsView  extends WealthmanagementproductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WealthmanagementproductsView(){
	}
 
 	public WealthmanagementproductsView(WealthmanagementproductsEntity wealthmanagementproductsEntity){
 	try {
			BeanUtils.copyProperties(this, wealthmanagementproductsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

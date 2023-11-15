package com.entity.view;

import com.entity.DiscusswealthmanagementproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * @author
 * @email 
 * @date 2023-11-10 11:38:27
 */
@TableName("discusswealthmanagementproducts")
public class DiscusswealthmanagementproductsView  extends DiscusswealthmanagementproductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusswealthmanagementproductsView(){
	}
 
 	public DiscusswealthmanagementproductsView(DiscusswealthmanagementproductsEntity discusswealthmanagementproductsEntity){
 	try {
			BeanUtils.copyProperties(this, discusswealthmanagementproductsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

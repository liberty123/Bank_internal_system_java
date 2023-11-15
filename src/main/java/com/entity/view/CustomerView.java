package com.entity.view;

import com.entity.CustomerEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * client
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("customer")
public class CustomerView  extends CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CustomerView(){
	}
 
 	public CustomerView(CustomerEntity customerEntity){
 	try {
			BeanUtils.copyProperties(this, customerEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

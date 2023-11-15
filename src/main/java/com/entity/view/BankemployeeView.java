package com.entity.view;

import com.entity.BankemployeeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Bank employees
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("bankemployee")
public class BankemployeeView  extends BankemployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BankemployeeView(){
	}
 
 	public BankemployeeView(BankemployeeEntity bankemployeeEntity){
 	try {
			BeanUtils.copyProperties(this, bankemployeeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

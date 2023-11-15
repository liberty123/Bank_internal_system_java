package com.entity.view;

import com.entity.BankoutletEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Bank network
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("bankoutlet")
public class BankoutletView  extends BankoutletEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BankoutletView(){
	}
 
 	public BankoutletView(BankoutletEntity bankoutletEntity){
 	try {
			BeanUtils.copyProperties(this, bankoutletEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

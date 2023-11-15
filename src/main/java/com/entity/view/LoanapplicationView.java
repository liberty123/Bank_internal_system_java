package com.entity.view;

import com.entity.LoanapplicationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * loan application
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("loanapplication")
public class LoanapplicationView  extends LoanapplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LoanapplicationView(){
	}
 
 	public LoanapplicationView(LoanapplicationEntity loanapplicationEntity){
 	try {
			BeanUtils.copyProperties(this, loanapplicationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

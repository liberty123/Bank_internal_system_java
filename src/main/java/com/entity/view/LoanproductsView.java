package com.entity.view;

import com.entity.LoanproductsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Loan product
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("loanproducts")
public class LoanproductsView  extends LoanproductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LoanproductsView(){
	}
 
 	public LoanproductsView(LoanproductsEntity loanproductsEntity){
 	try {
			BeanUtils.copyProperties(this, loanproductsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

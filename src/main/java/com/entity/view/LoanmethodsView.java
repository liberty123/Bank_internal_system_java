package com.entity.view;

import com.entity.LoanmethodsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Loan method
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("loanmethods")
public class LoanmethodsView  extends LoanmethodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LoanmethodsView(){
	}
 
 	public LoanmethodsView(LoanmethodsEntity loanmethodsEntity){
 	try {
			BeanUtils.copyProperties(this, loanmethodsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

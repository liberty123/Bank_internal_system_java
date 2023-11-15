package com.entity.view;

import com.entity.DiscussbankoutletEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * bankoutlet评论表
 * @author
 * @email 
 * @date 2023-11-10 11:38:27
 */
@TableName("discussbankoutlet")
public class DiscussbankoutletView  extends DiscussbankoutletEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbankoutletView(){
	}
 
 	public DiscussbankoutletView(DiscussbankoutletEntity discussbankoutletEntity){
 	try {
			BeanUtils.copyProperties(this, discussbankoutletEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

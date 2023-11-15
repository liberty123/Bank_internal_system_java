package com.entity.view;

import com.entity.ProductclassificationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * product class
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("productclassification")
public class ProductclassificationView  extends ProductclassificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProductclassificationView(){
	}
 
 	public ProductclassificationView(ProductclassificationEntity productclassificationEntity){
 	try {
			BeanUtils.copyProperties(this, productclassificationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

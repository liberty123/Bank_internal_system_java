package com.entity.view;

import com.entity.LegaltermsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * legal provisions
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("legalterms")
public class LegaltermsView  extends LegaltermsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LegaltermsView(){
	}
 
 	public LegaltermsView(LegaltermsEntity legaltermsEntity){
 	try {
			BeanUtils.copyProperties(this, legaltermsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

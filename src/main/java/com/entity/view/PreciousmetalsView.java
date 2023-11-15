package com.entity.view;

import com.entity.PreciousmetalsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * precious metal
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("preciousmetals")
public class PreciousmetalsView  extends PreciousmetalsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PreciousmetalsView(){
	}
 
 	public PreciousmetalsView(PreciousmetalsEntity preciousmetalsEntity){
 	try {
			BeanUtils.copyProperties(this, preciousmetalsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

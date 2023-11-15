package com.entity.view;

import com.entity.LeaveapplicationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Leave Application
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("leaveapplication")
public class LeaveapplicationView  extends LeaveapplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LeaveapplicationView(){
	}
 
 	public LeaveapplicationView(LeaveapplicationEntity leaveapplicationEntity){
 	try {
			BeanUtils.copyProperties(this, leaveapplicationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

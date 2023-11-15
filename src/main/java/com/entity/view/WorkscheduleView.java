package com.entity.view;

import com.entity.WorkscheduleEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * order of the day
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("workschedule")
public class WorkscheduleView  extends WorkscheduleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WorkscheduleView(){
	}
 
 	public WorkscheduleView(WorkscheduleEntity workscheduleEntity){
 	try {
			BeanUtils.copyProperties(this, workscheduleEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

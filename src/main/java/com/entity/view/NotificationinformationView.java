package com.entity.view;

import com.entity.NotificationinformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * notification information
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("notificationinformation")
public class NotificationinformationView  extends NotificationinformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NotificationinformationView(){
	}
 
 	public NotificationinformationView(NotificationinformationEntity notificationinformationEntity){
 	try {
			BeanUtils.copyProperties(this, notificationinformationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

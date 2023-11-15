package com.entity.view;

import com.entity.ExamnoticeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * Examination Notice
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@TableName("examnotice")
public class ExamnoticeView  extends ExamnoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExamnoticeView(){
	}
 
 	public ExamnoticeView(ExamnoticeEntity examnoticeEntity){
 	try {
			BeanUtils.copyProperties(this, examnoticeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

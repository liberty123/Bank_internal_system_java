package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BankemployeeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BankemployeeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BankemployeeView;


/**
 * Bank employees
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface BankemployeeService extends IService<BankemployeeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BankemployeeVO> selectListVO(Wrapper<BankemployeeEntity> wrapper);
   	
   	BankemployeeVO selectVO(@Param("ew") Wrapper<BankemployeeEntity> wrapper);
   	
   	List<BankemployeeView> selectListView(Wrapper<BankemployeeEntity> wrapper);
   	
   	BankemployeeView selectView(@Param("ew") Wrapper<BankemployeeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BankemployeeEntity> wrapper);
   	

}


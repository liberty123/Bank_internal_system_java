package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CustomerEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CustomerVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CustomerView;


/**
 * client
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface CustomerService extends IService<CustomerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CustomerVO> selectListVO(Wrapper<CustomerEntity> wrapper);
   	
   	CustomerVO selectVO(@Param("ew") Wrapper<CustomerEntity> wrapper);
   	
   	List<CustomerView> selectListView(Wrapper<CustomerEntity> wrapper);
   	
   	CustomerView selectView(@Param("ew") Wrapper<CustomerEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CustomerEntity> wrapper);
   	

}


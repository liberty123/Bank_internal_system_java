package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WealthmanagementproductsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WealthmanagementproductsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WealthmanagementproductsView;


/**
 * Financial product
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface WealthmanagementproductsService extends IService<WealthmanagementproductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WealthmanagementproductsVO> selectListVO(Wrapper<WealthmanagementproductsEntity> wrapper);
   	
   	WealthmanagementproductsVO selectVO(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
   	
   	List<WealthmanagementproductsView> selectListView(Wrapper<WealthmanagementproductsEntity> wrapper);
   	
   	WealthmanagementproductsView selectView(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WealthmanagementproductsEntity> wrapper);
   	

}


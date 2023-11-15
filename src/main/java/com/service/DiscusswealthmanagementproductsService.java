package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswealthmanagementproductsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswealthmanagementproductsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswealthmanagementproductsView;


/**
 * wealthmanagementproducts评论表
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
public interface DiscusswealthmanagementproductsService extends IService<DiscusswealthmanagementproductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswealthmanagementproductsVO> selectListVO(Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
   	
   	DiscusswealthmanagementproductsVO selectVO(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
   	
   	List<DiscusswealthmanagementproductsView> selectListView(Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
   	
   	DiscusswealthmanagementproductsView selectView(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
   	

}


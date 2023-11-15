package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbankoutletEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbankoutletVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbankoutletView;


/**
 * bankoutlet评论表
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
public interface DiscussbankoutletService extends IService<DiscussbankoutletEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbankoutletVO> selectListVO(Wrapper<DiscussbankoutletEntity> wrapper);
   	
   	DiscussbankoutletVO selectVO(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
   	
   	List<DiscussbankoutletView> selectListView(Wrapper<DiscussbankoutletEntity> wrapper);
   	
   	DiscussbankoutletView selectView(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbankoutletEntity> wrapper);
   	

}


package com.dao;

import com.entity.DiscussbankoutletEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbankoutletVO;
import com.entity.view.DiscussbankoutletView;


/**
 * bankoutlet评论表
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
public interface DiscussbankoutletDao extends BaseMapper<DiscussbankoutletEntity> {
	
	List<DiscussbankoutletVO> selectListVO(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
	
	DiscussbankoutletVO selectVO(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
	
	List<DiscussbankoutletView> selectListView(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);

	List<DiscussbankoutletView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
	
	DiscussbankoutletView selectView(@Param("ew") Wrapper<DiscussbankoutletEntity> wrapper);
	

}

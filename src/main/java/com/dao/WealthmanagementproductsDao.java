package com.dao;

import com.entity.WealthmanagementproductsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WealthmanagementproductsVO;
import com.entity.view.WealthmanagementproductsView;


/**
 * Financial product
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface WealthmanagementproductsDao extends BaseMapper<WealthmanagementproductsEntity> {
	
	List<WealthmanagementproductsVO> selectListVO(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
	
	WealthmanagementproductsVO selectVO(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
	
	List<WealthmanagementproductsView> selectListView(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);

	List<WealthmanagementproductsView> selectListView(Pagination page,@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
	
	WealthmanagementproductsView selectView(@Param("ew") Wrapper<WealthmanagementproductsEntity> wrapper);
	

}

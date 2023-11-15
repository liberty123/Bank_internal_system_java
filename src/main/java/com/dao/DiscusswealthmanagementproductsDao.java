package com.dao;

import com.entity.DiscusswealthmanagementproductsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswealthmanagementproductsVO;
import com.entity.view.DiscusswealthmanagementproductsView;


/**
 * wealthmanagementproducts评论表
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
public interface DiscusswealthmanagementproductsDao extends BaseMapper<DiscusswealthmanagementproductsEntity> {
	
	List<DiscusswealthmanagementproductsVO> selectListVO(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
	
	DiscusswealthmanagementproductsVO selectVO(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
	
	List<DiscusswealthmanagementproductsView> selectListView(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);

	List<DiscusswealthmanagementproductsView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
	
	DiscusswealthmanagementproductsView selectView(@Param("ew") Wrapper<DiscusswealthmanagementproductsEntity> wrapper);
	

}

package com.dao;

import com.entity.ProductclassificationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ProductclassificationVO;
import com.entity.view.ProductclassificationView;


/**
 * product class
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface ProductclassificationDao extends BaseMapper<ProductclassificationEntity> {
	
	List<ProductclassificationVO> selectListVO(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
	
	ProductclassificationVO selectVO(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
	
	List<ProductclassificationView> selectListView(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);

	List<ProductclassificationView> selectListView(Pagination page,@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
	
	ProductclassificationView selectView(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
	

}

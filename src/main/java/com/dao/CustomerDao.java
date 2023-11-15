package com.dao;

import com.entity.CustomerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CustomerVO;
import com.entity.view.CustomerView;


/**
 * client
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface CustomerDao extends BaseMapper<CustomerEntity> {
	
	List<CustomerVO> selectListVO(@Param("ew") Wrapper<CustomerEntity> wrapper);
	
	CustomerVO selectVO(@Param("ew") Wrapper<CustomerEntity> wrapper);
	
	List<CustomerView> selectListView(@Param("ew") Wrapper<CustomerEntity> wrapper);

	List<CustomerView> selectListView(Pagination page,@Param("ew") Wrapper<CustomerEntity> wrapper);
	
	CustomerView selectView(@Param("ew") Wrapper<CustomerEntity> wrapper);
	

}

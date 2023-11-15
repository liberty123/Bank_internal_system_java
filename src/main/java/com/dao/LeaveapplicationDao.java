package com.dao;

import com.entity.LeaveapplicationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LeaveapplicationVO;
import com.entity.view.LeaveapplicationView;


/**
 * Leave Application
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LeaveapplicationDao extends BaseMapper<LeaveapplicationEntity> {
	
	List<LeaveapplicationVO> selectListVO(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
	
	LeaveapplicationVO selectVO(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
	
	List<LeaveapplicationView> selectListView(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);

	List<LeaveapplicationView> selectListView(Pagination page,@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
	
	LeaveapplicationView selectView(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
	

}

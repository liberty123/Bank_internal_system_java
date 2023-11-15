package com.dao;

import com.entity.WorkscheduleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WorkscheduleVO;
import com.entity.view.WorkscheduleView;


/**
 * order of the day
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface WorkscheduleDao extends BaseMapper<WorkscheduleEntity> {
	
	List<WorkscheduleVO> selectListVO(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
	
	WorkscheduleVO selectVO(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
	
	List<WorkscheduleView> selectListView(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);

	List<WorkscheduleView> selectListView(Pagination page,@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
	
	WorkscheduleView selectView(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
	

}

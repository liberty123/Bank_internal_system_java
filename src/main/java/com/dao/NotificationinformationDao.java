package com.dao;

import com.entity.NotificationinformationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NotificationinformationVO;
import com.entity.view.NotificationinformationView;


/**
 * notification information
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface NotificationinformationDao extends BaseMapper<NotificationinformationEntity> {
	
	List<NotificationinformationVO> selectListVO(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
	
	NotificationinformationVO selectVO(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
	
	List<NotificationinformationView> selectListView(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);

	List<NotificationinformationView> selectListView(Pagination page,@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
	
	NotificationinformationView selectView(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
	

}

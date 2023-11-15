package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LeaveapplicationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LeaveapplicationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LeaveapplicationView;


/**
 * Leave Application
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LeaveapplicationService extends IService<LeaveapplicationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LeaveapplicationVO> selectListVO(Wrapper<LeaveapplicationEntity> wrapper);
   	
   	LeaveapplicationVO selectVO(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
   	
   	List<LeaveapplicationView> selectListView(Wrapper<LeaveapplicationEntity> wrapper);
   	
   	LeaveapplicationView selectView(@Param("ew") Wrapper<LeaveapplicationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LeaveapplicationEntity> wrapper);
   	

}


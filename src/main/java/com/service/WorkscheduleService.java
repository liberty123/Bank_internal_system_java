package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WorkscheduleEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WorkscheduleVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WorkscheduleView;


/**
 * order of the day
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface WorkscheduleService extends IService<WorkscheduleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WorkscheduleVO> selectListVO(Wrapper<WorkscheduleEntity> wrapper);
   	
   	WorkscheduleVO selectVO(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
   	
   	List<WorkscheduleView> selectListView(Wrapper<WorkscheduleEntity> wrapper);
   	
   	WorkscheduleView selectView(@Param("ew") Wrapper<WorkscheduleEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WorkscheduleEntity> wrapper);
   	

}


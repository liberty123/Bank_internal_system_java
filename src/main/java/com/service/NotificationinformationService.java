package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NotificationinformationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NotificationinformationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NotificationinformationView;


/**
 * notification information
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface NotificationinformationService extends IService<NotificationinformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NotificationinformationVO> selectListVO(Wrapper<NotificationinformationEntity> wrapper);
   	
   	NotificationinformationVO selectVO(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
   	
   	List<NotificationinformationView> selectListView(Wrapper<NotificationinformationEntity> wrapper);
   	
   	NotificationinformationView selectView(@Param("ew") Wrapper<NotificationinformationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NotificationinformationEntity> wrapper);
   	

}


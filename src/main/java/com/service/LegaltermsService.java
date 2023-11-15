package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LegaltermsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LegaltermsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LegaltermsView;


/**
 * legal provisions
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LegaltermsService extends IService<LegaltermsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LegaltermsVO> selectListVO(Wrapper<LegaltermsEntity> wrapper);
   	
   	LegaltermsVO selectVO(@Param("ew") Wrapper<LegaltermsEntity> wrapper);
   	
   	List<LegaltermsView> selectListView(Wrapper<LegaltermsEntity> wrapper);
   	
   	LegaltermsView selectView(@Param("ew") Wrapper<LegaltermsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LegaltermsEntity> wrapper);
   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PreciousmetalsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PreciousmetalsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PreciousmetalsView;


/**
 * precious metal
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface PreciousmetalsService extends IService<PreciousmetalsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PreciousmetalsVO> selectListVO(Wrapper<PreciousmetalsEntity> wrapper);
   	
   	PreciousmetalsVO selectVO(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
   	
   	List<PreciousmetalsView> selectListView(Wrapper<PreciousmetalsEntity> wrapper);
   	
   	PreciousmetalsView selectView(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PreciousmetalsEntity> wrapper);
   	

}


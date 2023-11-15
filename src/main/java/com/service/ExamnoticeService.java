package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ExamnoticeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ExamnoticeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ExamnoticeView;


/**
 * Examination Notice
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface ExamnoticeService extends IService<ExamnoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ExamnoticeVO> selectListVO(Wrapper<ExamnoticeEntity> wrapper);
   	
   	ExamnoticeVO selectVO(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
   	
   	List<ExamnoticeView> selectListView(Wrapper<ExamnoticeEntity> wrapper);
   	
   	ExamnoticeView selectView(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ExamnoticeEntity> wrapper);
   	

}


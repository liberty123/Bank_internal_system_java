package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LoanapplicationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LoanapplicationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LoanapplicationView;


/**
 * loan application
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LoanapplicationService extends IService<LoanapplicationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LoanapplicationVO> selectListVO(Wrapper<LoanapplicationEntity> wrapper);
   	
   	LoanapplicationVO selectVO(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
   	
   	List<LoanapplicationView> selectListView(Wrapper<LoanapplicationEntity> wrapper);
   	
   	LoanapplicationView selectView(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LoanapplicationEntity> wrapper);
   	

}


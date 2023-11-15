package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LoanmethodsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LoanmethodsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LoanmethodsView;


/**
 * Loan method
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LoanmethodsService extends IService<LoanmethodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LoanmethodsVO> selectListVO(Wrapper<LoanmethodsEntity> wrapper);
   	
   	LoanmethodsVO selectVO(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
   	
   	List<LoanmethodsView> selectListView(Wrapper<LoanmethodsEntity> wrapper);
   	
   	LoanmethodsView selectView(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LoanmethodsEntity> wrapper);
   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BankoutletEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BankoutletVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BankoutletView;


/**
 * Bank network
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface BankoutletService extends IService<BankoutletEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BankoutletVO> selectListVO(Wrapper<BankoutletEntity> wrapper);
   	
   	BankoutletVO selectVO(@Param("ew") Wrapper<BankoutletEntity> wrapper);
   	
   	List<BankoutletView> selectListView(Wrapper<BankoutletEntity> wrapper);
   	
   	BankoutletView selectView(@Param("ew") Wrapper<BankoutletEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BankoutletEntity> wrapper);
   	

}


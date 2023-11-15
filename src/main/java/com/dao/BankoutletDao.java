package com.dao;

import com.entity.BankoutletEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BankoutletVO;
import com.entity.view.BankoutletView;


/**
 * Bank network
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface BankoutletDao extends BaseMapper<BankoutletEntity> {
	
	List<BankoutletVO> selectListVO(@Param("ew") Wrapper<BankoutletEntity> wrapper);
	
	BankoutletVO selectVO(@Param("ew") Wrapper<BankoutletEntity> wrapper);
	
	List<BankoutletView> selectListView(@Param("ew") Wrapper<BankoutletEntity> wrapper);

	List<BankoutletView> selectListView(Pagination page,@Param("ew") Wrapper<BankoutletEntity> wrapper);
	
	BankoutletView selectView(@Param("ew") Wrapper<BankoutletEntity> wrapper);
	

}

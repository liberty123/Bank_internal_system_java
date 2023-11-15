package com.dao;

import com.entity.LoanapplicationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LoanapplicationVO;
import com.entity.view.LoanapplicationView;


/**
 * loan application
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LoanapplicationDao extends BaseMapper<LoanapplicationEntity> {
	
	List<LoanapplicationVO> selectListVO(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
	
	LoanapplicationVO selectVO(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
	
	List<LoanapplicationView> selectListView(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);

	List<LoanapplicationView> selectListView(Pagination page,@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
	
	LoanapplicationView selectView(@Param("ew") Wrapper<LoanapplicationEntity> wrapper);
	

}

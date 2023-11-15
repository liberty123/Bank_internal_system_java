package com.dao;

import com.entity.LoanmethodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LoanmethodsVO;
import com.entity.view.LoanmethodsView;


/**
 * Loan method
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LoanmethodsDao extends BaseMapper<LoanmethodsEntity> {
	
	List<LoanmethodsVO> selectListVO(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
	
	LoanmethodsVO selectVO(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
	
	List<LoanmethodsView> selectListView(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);

	List<LoanmethodsView> selectListView(Pagination page,@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
	
	LoanmethodsView selectView(@Param("ew") Wrapper<LoanmethodsEntity> wrapper);
	

}

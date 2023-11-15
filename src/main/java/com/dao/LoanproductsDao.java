package com.dao;

import com.entity.LoanproductsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LoanproductsVO;
import com.entity.view.LoanproductsView;


/**
 * Loan product
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LoanproductsDao extends BaseMapper<LoanproductsEntity> {
	
	List<LoanproductsVO> selectListVO(@Param("ew") Wrapper<LoanproductsEntity> wrapper);
	
	LoanproductsVO selectVO(@Param("ew") Wrapper<LoanproductsEntity> wrapper);
	
	List<LoanproductsView> selectListView(@Param("ew") Wrapper<LoanproductsEntity> wrapper);

	List<LoanproductsView> selectListView(Pagination page,@Param("ew") Wrapper<LoanproductsEntity> wrapper);
	
	LoanproductsView selectView(@Param("ew") Wrapper<LoanproductsEntity> wrapper);
	

}

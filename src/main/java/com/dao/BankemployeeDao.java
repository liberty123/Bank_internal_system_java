package com.dao;

import com.entity.BankemployeeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BankemployeeVO;
import com.entity.view.BankemployeeView;


/**
 * Bank employees
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface BankemployeeDao extends BaseMapper<BankemployeeEntity> {
	
	List<BankemployeeVO> selectListVO(@Param("ew") Wrapper<BankemployeeEntity> wrapper);
	
	BankemployeeVO selectVO(@Param("ew") Wrapper<BankemployeeEntity> wrapper);
	
	List<BankemployeeView> selectListView(@Param("ew") Wrapper<BankemployeeEntity> wrapper);

	List<BankemployeeView> selectListView(Pagination page,@Param("ew") Wrapper<BankemployeeEntity> wrapper);
	
	BankemployeeView selectView(@Param("ew") Wrapper<BankemployeeEntity> wrapper);
	

}

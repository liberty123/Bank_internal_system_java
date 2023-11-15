package com.dao;

import com.entity.ExamnoticeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ExamnoticeVO;
import com.entity.view.ExamnoticeView;


/**
 * Examination Notice
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface ExamnoticeDao extends BaseMapper<ExamnoticeEntity> {
	
	List<ExamnoticeVO> selectListVO(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
	
	ExamnoticeVO selectVO(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
	
	List<ExamnoticeView> selectListView(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);

	List<ExamnoticeView> selectListView(Pagination page,@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
	
	ExamnoticeView selectView(@Param("ew") Wrapper<ExamnoticeEntity> wrapper);
	

}

package com.dao;

import com.entity.LegaltermsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LegaltermsVO;
import com.entity.view.LegaltermsView;


/**
 * legal provisions
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface LegaltermsDao extends BaseMapper<LegaltermsEntity> {
	
	List<LegaltermsVO> selectListVO(@Param("ew") Wrapper<LegaltermsEntity> wrapper);
	
	LegaltermsVO selectVO(@Param("ew") Wrapper<LegaltermsEntity> wrapper);
	
	List<LegaltermsView> selectListView(@Param("ew") Wrapper<LegaltermsEntity> wrapper);

	List<LegaltermsView> selectListView(Pagination page,@Param("ew") Wrapper<LegaltermsEntity> wrapper);
	
	LegaltermsView selectView(@Param("ew") Wrapper<LegaltermsEntity> wrapper);
	

}

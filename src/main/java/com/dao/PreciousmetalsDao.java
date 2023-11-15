package com.dao;

import com.entity.PreciousmetalsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PreciousmetalsVO;
import com.entity.view.PreciousmetalsView;


/**
 * precious metal
 * 
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface PreciousmetalsDao extends BaseMapper<PreciousmetalsEntity> {
	
	List<PreciousmetalsVO> selectListVO(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
	
	PreciousmetalsVO selectVO(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
	
	List<PreciousmetalsView> selectListView(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);

	List<PreciousmetalsView> selectListView(Pagination page,@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
	
	PreciousmetalsView selectView(@Param("ew") Wrapper<PreciousmetalsEntity> wrapper);
	

}

package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PreciousmetalsDao;
import com.entity.PreciousmetalsEntity;
import com.service.PreciousmetalsService;
import com.entity.vo.PreciousmetalsVO;
import com.entity.view.PreciousmetalsView;

@Service("preciousmetalsService")
public class PreciousmetalsServiceImpl extends ServiceImpl<PreciousmetalsDao, PreciousmetalsEntity> implements PreciousmetalsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PreciousmetalsEntity> page = this.selectPage(
                new Query<PreciousmetalsEntity>(params).getPage(),
                new EntityWrapper<PreciousmetalsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PreciousmetalsEntity> wrapper) {
		  Page<PreciousmetalsView> page =new Query<PreciousmetalsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PreciousmetalsVO> selectListVO(Wrapper<PreciousmetalsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PreciousmetalsVO selectVO(Wrapper<PreciousmetalsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PreciousmetalsView> selectListView(Wrapper<PreciousmetalsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PreciousmetalsView selectView(Wrapper<PreciousmetalsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

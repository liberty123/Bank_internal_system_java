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


import com.dao.WealthmanagementproductsDao;
import com.entity.WealthmanagementproductsEntity;
import com.service.WealthmanagementproductsService;
import com.entity.vo.WealthmanagementproductsVO;
import com.entity.view.WealthmanagementproductsView;

@Service("wealthmanagementproductsService")
public class WealthmanagementproductsServiceImpl extends ServiceImpl<WealthmanagementproductsDao, WealthmanagementproductsEntity> implements WealthmanagementproductsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WealthmanagementproductsEntity> page = this.selectPage(
                new Query<WealthmanagementproductsEntity>(params).getPage(),
                new EntityWrapper<WealthmanagementproductsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WealthmanagementproductsEntity> wrapper) {
		  Page<WealthmanagementproductsView> page =new Query<WealthmanagementproductsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WealthmanagementproductsVO> selectListVO(Wrapper<WealthmanagementproductsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WealthmanagementproductsVO selectVO(Wrapper<WealthmanagementproductsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WealthmanagementproductsView> selectListView(Wrapper<WealthmanagementproductsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WealthmanagementproductsView selectView(Wrapper<WealthmanagementproductsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

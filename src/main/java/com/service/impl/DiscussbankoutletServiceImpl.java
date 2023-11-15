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


import com.dao.DiscussbankoutletDao;
import com.entity.DiscussbankoutletEntity;
import com.service.DiscussbankoutletService;
import com.entity.vo.DiscussbankoutletVO;
import com.entity.view.DiscussbankoutletView;

@Service("discussbankoutletService")
public class DiscussbankoutletServiceImpl extends ServiceImpl<DiscussbankoutletDao, DiscussbankoutletEntity> implements DiscussbankoutletService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbankoutletEntity> page = this.selectPage(
                new Query<DiscussbankoutletEntity>(params).getPage(),
                new EntityWrapper<DiscussbankoutletEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbankoutletEntity> wrapper) {
		  Page<DiscussbankoutletView> page =new Query<DiscussbankoutletView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbankoutletVO> selectListVO(Wrapper<DiscussbankoutletEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbankoutletVO selectVO(Wrapper<DiscussbankoutletEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbankoutletView> selectListView(Wrapper<DiscussbankoutletEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbankoutletView selectView(Wrapper<DiscussbankoutletEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

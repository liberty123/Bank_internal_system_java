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


import com.dao.BankoutletDao;
import com.entity.BankoutletEntity;
import com.service.BankoutletService;
import com.entity.vo.BankoutletVO;
import com.entity.view.BankoutletView;

@Service("bankoutletService")
public class BankoutletServiceImpl extends ServiceImpl<BankoutletDao, BankoutletEntity> implements BankoutletService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BankoutletEntity> page = this.selectPage(
                new Query<BankoutletEntity>(params).getPage(),
                new EntityWrapper<BankoutletEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BankoutletEntity> wrapper) {
		  Page<BankoutletView> page =new Query<BankoutletView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BankoutletVO> selectListVO(Wrapper<BankoutletEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BankoutletVO selectVO(Wrapper<BankoutletEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BankoutletView> selectListView(Wrapper<BankoutletEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BankoutletView selectView(Wrapper<BankoutletEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

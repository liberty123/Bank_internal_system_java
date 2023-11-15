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


import com.dao.BankemployeeDao;
import com.entity.BankemployeeEntity;
import com.service.BankemployeeService;
import com.entity.vo.BankemployeeVO;
import com.entity.view.BankemployeeView;

@Service("bankemployeeService")
public class BankemployeeServiceImpl extends ServiceImpl<BankemployeeDao, BankemployeeEntity> implements BankemployeeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BankemployeeEntity> page = this.selectPage(
                new Query<BankemployeeEntity>(params).getPage(),
                new EntityWrapper<BankemployeeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BankemployeeEntity> wrapper) {
		  Page<BankemployeeView> page =new Query<BankemployeeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BankemployeeVO> selectListVO(Wrapper<BankemployeeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BankemployeeVO selectVO(Wrapper<BankemployeeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BankemployeeView> selectListView(Wrapper<BankemployeeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BankemployeeView selectView(Wrapper<BankemployeeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

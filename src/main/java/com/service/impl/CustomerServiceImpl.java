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


import com.dao.CustomerDao;
import com.entity.CustomerEntity;
import com.service.CustomerService;
import com.entity.vo.CustomerVO;
import com.entity.view.CustomerView;

@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CustomerEntity> page = this.selectPage(
                new Query<CustomerEntity>(params).getPage(),
                new EntityWrapper<CustomerEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CustomerEntity> wrapper) {
		  Page<CustomerView> page =new Query<CustomerView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CustomerVO> selectListVO(Wrapper<CustomerEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CustomerVO selectVO(Wrapper<CustomerEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CustomerView> selectListView(Wrapper<CustomerEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CustomerView selectView(Wrapper<CustomerEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

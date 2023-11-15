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


import com.dao.LoanapplicationDao;
import com.entity.LoanapplicationEntity;
import com.service.LoanapplicationService;
import com.entity.vo.LoanapplicationVO;
import com.entity.view.LoanapplicationView;

@Service("loanapplicationService")
public class LoanapplicationServiceImpl extends ServiceImpl<LoanapplicationDao, LoanapplicationEntity> implements LoanapplicationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LoanapplicationEntity> page = this.selectPage(
                new Query<LoanapplicationEntity>(params).getPage(),
                new EntityWrapper<LoanapplicationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LoanapplicationEntity> wrapper) {
		  Page<LoanapplicationView> page =new Query<LoanapplicationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LoanapplicationVO> selectListVO(Wrapper<LoanapplicationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LoanapplicationVO selectVO(Wrapper<LoanapplicationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LoanapplicationView> selectListView(Wrapper<LoanapplicationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LoanapplicationView selectView(Wrapper<LoanapplicationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.dao.LoanmethodsDao;
import com.entity.LoanmethodsEntity;
import com.service.LoanmethodsService;
import com.entity.vo.LoanmethodsVO;
import com.entity.view.LoanmethodsView;

@Service("loanmethodsService")
public class LoanmethodsServiceImpl extends ServiceImpl<LoanmethodsDao, LoanmethodsEntity> implements LoanmethodsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LoanmethodsEntity> page = this.selectPage(
                new Query<LoanmethodsEntity>(params).getPage(),
                new EntityWrapper<LoanmethodsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LoanmethodsEntity> wrapper) {
		  Page<LoanmethodsView> page =new Query<LoanmethodsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LoanmethodsVO> selectListVO(Wrapper<LoanmethodsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LoanmethodsVO selectVO(Wrapper<LoanmethodsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LoanmethodsView> selectListView(Wrapper<LoanmethodsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LoanmethodsView selectView(Wrapper<LoanmethodsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

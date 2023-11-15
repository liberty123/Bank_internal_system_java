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


import com.dao.LoanproductsDao;
import com.entity.LoanproductsEntity;
import com.service.LoanproductsService;
import com.entity.vo.LoanproductsVO;
import com.entity.view.LoanproductsView;

@Service("loanproductsService")
public class LoanproductsServiceImpl extends ServiceImpl<LoanproductsDao, LoanproductsEntity> implements LoanproductsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LoanproductsEntity> page = this.selectPage(
                new Query<LoanproductsEntity>(params).getPage(),
                new EntityWrapper<LoanproductsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LoanproductsEntity> wrapper) {
		  Page<LoanproductsView> page =new Query<LoanproductsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LoanproductsVO> selectListVO(Wrapper<LoanproductsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LoanproductsVO selectVO(Wrapper<LoanproductsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LoanproductsView> selectListView(Wrapper<LoanproductsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LoanproductsView selectView(Wrapper<LoanproductsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

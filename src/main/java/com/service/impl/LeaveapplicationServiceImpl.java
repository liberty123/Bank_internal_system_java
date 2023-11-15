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


import com.dao.LeaveapplicationDao;
import com.entity.LeaveapplicationEntity;
import com.service.LeaveapplicationService;
import com.entity.vo.LeaveapplicationVO;
import com.entity.view.LeaveapplicationView;

@Service("leaveapplicationService")
public class LeaveapplicationServiceImpl extends ServiceImpl<LeaveapplicationDao, LeaveapplicationEntity> implements LeaveapplicationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LeaveapplicationEntity> page = this.selectPage(
                new Query<LeaveapplicationEntity>(params).getPage(),
                new EntityWrapper<LeaveapplicationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LeaveapplicationEntity> wrapper) {
		  Page<LeaveapplicationView> page =new Query<LeaveapplicationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LeaveapplicationVO> selectListVO(Wrapper<LeaveapplicationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LeaveapplicationVO selectVO(Wrapper<LeaveapplicationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LeaveapplicationView> selectListView(Wrapper<LeaveapplicationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LeaveapplicationView selectView(Wrapper<LeaveapplicationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

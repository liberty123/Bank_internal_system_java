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


import com.dao.WorkscheduleDao;
import com.entity.WorkscheduleEntity;
import com.service.WorkscheduleService;
import com.entity.vo.WorkscheduleVO;
import com.entity.view.WorkscheduleView;

@Service("workscheduleService")
public class WorkscheduleServiceImpl extends ServiceImpl<WorkscheduleDao, WorkscheduleEntity> implements WorkscheduleService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkscheduleEntity> page = this.selectPage(
                new Query<WorkscheduleEntity>(params).getPage(),
                new EntityWrapper<WorkscheduleEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WorkscheduleEntity> wrapper) {
		  Page<WorkscheduleView> page =new Query<WorkscheduleView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WorkscheduleVO> selectListVO(Wrapper<WorkscheduleEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WorkscheduleVO selectVO(Wrapper<WorkscheduleEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WorkscheduleView> selectListView(Wrapper<WorkscheduleEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WorkscheduleView selectView(Wrapper<WorkscheduleEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

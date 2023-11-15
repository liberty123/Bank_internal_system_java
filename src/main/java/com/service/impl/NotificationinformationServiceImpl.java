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


import com.dao.NotificationinformationDao;
import com.entity.NotificationinformationEntity;
import com.service.NotificationinformationService;
import com.entity.vo.NotificationinformationVO;
import com.entity.view.NotificationinformationView;

@Service("notificationinformationService")
public class NotificationinformationServiceImpl extends ServiceImpl<NotificationinformationDao, NotificationinformationEntity> implements NotificationinformationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NotificationinformationEntity> page = this.selectPage(
                new Query<NotificationinformationEntity>(params).getPage(),
                new EntityWrapper<NotificationinformationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NotificationinformationEntity> wrapper) {
		  Page<NotificationinformationView> page =new Query<NotificationinformationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NotificationinformationVO> selectListVO(Wrapper<NotificationinformationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NotificationinformationVO selectVO(Wrapper<NotificationinformationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NotificationinformationView> selectListView(Wrapper<NotificationinformationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NotificationinformationView selectView(Wrapper<NotificationinformationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

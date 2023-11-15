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


import com.dao.LegaltermsDao;
import com.entity.LegaltermsEntity;
import com.service.LegaltermsService;
import com.entity.vo.LegaltermsVO;
import com.entity.view.LegaltermsView;

@Service("legaltermsService")
public class LegaltermsServiceImpl extends ServiceImpl<LegaltermsDao, LegaltermsEntity> implements LegaltermsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LegaltermsEntity> page = this.selectPage(
                new Query<LegaltermsEntity>(params).getPage(),
                new EntityWrapper<LegaltermsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LegaltermsEntity> wrapper) {
		  Page<LegaltermsView> page =new Query<LegaltermsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LegaltermsVO> selectListVO(Wrapper<LegaltermsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LegaltermsVO selectVO(Wrapper<LegaltermsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LegaltermsView> selectListView(Wrapper<LegaltermsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LegaltermsView selectView(Wrapper<LegaltermsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

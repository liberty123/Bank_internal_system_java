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


import com.dao.ExamnoticeDao;
import com.entity.ExamnoticeEntity;
import com.service.ExamnoticeService;
import com.entity.vo.ExamnoticeVO;
import com.entity.view.ExamnoticeView;

@Service("examnoticeService")
public class ExamnoticeServiceImpl extends ServiceImpl<ExamnoticeDao, ExamnoticeEntity> implements ExamnoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExamnoticeEntity> page = this.selectPage(
                new Query<ExamnoticeEntity>(params).getPage(),
                new EntityWrapper<ExamnoticeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExamnoticeEntity> wrapper) {
		  Page<ExamnoticeView> page =new Query<ExamnoticeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ExamnoticeVO> selectListVO(Wrapper<ExamnoticeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ExamnoticeVO selectVO(Wrapper<ExamnoticeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ExamnoticeView> selectListView(Wrapper<ExamnoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExamnoticeView selectView(Wrapper<ExamnoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

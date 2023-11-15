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


import com.dao.DiscusswealthmanagementproductsDao;
import com.entity.DiscusswealthmanagementproductsEntity;
import com.service.DiscusswealthmanagementproductsService;
import com.entity.vo.DiscusswealthmanagementproductsVO;
import com.entity.view.DiscusswealthmanagementproductsView;

@Service("discusswealthmanagementproductsService")
public class DiscusswealthmanagementproductsServiceImpl extends ServiceImpl<DiscusswealthmanagementproductsDao, DiscusswealthmanagementproductsEntity> implements DiscusswealthmanagementproductsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswealthmanagementproductsEntity> page = this.selectPage(
                new Query<DiscusswealthmanagementproductsEntity>(params).getPage(),
                new EntityWrapper<DiscusswealthmanagementproductsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswealthmanagementproductsEntity> wrapper) {
		  Page<DiscusswealthmanagementproductsView> page =new Query<DiscusswealthmanagementproductsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswealthmanagementproductsVO> selectListVO(Wrapper<DiscusswealthmanagementproductsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswealthmanagementproductsVO selectVO(Wrapper<DiscusswealthmanagementproductsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswealthmanagementproductsView> selectListView(Wrapper<DiscusswealthmanagementproductsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswealthmanagementproductsView selectView(Wrapper<DiscusswealthmanagementproductsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

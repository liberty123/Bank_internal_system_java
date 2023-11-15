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


import com.dao.ProductclassificationDao;
import com.entity.ProductclassificationEntity;
import com.service.ProductclassificationService;
import com.entity.vo.ProductclassificationVO;
import com.entity.view.ProductclassificationView;

@Service("productclassificationService")
public class ProductclassificationServiceImpl extends ServiceImpl<ProductclassificationDao, ProductclassificationEntity> implements ProductclassificationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProductclassificationEntity> page = this.selectPage(
                new Query<ProductclassificationEntity>(params).getPage(),
                new EntityWrapper<ProductclassificationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ProductclassificationEntity> wrapper) {
		  Page<ProductclassificationView> page =new Query<ProductclassificationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ProductclassificationVO> selectListVO(Wrapper<ProductclassificationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ProductclassificationVO selectVO(Wrapper<ProductclassificationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ProductclassificationView> selectListView(Wrapper<ProductclassificationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ProductclassificationView selectView(Wrapper<ProductclassificationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

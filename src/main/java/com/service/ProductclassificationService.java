package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ProductclassificationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ProductclassificationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ProductclassificationView;


/**
 * product class
 *
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
public interface ProductclassificationService extends IService<ProductclassificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ProductclassificationVO> selectListVO(Wrapper<ProductclassificationEntity> wrapper);
   	
   	ProductclassificationVO selectVO(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
   	
   	List<ProductclassificationView> selectListView(Wrapper<ProductclassificationEntity> wrapper);
   	
   	ProductclassificationView selectView(@Param("ew") Wrapper<ProductclassificationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ProductclassificationEntity> wrapper);
   	

}


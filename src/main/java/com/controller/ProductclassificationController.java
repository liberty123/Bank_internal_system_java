package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ProductclassificationEntity;
import com.entity.view.ProductclassificationView;

import com.service.ProductclassificationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * product class
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/productclassification")
public class ProductclassificationController {
    @Autowired
    private ProductclassificationService productclassificationService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ProductclassificationEntity productclassification,
		HttpServletRequest request){
        EntityWrapper<ProductclassificationEntity> ew = new EntityWrapper<ProductclassificationEntity>();

		PageUtils page = productclassificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, productclassification), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ProductclassificationEntity productclassification, 
		HttpServletRequest request){
        EntityWrapper<ProductclassificationEntity> ew = new EntityWrapper<ProductclassificationEntity>();

		PageUtils page = productclassificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, productclassification), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( ProductclassificationEntity productclassification){
       	EntityWrapper<ProductclassificationEntity> ew = new EntityWrapper<ProductclassificationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( productclassification, "productclassification")); 
        return R.ok().put("data", productclassificationService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(ProductclassificationEntity productclassification){
        EntityWrapper< ProductclassificationEntity> ew = new EntityWrapper< ProductclassificationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( productclassification, "productclassification")); 
		ProductclassificationView productclassificationView =  productclassificationService.selectView(ew);
		return R.ok("searchproduct class成功").put("data", productclassificationView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ProductclassificationEntity productclassification = productclassificationService.selectById(id);
        return R.ok().put("data", productclassification);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ProductclassificationEntity productclassification = productclassificationService.selectById(id);
        return R.ok().put("data", productclassification);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProductclassificationEntity productclassification, HttpServletRequest request){
    	productclassification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(productclassification);
        productclassificationService.insert(productclassification);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ProductclassificationEntity productclassification, HttpServletRequest request){
    	productclassification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(productclassification);
        productclassificationService.insert(productclassification);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ProductclassificationEntity productclassification, HttpServletRequest request){
        //ValidatorUtils.validateEntity(productclassification);
        productclassificationService.updateById(productclassification);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        productclassificationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

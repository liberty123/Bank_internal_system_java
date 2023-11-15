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

import com.entity.DiscussbankoutletEntity;
import com.entity.view.DiscussbankoutletView;

import com.service.DiscussbankoutletService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * bankoutlet评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:27
 */
@RestController
@RequestMapping("/discussbankoutlet")
public class DiscussbankoutletController {
    @Autowired
    private DiscussbankoutletService discussbankoutletService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussbankoutletEntity discussbankoutlet,
		HttpServletRequest request){
        EntityWrapper<DiscussbankoutletEntity> ew = new EntityWrapper<DiscussbankoutletEntity>();

		PageUtils page = discussbankoutletService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbankoutlet), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussbankoutletEntity discussbankoutlet, 
		HttpServletRequest request){
        EntityWrapper<DiscussbankoutletEntity> ew = new EntityWrapper<DiscussbankoutletEntity>();

		PageUtils page = discussbankoutletService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbankoutlet), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( DiscussbankoutletEntity discussbankoutlet){
       	EntityWrapper<DiscussbankoutletEntity> ew = new EntityWrapper<DiscussbankoutletEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussbankoutlet, "discussbankoutlet")); 
        return R.ok().put("data", discussbankoutletService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(DiscussbankoutletEntity discussbankoutlet){
        EntityWrapper< DiscussbankoutletEntity> ew = new EntityWrapper< DiscussbankoutletEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussbankoutlet, "discussbankoutlet")); 
		DiscussbankoutletView discussbankoutletView =  discussbankoutletService.selectView(ew);
		return R.ok("searchbankoutlet评论表成功").put("data", discussbankoutletView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussbankoutletEntity discussbankoutlet = discussbankoutletService.selectById(id);
        return R.ok().put("data", discussbankoutlet);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussbankoutletEntity discussbankoutlet = discussbankoutletService.selectById(id);
        return R.ok().put("data", discussbankoutlet);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussbankoutletEntity discussbankoutlet, HttpServletRequest request){
    	discussbankoutlet.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbankoutlet);
        discussbankoutletService.insert(discussbankoutlet);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussbankoutletEntity discussbankoutlet, HttpServletRequest request){
    	discussbankoutlet.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbankoutlet);
        discussbankoutletService.insert(discussbankoutlet);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussbankoutletEntity discussbankoutlet, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussbankoutlet);
        discussbankoutletService.updateById(discussbankoutlet);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussbankoutletService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

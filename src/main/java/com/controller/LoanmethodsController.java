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

import com.entity.LoanmethodsEntity;
import com.entity.view.LoanmethodsView;

import com.service.LoanmethodsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Loan method
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/loanmethods")
public class LoanmethodsController {
    @Autowired
    private LoanmethodsService loanmethodsService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LoanmethodsEntity loanmethods,
		HttpServletRequest request){
        EntityWrapper<LoanmethodsEntity> ew = new EntityWrapper<LoanmethodsEntity>();

		PageUtils page = loanmethodsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanmethods), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LoanmethodsEntity loanmethods, 
		HttpServletRequest request){
        EntityWrapper<LoanmethodsEntity> ew = new EntityWrapper<LoanmethodsEntity>();

		PageUtils page = loanmethodsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanmethods), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( LoanmethodsEntity loanmethods){
       	EntityWrapper<LoanmethodsEntity> ew = new EntityWrapper<LoanmethodsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( loanmethods, "loanmethods")); 
        return R.ok().put("data", loanmethodsService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(LoanmethodsEntity loanmethods){
        EntityWrapper< LoanmethodsEntity> ew = new EntityWrapper< LoanmethodsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( loanmethods, "loanmethods")); 
		LoanmethodsView loanmethodsView =  loanmethodsService.selectView(ew);
		return R.ok("searchLoan method成功").put("data", loanmethodsView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LoanmethodsEntity loanmethods = loanmethodsService.selectById(id);
        return R.ok().put("data", loanmethods);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LoanmethodsEntity loanmethods = loanmethodsService.selectById(id);
        return R.ok().put("data", loanmethods);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LoanmethodsEntity loanmethods, HttpServletRequest request){
    	loanmethods.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanmethods);
        loanmethodsService.insert(loanmethods);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LoanmethodsEntity loanmethods, HttpServletRequest request){
    	loanmethods.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanmethods);
        loanmethodsService.insert(loanmethods);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LoanmethodsEntity loanmethods, HttpServletRequest request){
        //ValidatorUtils.validateEntity(loanmethods);
        loanmethodsService.updateById(loanmethods);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        loanmethodsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

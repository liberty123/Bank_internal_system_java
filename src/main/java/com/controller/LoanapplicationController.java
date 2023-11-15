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

import com.entity.LoanapplicationEntity;
import com.entity.view.LoanapplicationView;

import com.service.LoanapplicationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * loan application
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/loanapplication")
public class LoanapplicationController {
    @Autowired
    private LoanapplicationService loanapplicationService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LoanapplicationEntity loanapplication,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("customer")) {
			loanapplication.setCustomernumber((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LoanapplicationEntity> ew = new EntityWrapper<LoanapplicationEntity>();

		PageUtils page = loanapplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanapplication), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LoanapplicationEntity loanapplication, 
		HttpServletRequest request){
        EntityWrapper<LoanapplicationEntity> ew = new EntityWrapper<LoanapplicationEntity>();

		PageUtils page = loanapplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanapplication), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( LoanapplicationEntity loanapplication){
       	EntityWrapper<LoanapplicationEntity> ew = new EntityWrapper<LoanapplicationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( loanapplication, "loanapplication")); 
        return R.ok().put("data", loanapplicationService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(LoanapplicationEntity loanapplication){
        EntityWrapper< LoanapplicationEntity> ew = new EntityWrapper< LoanapplicationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( loanapplication, "loanapplication")); 
		LoanapplicationView loanapplicationView =  loanapplicationService.selectView(ew);
		return R.ok("searchloan application成功").put("data", loanapplicationView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LoanapplicationEntity loanapplication = loanapplicationService.selectById(id);
        return R.ok().put("data", loanapplication);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LoanapplicationEntity loanapplication = loanapplicationService.selectById(id);
        return R.ok().put("data", loanapplication);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LoanapplicationEntity loanapplication, HttpServletRequest request){
    	loanapplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanapplication);
        loanapplicationService.insert(loanapplication);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LoanapplicationEntity loanapplication, HttpServletRequest request){
    	loanapplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanapplication);
        loanapplicationService.insert(loanapplication);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LoanapplicationEntity loanapplication, HttpServletRequest request){
        //ValidatorUtils.validateEntity(loanapplication);
        loanapplicationService.updateById(loanapplication);//All更新
        return R.ok();
    }

    /**
     * Review
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LoanapplicationEntity> list = new ArrayList<LoanapplicationEntity>();
        for(Long id : ids) {
            LoanapplicationEntity loanapplication = loanapplicationService.selectById(id);
            loanapplication.setSfsh(sfsh);
            loanapplication.setShhf(shhf);
            list.add(loanapplication);
        }
        loanapplicationService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        loanapplicationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

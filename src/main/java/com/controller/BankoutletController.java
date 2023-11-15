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

import com.entity.BankoutletEntity;
import com.entity.view.BankoutletView;

import com.service.BankoutletService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Bank network
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/bankoutlet")
public class BankoutletController {
    @Autowired
    private BankoutletService bankoutletService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BankoutletEntity bankoutlet,
		HttpServletRequest request){
        EntityWrapper<BankoutletEntity> ew = new EntityWrapper<BankoutletEntity>();

		PageUtils page = bankoutletService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bankoutlet), params), params));

        return R.ok().put("data", page);
    }
    
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BankoutletEntity bankoutlet, 
		HttpServletRequest request){
        EntityWrapper<BankoutletEntity> ew = new EntityWrapper<BankoutletEntity>();

		PageUtils page = bankoutletService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bankoutlet), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( BankoutletEntity bankoutlet){
       	EntityWrapper<BankoutletEntity> ew = new EntityWrapper<BankoutletEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bankoutlet, "bankoutlet")); 
        return R.ok().put("data", bankoutletService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(BankoutletEntity bankoutlet){
        EntityWrapper< BankoutletEntity> ew = new EntityWrapper< BankoutletEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bankoutlet, "bankoutlet")); 
		BankoutletView bankoutletView =  bankoutletService.selectView(ew);
		return R.ok("searchBank network成功").put("data", bankoutletView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BankoutletEntity bankoutlet = bankoutletService.selectById(id);
        return R.ok().put("data", bankoutlet);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BankoutletEntity bankoutlet = bankoutletService.selectById(id);
        return R.ok().put("data", bankoutlet);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BankoutletEntity bankoutlet, HttpServletRequest request){
    	bankoutlet.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bankoutlet);
        bankoutletService.insert(bankoutlet);
        return R.ok();
    }
    
    @RequestMapping("/add")
    public R add(@RequestBody BankoutletEntity bankoutlet, HttpServletRequest request){
    	bankoutlet.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bankoutlet);
        bankoutletService.insert(bankoutlet);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BankoutletEntity bankoutlet, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bankoutlet);
        bankoutletService.updateById(bankoutlet);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bankoutletService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

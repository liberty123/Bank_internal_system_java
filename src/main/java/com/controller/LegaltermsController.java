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

import com.entity.LegaltermsEntity;
import com.entity.view.LegaltermsView;

import com.service.LegaltermsService;
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
 * legal provisions
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/legalterms")
public class LegaltermsController {
    @Autowired
    private LegaltermsService legaltermsService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LegaltermsEntity legalterms,
		HttpServletRequest request){
        EntityWrapper<LegaltermsEntity> ew = new EntityWrapper<LegaltermsEntity>();

		PageUtils page = legaltermsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, legalterms), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LegaltermsEntity legalterms, 
		HttpServletRequest request){
        EntityWrapper<LegaltermsEntity> ew = new EntityWrapper<LegaltermsEntity>();

		PageUtils page = legaltermsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, legalterms), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( LegaltermsEntity legalterms){
       	EntityWrapper<LegaltermsEntity> ew = new EntityWrapper<LegaltermsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( legalterms, "legalterms")); 
        return R.ok().put("data", legaltermsService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(LegaltermsEntity legalterms){
        EntityWrapper< LegaltermsEntity> ew = new EntityWrapper< LegaltermsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( legalterms, "legalterms")); 
		LegaltermsView legaltermsView =  legaltermsService.selectView(ew);
		return R.ok("searchlegal provisions成功").put("data", legaltermsView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LegaltermsEntity legalterms = legaltermsService.selectById(id);
        return R.ok().put("data", legalterms);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LegaltermsEntity legalterms = legaltermsService.selectById(id);
        return R.ok().put("data", legalterms);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LegaltermsEntity legalterms, HttpServletRequest request){
    	legalterms.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(legalterms);
        legaltermsService.insert(legalterms);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LegaltermsEntity legalterms, HttpServletRequest request){
    	legalterms.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(legalterms);
        legaltermsService.insert(legalterms);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LegaltermsEntity legalterms, HttpServletRequest request){
        //ValidatorUtils.validateEntity(legalterms);
        legaltermsService.updateById(legalterms);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        legaltermsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

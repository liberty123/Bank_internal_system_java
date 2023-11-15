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

import com.entity.PreciousmetalsEntity;
import com.entity.view.PreciousmetalsView;

import com.service.PreciousmetalsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * precious metal
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/preciousmetals")
public class PreciousmetalsController {
    @Autowired
    private PreciousmetalsService preciousmetalsService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PreciousmetalsEntity preciousmetals,
		HttpServletRequest request){
        EntityWrapper<PreciousmetalsEntity> ew = new EntityWrapper<PreciousmetalsEntity>();

		PageUtils page = preciousmetalsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, preciousmetals), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PreciousmetalsEntity preciousmetals, 
		HttpServletRequest request){
        EntityWrapper<PreciousmetalsEntity> ew = new EntityWrapper<PreciousmetalsEntity>();

		PageUtils page = preciousmetalsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, preciousmetals), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( PreciousmetalsEntity preciousmetals){
       	EntityWrapper<PreciousmetalsEntity> ew = new EntityWrapper<PreciousmetalsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( preciousmetals, "preciousmetals")); 
        return R.ok().put("data", preciousmetalsService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(PreciousmetalsEntity preciousmetals){
        EntityWrapper< PreciousmetalsEntity> ew = new EntityWrapper< PreciousmetalsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( preciousmetals, "preciousmetals")); 
		PreciousmetalsView preciousmetalsView =  preciousmetalsService.selectView(ew);
		return R.ok("searchprecious metal成功").put("data", preciousmetalsView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PreciousmetalsEntity preciousmetals = preciousmetalsService.selectById(id);
        return R.ok().put("data", preciousmetals);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PreciousmetalsEntity preciousmetals = preciousmetalsService.selectById(id);
        return R.ok().put("data", preciousmetals);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PreciousmetalsEntity preciousmetals, HttpServletRequest request){
    	preciousmetals.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(preciousmetals);
        preciousmetalsService.insert(preciousmetals);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PreciousmetalsEntity preciousmetals, HttpServletRequest request){
    	preciousmetals.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(preciousmetals);
        preciousmetalsService.insert(preciousmetals);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PreciousmetalsEntity preciousmetals, HttpServletRequest request){
        //ValidatorUtils.validateEntity(preciousmetals);
        preciousmetalsService.updateById(preciousmetals);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        preciousmetalsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.ExamnoticeEntity;
import com.entity.view.ExamnoticeView;

import com.service.ExamnoticeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Examination Notice
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/examnotice")
public class ExamnoticeController {
    @Autowired
    private ExamnoticeService examnoticeService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExamnoticeEntity examnotice,
		HttpServletRequest request){
        EntityWrapper<ExamnoticeEntity> ew = new EntityWrapper<ExamnoticeEntity>();

		PageUtils page = examnoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examnotice), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExamnoticeEntity examnotice, 
		HttpServletRequest request){
        EntityWrapper<ExamnoticeEntity> ew = new EntityWrapper<ExamnoticeEntity>();

		PageUtils page = examnoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examnotice), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( ExamnoticeEntity examnotice){
       	EntityWrapper<ExamnoticeEntity> ew = new EntityWrapper<ExamnoticeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( examnotice, "examnotice")); 
        return R.ok().put("data", examnoticeService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(ExamnoticeEntity examnotice){
        EntityWrapper< ExamnoticeEntity> ew = new EntityWrapper< ExamnoticeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( examnotice, "examnotice")); 
		ExamnoticeView examnoticeView =  examnoticeService.selectView(ew);
		return R.ok("searchExamination Notice成功").put("data", examnoticeView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExamnoticeEntity examnotice = examnoticeService.selectById(id);
        return R.ok().put("data", examnotice);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExamnoticeEntity examnotice = examnoticeService.selectById(id);
        return R.ok().put("data", examnotice);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExamnoticeEntity examnotice, HttpServletRequest request){
    	examnotice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examnotice);
        examnoticeService.insert(examnotice);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExamnoticeEntity examnotice, HttpServletRequest request){
    	examnotice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examnotice);
        examnoticeService.insert(examnotice);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ExamnoticeEntity examnotice, HttpServletRequest request){
        //ValidatorUtils.validateEntity(examnotice);
        examnoticeService.updateById(examnotice);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        examnoticeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

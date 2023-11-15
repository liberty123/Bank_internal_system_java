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

import com.entity.WorkscheduleEntity;
import com.entity.view.WorkscheduleView;

import com.service.WorkscheduleService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * order of the day
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/workschedule")
public class WorkscheduleController {
    @Autowired
    private WorkscheduleService workscheduleService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WorkscheduleEntity workschedule,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("administrator")) {
    		workschedule.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("bankemployee")) {
			workschedule.setEmployeeid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WorkscheduleEntity> ew = new EntityWrapper<WorkscheduleEntity>();

		PageUtils page = workscheduleService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workschedule), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WorkscheduleEntity workschedule, 
		HttpServletRequest request){
        EntityWrapper<WorkscheduleEntity> ew = new EntityWrapper<WorkscheduleEntity>();

		PageUtils page = workscheduleService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workschedule), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( WorkscheduleEntity workschedule){
       	EntityWrapper<WorkscheduleEntity> ew = new EntityWrapper<WorkscheduleEntity>();
      	ew.allEq(MPUtil.allEQMapPre( workschedule, "workschedule")); 
        return R.ok().put("data", workscheduleService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(WorkscheduleEntity workschedule){
        EntityWrapper< WorkscheduleEntity> ew = new EntityWrapper< WorkscheduleEntity>();
 		ew.allEq(MPUtil.allEQMapPre( workschedule, "workschedule")); 
		WorkscheduleView workscheduleView =  workscheduleService.selectView(ew);
		return R.ok("searchorder of the day成功").put("data", workscheduleView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WorkscheduleEntity workschedule = workscheduleService.selectById(id);
        return R.ok().put("data", workschedule);
    }

    /**
     * 前端details
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WorkscheduleEntity workschedule = workscheduleService.selectById(id);
        return R.ok().put("data", workschedule);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WorkscheduleEntity workschedule, HttpServletRequest request){
    	workschedule.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(workschedule);
    	workschedule.setUserid((Long)request.getSession().getAttribute("userId"));
        workscheduleService.insert(workschedule);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WorkscheduleEntity workschedule, HttpServletRequest request){
    	workschedule.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(workschedule);
        workscheduleService.insert(workschedule);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WorkscheduleEntity workschedule, HttpServletRequest request){
        //ValidatorUtils.validateEntity(workschedule);
        workscheduleService.updateById(workschedule);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        workscheduleService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.LeaveapplicationEntity;
import com.entity.view.LeaveapplicationView;

import com.service.LeaveapplicationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Leave Application
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/leaveapplication")
public class LeaveapplicationController {
    @Autowired
    private LeaveapplicationService leaveapplicationService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LeaveapplicationEntity leaveapplication,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("bankemployee")) {
			leaveapplication.setEmployeeid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LeaveapplicationEntity> ew = new EntityWrapper<LeaveapplicationEntity>();

		PageUtils page = leaveapplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, leaveapplication), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LeaveapplicationEntity leaveapplication, 
		HttpServletRequest request){
        EntityWrapper<LeaveapplicationEntity> ew = new EntityWrapper<LeaveapplicationEntity>();

		PageUtils page = leaveapplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, leaveapplication), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( LeaveapplicationEntity leaveapplication){
       	EntityWrapper<LeaveapplicationEntity> ew = new EntityWrapper<LeaveapplicationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( leaveapplication, "leaveapplication")); 
        return R.ok().put("data", leaveapplicationService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(LeaveapplicationEntity leaveapplication){
        EntityWrapper< LeaveapplicationEntity> ew = new EntityWrapper< LeaveapplicationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( leaveapplication, "leaveapplication")); 
		LeaveapplicationView leaveapplicationView =  leaveapplicationService.selectView(ew);
		return R.ok("searchLeave Application成功").put("data", leaveapplicationView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LeaveapplicationEntity leaveapplication = leaveapplicationService.selectById(id);
        return R.ok().put("data", leaveapplication);
    }

    /**
     * 前端details
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LeaveapplicationEntity leaveapplication = leaveapplicationService.selectById(id);
        return R.ok().put("data", leaveapplication);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LeaveapplicationEntity leaveapplication, HttpServletRequest request){
    	leaveapplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(leaveapplication);
        leaveapplicationService.insert(leaveapplication);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LeaveapplicationEntity leaveapplication, HttpServletRequest request){
    	leaveapplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(leaveapplication);
        leaveapplicationService.insert(leaveapplication);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LeaveapplicationEntity leaveapplication, HttpServletRequest request){
        //ValidatorUtils.validateEntity(leaveapplication);
        leaveapplicationService.updateById(leaveapplication);//All更新
        return R.ok();
    }

    /**
     * Review
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LeaveapplicationEntity> list = new ArrayList<LeaveapplicationEntity>();
        for(Long id : ids) {
            LeaveapplicationEntity leaveapplication = leaveapplicationService.selectById(id);
            leaveapplication.setSfsh(sfsh);
            leaveapplication.setShhf(shhf);
            list.add(leaveapplication);
        }
        leaveapplicationService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        leaveapplicationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

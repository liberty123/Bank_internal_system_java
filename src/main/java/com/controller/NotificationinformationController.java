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

import com.entity.NotificationinformationEntity;
import com.entity.view.NotificationinformationView;

import com.service.NotificationinformationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * notification information
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/notificationinformation")
public class NotificationinformationController {
    @Autowired
    private NotificationinformationService notificationinformationService;



    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NotificationinformationEntity notificationinformation,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date notificationtimestart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date notificationtimeend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("bankemployee")) {
			notificationinformation.setEmployeeid((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("customer")) {
			notificationinformation.setCustomernumber((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NotificationinformationEntity> ew = new EntityWrapper<NotificationinformationEntity>();
                if(notificationtimestart!=null) ew.ge("notificationtime", notificationtimestart);
                if(notificationtimeend!=null) ew.le("notificationtime", notificationtimeend);

		PageUtils page = notificationinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, notificationinformation), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NotificationinformationEntity notificationinformation, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date notificationtimestart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date notificationtimeend,
		HttpServletRequest request){
        EntityWrapper<NotificationinformationEntity> ew = new EntityWrapper<NotificationinformationEntity>();
                if(notificationtimestart!=null) ew.ge("notificationtime", notificationtimestart);
                if(notificationtimeend!=null) ew.le("notificationtime", notificationtimeend);

		PageUtils page = notificationinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, notificationinformation), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( NotificationinformationEntity notificationinformation){
       	EntityWrapper<NotificationinformationEntity> ew = new EntityWrapper<NotificationinformationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( notificationinformation, "notificationinformation")); 
        return R.ok().put("data", notificationinformationService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(NotificationinformationEntity notificationinformation){
        EntityWrapper< NotificationinformationEntity> ew = new EntityWrapper< NotificationinformationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( notificationinformation, "notificationinformation")); 
		NotificationinformationView notificationinformationView =  notificationinformationService.selectView(ew);
		return R.ok("searchnotification information成功").put("data", notificationinformationView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NotificationinformationEntity notificationinformation = notificationinformationService.selectById(id);
        return R.ok().put("data", notificationinformation);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NotificationinformationEntity notificationinformation = notificationinformationService.selectById(id);
        return R.ok().put("data", notificationinformation);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NotificationinformationEntity notificationinformation, HttpServletRequest request){
    	notificationinformation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(notificationinformation);
        notificationinformationService.insert(notificationinformation);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NotificationinformationEntity notificationinformation, HttpServletRequest request){
    	notificationinformation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(notificationinformation);
        notificationinformationService.insert(notificationinformation);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NotificationinformationEntity notificationinformation, HttpServletRequest request){
        //ValidatorUtils.validateEntity(notificationinformation);
        notificationinformationService.updateById(notificationinformation);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        notificationinformationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.WealthmanagementproductsEntity;
import com.entity.view.WealthmanagementproductsView;

import com.service.WealthmanagementproductsService;
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
 * Financial product 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/wealthmanagementproducts")
public class WealthmanagementproductsController {
    @Autowired
    private WealthmanagementproductsService wealthmanagementproductsService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WealthmanagementproductsEntity wealthmanagementproducts,
		HttpServletRequest request){
        EntityWrapper<WealthmanagementproductsEntity> ew = new EntityWrapper<WealthmanagementproductsEntity>();

		PageUtils page = wealthmanagementproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wealthmanagementproducts), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WealthmanagementproductsEntity wealthmanagementproducts, 
		HttpServletRequest request){
        EntityWrapper<WealthmanagementproductsEntity> ew = new EntityWrapper<WealthmanagementproductsEntity>();

		PageUtils page = wealthmanagementproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wealthmanagementproducts), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( WealthmanagementproductsEntity wealthmanagementproducts){
       	EntityWrapper<WealthmanagementproductsEntity> ew = new EntityWrapper<WealthmanagementproductsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wealthmanagementproducts, "wealthmanagementproducts")); 
        return R.ok().put("data", wealthmanagementproductsService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(WealthmanagementproductsEntity wealthmanagementproducts){
        EntityWrapper< WealthmanagementproductsEntity> ew = new EntityWrapper< WealthmanagementproductsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wealthmanagementproducts, "wealthmanagementproducts")); 
		WealthmanagementproductsView wealthmanagementproductsView =  wealthmanagementproductsService.selectView(ew);
		return R.ok("searchFinancial product 成功").put("data", wealthmanagementproductsView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WealthmanagementproductsEntity wealthmanagementproducts = wealthmanagementproductsService.selectById(id);
		wealthmanagementproducts.setClicknum(wealthmanagementproducts.getClicknum()+1);
		wealthmanagementproducts.setClicktime(new Date());
		wealthmanagementproductsService.updateById(wealthmanagementproducts);
        return R.ok().put("data", wealthmanagementproducts);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WealthmanagementproductsEntity wealthmanagementproducts = wealthmanagementproductsService.selectById(id);
		wealthmanagementproducts.setClicknum(wealthmanagementproducts.getClicknum()+1);
		wealthmanagementproducts.setClicktime(new Date());
		wealthmanagementproductsService.updateById(wealthmanagementproducts);
        return R.ok().put("data", wealthmanagementproducts);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WealthmanagementproductsEntity wealthmanagementproducts, HttpServletRequest request){
    	wealthmanagementproducts.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wealthmanagementproducts);
        wealthmanagementproductsService.insert(wealthmanagementproducts);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WealthmanagementproductsEntity wealthmanagementproducts, HttpServletRequest request){
    	wealthmanagementproducts.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wealthmanagementproducts);
        wealthmanagementproductsService.insert(wealthmanagementproducts);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WealthmanagementproductsEntity wealthmanagementproducts, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wealthmanagementproducts);
        wealthmanagementproductsService.updateById(wealthmanagementproducts);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wealthmanagementproductsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,WealthmanagementproductsEntity wealthmanagementproducts, HttpServletRequest request,String pre){
        EntityWrapper<WealthmanagementproductsEntity> ew = new EntityWrapper<WealthmanagementproductsEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = wealthmanagementproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wealthmanagementproducts), params), params));
        return R.ok().put("data", page);
    }










}

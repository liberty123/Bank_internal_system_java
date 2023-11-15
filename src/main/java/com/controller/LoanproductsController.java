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

import com.entity.LoanproductsEntity;
import com.entity.view.LoanproductsView;

import com.service.LoanproductsService;
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
 * Loan product 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/loanproducts")
public class LoanproductsController {
    @Autowired
    private LoanproductsService loanproductsService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LoanproductsEntity loanproducts,
		HttpServletRequest request){
        EntityWrapper<LoanproductsEntity> ew = new EntityWrapper<LoanproductsEntity>();

		PageUtils page = loanproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanproducts), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LoanproductsEntity loanproducts, 
		HttpServletRequest request){
        EntityWrapper<LoanproductsEntity> ew = new EntityWrapper<LoanproductsEntity>();

		PageUtils page = loanproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanproducts), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( LoanproductsEntity loanproducts){
       	EntityWrapper<LoanproductsEntity> ew = new EntityWrapper<LoanproductsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( loanproducts, "loanproducts")); 
        return R.ok().put("data", loanproductsService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(LoanproductsEntity loanproducts){
        EntityWrapper< LoanproductsEntity> ew = new EntityWrapper< LoanproductsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( loanproducts, "loanproducts")); 
		LoanproductsView loanproductsView =  loanproductsService.selectView(ew);
		return R.ok("searchLoan product 成功").put("data", loanproductsView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LoanproductsEntity loanproducts = loanproductsService.selectById(id);
		loanproducts.setClicknum(loanproducts.getClicknum()+1);
		loanproducts.setClicktime(new Date());
		loanproductsService.updateById(loanproducts);
        return R.ok().put("data", loanproducts);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LoanproductsEntity loanproducts = loanproductsService.selectById(id);
		loanproducts.setClicknum(loanproducts.getClicknum()+1);
		loanproducts.setClicktime(new Date());
		loanproductsService.updateById(loanproducts);
        return R.ok().put("data", loanproducts);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LoanproductsEntity loanproducts, HttpServletRequest request){
    	loanproducts.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanproducts);
        loanproductsService.insert(loanproducts);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LoanproductsEntity loanproducts, HttpServletRequest request){
    	loanproducts.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loanproducts);
        loanproductsService.insert(loanproducts);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LoanproductsEntity loanproducts, HttpServletRequest request){
        //ValidatorUtils.validateEntity(loanproducts);
        loanproductsService.updateById(loanproducts);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        loanproductsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LoanproductsEntity loanproducts, HttpServletRequest request,String pre){
        EntityWrapper<LoanproductsEntity> ew = new EntityWrapper<LoanproductsEntity>();
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
		PageUtils page = loanproductsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loanproducts), params), params));
        return R.ok().put("data", page);
    }










}

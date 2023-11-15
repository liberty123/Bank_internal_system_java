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

import com.entity.CustomerEntity;
import com.entity.view.CustomerView;

import com.service.CustomerService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * client
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * login
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		CustomerEntity u = customerService.selectOne(new EntityWrapper<CustomerEntity>().eq("customernumber", username));
		if(u==null || !u.getPassword().equals(password)) {
			return R.error("The account or password is incorrect");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"customer",  "customer" );
		return R.ok().put("token", token);
	}

	
	/**
     * register
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody CustomerEntity customer){
    	//ValidatorUtils.validateEntity(customer);
    	CustomerEntity u = customerService.selectOne(new EntityWrapper<CustomerEntity>().eq("customernumber", customer.getCustomernumber()));
		if(u!=null) {
			return R.error("registerUser already exists");
		}
		Long uId = new Date().getTime();
		customer.setId(uId);
        customerService.insert(customer);
        return R.ok();
    }

	
	/**
	 * Out
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("Out successful");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        CustomerEntity u = customerService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * Passwordresetting
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	CustomerEntity u = customerService.selectOne(new EntityWrapper<CustomerEntity>().eq("customernumber", username));
    	if(u==null) {
    		return R.error("Account does not exist");
    	}
        u.setPassword("123456");
        customerService.updateById(u);
        return R.ok("Password已resetting为：123456");
    }


    /**
     * 后端table
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CustomerEntity customer,
		HttpServletRequest request){
        EntityWrapper<CustomerEntity> ew = new EntityWrapper<CustomerEntity>();

		PageUtils page = customerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, customer), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CustomerEntity customer, 
		HttpServletRequest request){
        EntityWrapper<CustomerEntity> ew = new EntityWrapper<CustomerEntity>();

		PageUtils page = customerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, customer), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( CustomerEntity customer){
       	EntityWrapper<CustomerEntity> ew = new EntityWrapper<CustomerEntity>();
      	ew.allEq(MPUtil.allEQMapPre( customer, "customer")); 
        return R.ok().put("data", customerService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(CustomerEntity customer){
        EntityWrapper< CustomerEntity> ew = new EntityWrapper< CustomerEntity>();
 		ew.allEq(MPUtil.allEQMapPre( customer, "customer")); 
		CustomerView customerView =  customerService.selectView(ew);
		return R.ok("searchclient成功").put("data", customerView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CustomerEntity customer = customerService.selectById(id);
        return R.ok().put("data", customer);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CustomerEntity customer = customerService.selectById(id);
        return R.ok().put("data", customer);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerEntity customer, HttpServletRequest request){
    	customer.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(customer);
    	CustomerEntity u = customerService.selectOne(new EntityWrapper<CustomerEntity>().eq("customernumber", customer.getCustomernumber()));
		if(u!=null) {
			return R.error("User already exists");
		}
		customer.setId(new Date().getTime());
        customerService.insert(customer);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CustomerEntity customer, HttpServletRequest request){
    	customer.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(customer);
    	CustomerEntity u = customerService.selectOne(new EntityWrapper<CustomerEntity>().eq("customernumber", customer.getCustomernumber()));
		if(u!=null) {
			return R.error("User already exists");
		}
		customer.setId(new Date().getTime());
        customerService.insert(customer);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CustomerEntity customer, HttpServletRequest request){
        //ValidatorUtils.validateEntity(customer);
        customerService.updateById(customer);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        customerService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

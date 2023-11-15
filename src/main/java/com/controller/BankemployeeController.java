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

import com.entity.BankemployeeEntity;
import com.entity.view.BankemployeeView;

import com.service.BankemployeeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Bank employees
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
@RestController
@RequestMapping("/bankemployee")
public class BankemployeeController {
    @Autowired
    private BankemployeeService bankemployeeService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * login
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		BankemployeeEntity u = bankemployeeService.selectOne(new EntityWrapper<BankemployeeEntity>().eq("employeeid", username));
		if(u==null || !u.getPassword().equals(password)) {
			return R.error("The account or password is incorrect");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"bankemployee",  "bankemployee" );
		return R.ok().put("token", token);
	}

	
	/**
     * register
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody BankemployeeEntity bankemployee){
    	//ValidatorUtils.validateEntity(bankemployee);
    	BankemployeeEntity u = bankemployeeService.selectOne(new EntityWrapper<BankemployeeEntity>().eq("employeeid", bankemployee.getEmployeeid()));
		if(u!=null) {
			return R.error("registerUser already exists");
		}
		Long uId = new Date().getTime();
		bankemployee.setId(uId);
        bankemployeeService.insert(bankemployee);
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
        BankemployeeEntity u = bankemployeeService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * Passwordresetting
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	BankemployeeEntity u = bankemployeeService.selectOne(new EntityWrapper<BankemployeeEntity>().eq("employeeid", username));
    	if(u==null) {
    		return R.error("Account does not exist");
    	}
        u.setPassword("123456");
        bankemployeeService.updateById(u);
        return R.ok("Password已resetting为：123456");
    }


    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BankemployeeEntity bankemployee,
		HttpServletRequest request){
        EntityWrapper<BankemployeeEntity> ew = new EntityWrapper<BankemployeeEntity>();

		PageUtils page = bankemployeeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bankemployee), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端table
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BankemployeeEntity bankemployee, 
		HttpServletRequest request){
        EntityWrapper<BankemployeeEntity> ew = new EntityWrapper<BankemployeeEntity>();

		PageUtils page = bankemployeeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bankemployee), params), params));
        return R.ok().put("data", page);
    }

	/**
     * table
     */
    @RequestMapping("/lists")
    public R list( BankemployeeEntity bankemployee){
       	EntityWrapper<BankemployeeEntity> ew = new EntityWrapper<BankemployeeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bankemployee, "bankemployee")); 
        return R.ok().put("data", bankemployeeService.selectListView(ew));
    }

	 /**
     * search
     */
    @RequestMapping("/query")
    public R query(BankemployeeEntity bankemployee){
        EntityWrapper< BankemployeeEntity> ew = new EntityWrapper< BankemployeeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bankemployee, "bankemployee")); 
		BankemployeeView bankemployeeView =  bankemployeeService.selectView(ew);
		return R.ok("searchBank employees成功").put("data", bankemployeeView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BankemployeeEntity bankemployee = bankemployeeService.selectById(id);
        return R.ok().put("data", bankemployee);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BankemployeeEntity bankemployee = bankemployeeService.selectById(id);
        return R.ok().put("data", bankemployee);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BankemployeeEntity bankemployee, HttpServletRequest request){
    	bankemployee.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bankemployee);
    	BankemployeeEntity u = bankemployeeService.selectOne(new EntityWrapper<BankemployeeEntity>().eq("employeeid", bankemployee.getEmployeeid()));
		if(u!=null) {
			return R.error("User already exists");
		}
		bankemployee.setId(new Date().getTime());
        bankemployeeService.insert(bankemployee);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BankemployeeEntity bankemployee, HttpServletRequest request){
    	bankemployee.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bankemployee);
    	BankemployeeEntity u = bankemployeeService.selectOne(new EntityWrapper<BankemployeeEntity>().eq("employeeid", bankemployee.getEmployeeid()));
		if(u!=null) {
			return R.error("User already exists");
		}
		bankemployee.setId(new Date().getTime());
        bankemployeeService.insert(bankemployee);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BankemployeeEntity bankemployee, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bankemployee);
        bankemployeeService.updateById(bankemployee);//All更新
        return R.ok();
    }



    

    /**
     * del
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bankemployeeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

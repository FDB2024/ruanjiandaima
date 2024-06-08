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
import java.io.IOException;

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

import com.entity.SystemnoticeEntity;
import com.entity.view.SystemnoticeView;

import com.service.SystemnoticeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 系统公告
 * 后端接口
 * @author 
 * @email 
 * @date 2023-10-30 11:29:44
 */
@RestController
@RequestMapping("/systemnotice")
public class SystemnoticeController {
    @Autowired
    private SystemnoticeService systemnoticeService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SystemnoticeEntity systemnotice, 
		HttpServletRequest request){

        EntityWrapper<SystemnoticeEntity> ew = new EntityWrapper<SystemnoticeEntity>();


		PageUtils page = systemnoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, systemnotice), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SystemnoticeEntity systemnotice, 
		HttpServletRequest request){
        EntityWrapper<SystemnoticeEntity> ew = new EntityWrapper<SystemnoticeEntity>();

		PageUtils page = systemnoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, systemnotice), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SystemnoticeEntity systemnotice){
       	EntityWrapper<SystemnoticeEntity> ew = new EntityWrapper<SystemnoticeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( systemnotice, "systemnotice")); 
        return R.ok().put("data", systemnoticeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SystemnoticeEntity systemnotice){
        EntityWrapper< SystemnoticeEntity> ew = new EntityWrapper< SystemnoticeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( systemnotice, "systemnotice")); 
		SystemnoticeView systemnoticeView =  systemnoticeService.selectView(ew);
		return R.ok("查询系统公告成功").put("data", systemnoticeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SystemnoticeEntity systemnotice = systemnoticeService.selectById(id);
        return R.ok().put("data", systemnotice);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SystemnoticeEntity systemnotice = systemnoticeService.selectById(id);
        return R.ok().put("data", systemnotice);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SystemnoticeEntity systemnotice, HttpServletRequest request){
    	systemnotice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(systemnotice);

        systemnoticeService.insert(systemnotice);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SystemnoticeEntity systemnotice, HttpServletRequest request){
    	systemnotice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(systemnotice);

        systemnoticeService.insert(systemnotice);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SystemnoticeEntity systemnotice, HttpServletRequest request){
        //ValidatorUtils.validateEntity(systemnotice);
        systemnoticeService.updateById(systemnotice);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        systemnoticeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

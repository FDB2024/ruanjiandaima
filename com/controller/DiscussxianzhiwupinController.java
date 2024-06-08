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

import com.entity.DiscussxianzhiwupinEntity;
import com.entity.view.DiscussxianzhiwupinView;

import com.service.DiscussxianzhiwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 闲置物品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-10-30 11:29:44
 */
@RestController
@RequestMapping("/discussxianzhiwupin")
public class DiscussxianzhiwupinController {
    @Autowired
    private DiscussxianzhiwupinService discussxianzhiwupinService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxianzhiwupinEntity discussxianzhiwupin, 
		HttpServletRequest request){

        EntityWrapper<DiscussxianzhiwupinEntity> ew = new EntityWrapper<DiscussxianzhiwupinEntity>();


		PageUtils page = discussxianzhiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhiwupin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxianzhiwupinEntity discussxianzhiwupin, 
		HttpServletRequest request){
        EntityWrapper<DiscussxianzhiwupinEntity> ew = new EntityWrapper<DiscussxianzhiwupinEntity>();

		PageUtils page = discussxianzhiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhiwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxianzhiwupinEntity discussxianzhiwupin){
       	EntityWrapper<DiscussxianzhiwupinEntity> ew = new EntityWrapper<DiscussxianzhiwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxianzhiwupin, "discussxianzhiwupin")); 
        return R.ok().put("data", discussxianzhiwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxianzhiwupinEntity discussxianzhiwupin){
        EntityWrapper< DiscussxianzhiwupinEntity> ew = new EntityWrapper< DiscussxianzhiwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxianzhiwupin, "discussxianzhiwupin")); 
		DiscussxianzhiwupinView discussxianzhiwupinView =  discussxianzhiwupinService.selectView(ew);
		return R.ok("查询闲置物品评论表成功").put("data", discussxianzhiwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxianzhiwupinEntity discussxianzhiwupin = discussxianzhiwupinService.selectById(id);
        return R.ok().put("data", discussxianzhiwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxianzhiwupinEntity discussxianzhiwupin = discussxianzhiwupinService.selectById(id);
        return R.ok().put("data", discussxianzhiwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxianzhiwupinEntity discussxianzhiwupin, HttpServletRequest request){
    	discussxianzhiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianzhiwupin);

        discussxianzhiwupinService.insert(discussxianzhiwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxianzhiwupinEntity discussxianzhiwupin, HttpServletRequest request){
    	discussxianzhiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianzhiwupin);

        discussxianzhiwupinService.insert(discussxianzhiwupin);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussxianzhiwupinEntity discussxianzhiwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxianzhiwupin);
        discussxianzhiwupinService.updateById(discussxianzhiwupin);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxianzhiwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
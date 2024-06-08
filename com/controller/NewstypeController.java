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

import com.entity.NewstypeEntity;
import com.entity.view.NewstypeView;

import com.service.NewstypeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 公告信息分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-10-30 11:29:44
 */
@RestController
@RequestMapping("/newstype")
public class NewstypeController {
    @Autowired
    private NewstypeService newstypeService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NewstypeEntity newstype, 
		HttpServletRequest request){

        EntityWrapper<NewstypeEntity> ew = new EntityWrapper<NewstypeEntity>();


		PageUtils page = newstypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, newstype), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NewstypeEntity newstype, 
		HttpServletRequest request){
        EntityWrapper<NewstypeEntity> ew = new EntityWrapper<NewstypeEntity>();

		PageUtils page = newstypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, newstype), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NewstypeEntity newstype){
       	EntityWrapper<NewstypeEntity> ew = new EntityWrapper<NewstypeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( newstype, "newstype")); 
        return R.ok().put("data", newstypeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NewstypeEntity newstype){
        EntityWrapper< NewstypeEntity> ew = new EntityWrapper< NewstypeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( newstype, "newstype")); 
		NewstypeView newstypeView =  newstypeService.selectView(ew);
		return R.ok("查询公告信息分类成功").put("data", newstypeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NewstypeEntity newstype = newstypeService.selectById(id);
        return R.ok().put("data", newstype);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NewstypeEntity newstype = newstypeService.selectById(id);
        return R.ok().put("data", newstype);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NewstypeEntity newstype, HttpServletRequest request){
    	newstype.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(newstype);

        newstypeService.insert(newstype);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NewstypeEntity newstype, HttpServletRequest request){
    	newstype.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(newstype);

        newstypeService.insert(newstype);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NewstypeEntity newstype, HttpServletRequest request){
        //ValidatorUtils.validateEntity(newstype);
        newstypeService.updateById(newstype);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        newstypeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
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

import com.entity.XianzhiwupinEntity;
import com.entity.view.XianzhiwupinView;

import com.service.XianzhiwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 闲置物品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
@RestController
@RequestMapping("/xianzhiwupin")
public class XianzhiwupinController {
    @Autowired
    private XianzhiwupinService xianzhiwupinService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianzhiwupinEntity xianzhiwupin, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xianzhiwupin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianzhiwupinEntity> ew = new EntityWrapper<XianzhiwupinEntity>();


		PageUtils page = xianzhiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhiwupin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianzhiwupinEntity xianzhiwupin, 
		HttpServletRequest request){
        EntityWrapper<XianzhiwupinEntity> ew = new EntityWrapper<XianzhiwupinEntity>();

		PageUtils page = xianzhiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhiwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianzhiwupinEntity xianzhiwupin){
       	EntityWrapper<XianzhiwupinEntity> ew = new EntityWrapper<XianzhiwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianzhiwupin, "xianzhiwupin")); 
        return R.ok().put("data", xianzhiwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianzhiwupinEntity xianzhiwupin){
        EntityWrapper< XianzhiwupinEntity> ew = new EntityWrapper< XianzhiwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianzhiwupin, "xianzhiwupin")); 
		XianzhiwupinView xianzhiwupinView =  xianzhiwupinService.selectView(ew);
		return R.ok("查询闲置物品成功").put("data", xianzhiwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianzhiwupinEntity xianzhiwupin = xianzhiwupinService.selectById(id);
        return R.ok().put("data", xianzhiwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianzhiwupinEntity xianzhiwupin = xianzhiwupinService.selectById(id);
        return R.ok().put("data", xianzhiwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianzhiwupinEntity xianzhiwupin, HttpServletRequest request){
    	xianzhiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianzhiwupin);

        xianzhiwupinService.insert(xianzhiwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianzhiwupinEntity xianzhiwupin, HttpServletRequest request){
    	xianzhiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianzhiwupin);

        xianzhiwupinService.insert(xianzhiwupin);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianzhiwupinEntity xianzhiwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianzhiwupin);
        xianzhiwupinService.updateById(xianzhiwupin);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianzhiwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

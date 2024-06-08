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

import com.entity.JiaofeitongzhiEntity;
import com.entity.view.JiaofeitongzhiView;

import com.service.JiaofeitongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 缴费通知
 * 后端接口
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
@RestController
@RequestMapping("/jiaofeitongzhi")
public class JiaofeitongzhiController {
    @Autowired
    private JiaofeitongzhiService jiaofeitongzhiService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaofeitongzhiEntity jiaofeitongzhi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiaofeitongzhi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();


		PageUtils page = jiaofeitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitongzhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaofeitongzhiEntity jiaofeitongzhi, 
		HttpServletRequest request){
        EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();

		PageUtils page = jiaofeitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaofeitongzhiEntity jiaofeitongzhi){
       	EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaofeitongzhi, "jiaofeitongzhi")); 
        return R.ok().put("data", jiaofeitongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaofeitongzhiEntity jiaofeitongzhi){
        EntityWrapper< JiaofeitongzhiEntity> ew = new EntityWrapper< JiaofeitongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaofeitongzhi, "jiaofeitongzhi")); 
		JiaofeitongzhiView jiaofeitongzhiView =  jiaofeitongzhiService.selectView(ew);
		return R.ok("查询缴费通知成功").put("data", jiaofeitongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaofeitongzhiEntity jiaofeitongzhi = jiaofeitongzhiService.selectById(id);
        return R.ok().put("data", jiaofeitongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaofeitongzhiEntity jiaofeitongzhi = jiaofeitongzhiService.selectById(id);
        return R.ok().put("data", jiaofeitongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
    	jiaofeitongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeitongzhi);

        jiaofeitongzhiService.insert(jiaofeitongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
    	jiaofeitongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeitongzhi);

        jiaofeitongzhiService.insert(jiaofeitongzhi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeitongzhi);
        jiaofeitongzhiService.updateById(jiaofeitongzhi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaofeitongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

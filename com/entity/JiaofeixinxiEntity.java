package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 缴费信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
@TableName("jiaofeixinxi")
public class JiaofeixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaofeixinxiEntity() {
		
	}
	
	public JiaofeixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 手机号
	 */
					
	private String shoujihao;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 家庭住址
	 */
					
	private String jiatingzhuzhi;
	
	/**
	 * 年月
	 */
					
	private String nianyue;
	
	/**
	 * 发票
	 */
					
	private String fapiao;
	
	/**
	 * 用水量
	 */
					
	private String yongshuiliang;
	
	/**
	 * 水费
	 */
					
	private String shuifei;
	
	/**
	 * 用电量
	 */
					
	private String yongdianliang;
	
	/**
	 * 电费
	 */
					
	private String dianfei;
	
	/**
	 * 暖气费
	 */
					
	private String nuanqifei;
	
	/**
	 * 应缴费用
	 */
					
	private String yingjiaofeiyong;
	
	/**
	 * 缴费时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jiaofeishijian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：手机号
	 */
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：家庭住址
	 */
	public void setJiatingzhuzhi(String jiatingzhuzhi) {
		this.jiatingzhuzhi = jiatingzhuzhi;
	}
	/**
	 * 获取：家庭住址
	 */
	public String getJiatingzhuzhi() {
		return jiatingzhuzhi;
	}
	/**
	 * 设置：年月
	 */
	public void setNianyue(String nianyue) {
		this.nianyue = nianyue;
	}
	/**
	 * 获取：年月
	 */
	public String getNianyue() {
		return nianyue;
	}
	/**
	 * 设置：发票
	 */
	public void setFapiao(String fapiao) {
		this.fapiao = fapiao;
	}
	/**
	 * 获取：发票
	 */
	public String getFapiao() {
		return fapiao;
	}
	/**
	 * 设置：用水量
	 */
	public void setYongshuiliang(String yongshuiliang) {
		this.yongshuiliang = yongshuiliang;
	}
	/**
	 * 获取：用水量
	 */
	public String getYongshuiliang() {
		return yongshuiliang;
	}
	/**
	 * 设置：水费
	 */
	public void setShuifei(String shuifei) {
		this.shuifei = shuifei;
	}
	/**
	 * 获取：水费
	 */
	public String getShuifei() {
		return shuifei;
	}
	/**
	 * 设置：用电量
	 */
	public void setYongdianliang(String yongdianliang) {
		this.yongdianliang = yongdianliang;
	}
	/**
	 * 获取：用电量
	 */
	public String getYongdianliang() {
		return yongdianliang;
	}
	/**
	 * 设置：电费
	 */
	public void setDianfei(String dianfei) {
		this.dianfei = dianfei;
	}
	/**
	 * 获取：电费
	 */
	public String getDianfei() {
		return dianfei;
	}
	/**
	 * 设置：暖气费
	 */
	public void setNuanqifei(String nuanqifei) {
		this.nuanqifei = nuanqifei;
	}
	/**
	 * 获取：暖气费
	 */
	public String getNuanqifei() {
		return nuanqifei;
	}
	/**
	 * 设置：应缴费用
	 */
	public void setYingjiaofeiyong(String yingjiaofeiyong) {
		this.yingjiaofeiyong = yingjiaofeiyong;
	}
	/**
	 * 获取：应缴费用
	 */
	public String getYingjiaofeiyong() {
		return yingjiaofeiyong;
	}
	/**
	 * 设置：缴费时间
	 */
	public void setJiaofeishijian(Date jiaofeishijian) {
		this.jiaofeishijian = jiaofeishijian;
	}
	/**
	 * 获取：缴费时间
	 */
	public Date getJiaofeishijian() {
		return jiaofeishijian;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}

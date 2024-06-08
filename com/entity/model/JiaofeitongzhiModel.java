package com.entity.model;

import com.entity.JiaofeitongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 缴费通知
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
public class JiaofeitongzhiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	
	private Double shuifei;
		
	/**
	 * 用电量
	 */
	
	private String yongdianliang;
		
	/**
	 * 电费
	 */
	
	private Double dianfei;
		
	/**
	 * 暖气费
	 */
	
	private Double nuanqifei;
		
	/**
	 * 应缴费用
	 */
	
	private Double yingjiaofeiyong;
		
	/**
	 * 缴费状态
	 */
	
	private String jiaofeizhuangtai;
		
	/**
	 * 通知日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tongzhiriqi;
		
	/**
	 * 通知备注
	 */
	
	private String tongzhibeizhu;
				
	
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
	 
	public void setShuifei(Double shuifei) {
		this.shuifei = shuifei;
	}
	
	/**
	 * 获取：水费
	 */
	public Double getShuifei() {
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
	 
	public void setDianfei(Double dianfei) {
		this.dianfei = dianfei;
	}
	
	/**
	 * 获取：电费
	 */
	public Double getDianfei() {
		return dianfei;
	}
				
	
	/**
	 * 设置：暖气费
	 */
	 
	public void setNuanqifei(Double nuanqifei) {
		this.nuanqifei = nuanqifei;
	}
	
	/**
	 * 获取：暖气费
	 */
	public Double getNuanqifei() {
		return nuanqifei;
	}
				
	
	/**
	 * 设置：应缴费用
	 */
	 
	public void setYingjiaofeiyong(Double yingjiaofeiyong) {
		this.yingjiaofeiyong = yingjiaofeiyong;
	}
	
	/**
	 * 获取：应缴费用
	 */
	public Double getYingjiaofeiyong() {
		return yingjiaofeiyong;
	}
				
	
	/**
	 * 设置：缴费状态
	 */
	 
	public void setJiaofeizhuangtai(String jiaofeizhuangtai) {
		this.jiaofeizhuangtai = jiaofeizhuangtai;
	}
	
	/**
	 * 获取：缴费状态
	 */
	public String getJiaofeizhuangtai() {
		return jiaofeizhuangtai;
	}
				
	
	/**
	 * 设置：通知日期
	 */
	 
	public void setTongzhiriqi(Date tongzhiriqi) {
		this.tongzhiriqi = tongzhiriqi;
	}
	
	/**
	 * 获取：通知日期
	 */
	public Date getTongzhiriqi() {
		return tongzhiriqi;
	}
				
	
	/**
	 * 设置：通知备注
	 */
	 
	public void setTongzhibeizhu(String tongzhibeizhu) {
		this.tongzhibeizhu = tongzhibeizhu;
	}
	
	/**
	 * 获取：通知备注
	 */
	public String getTongzhibeizhu() {
		return tongzhibeizhu;
	}
			
}

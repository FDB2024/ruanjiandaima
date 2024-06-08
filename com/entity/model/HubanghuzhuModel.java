package com.entity.model;

import com.entity.HubanghuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 互帮互助
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
public class HubanghuzhuModel  implements Serializable {
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
	 * 互助标题
	 */
	
	private String huzhubiaoti;
		
	/**
	 * 互助图片
	 */
	
	private String huzhutupian;
		
	/**
	 * 互助内容
	 */
	
	private String huzhuneirong;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：互助标题
	 */
	 
	public void setHuzhubiaoti(String huzhubiaoti) {
		this.huzhubiaoti = huzhubiaoti;
	}
	
	/**
	 * 获取：互助标题
	 */
	public String getHuzhubiaoti() {
		return huzhubiaoti;
	}
				
	
	/**
	 * 设置：互助图片
	 */
	 
	public void setHuzhutupian(String huzhutupian) {
		this.huzhutupian = huzhutupian;
	}
	
	/**
	 * 获取：互助图片
	 */
	public String getHuzhutupian() {
		return huzhutupian;
	}
				
	
	/**
	 * 设置：互助内容
	 */
	 
	public void setHuzhuneirong(String huzhuneirong) {
		this.huzhuneirong = huzhuneirong;
	}
	
	/**
	 * 获取：互助内容
	 */
	public String getHuzhuneirong() {
		return huzhuneirong;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}

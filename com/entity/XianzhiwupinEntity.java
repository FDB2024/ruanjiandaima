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
 * 闲置物品
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
@TableName("xianzhiwupin")
public class XianzhiwupinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XianzhiwupinEntity() {
		
	}
	
	public XianzhiwupinEntity(T t) {
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
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品图片
	 */
					
	private String wupintupian;
	
	/**
	 * 新旧程度
	 */
					
	private String xinjiuchengdu;
	
	/**
	 * 物品数量
	 */
					
	private Integer wupinshuliang;
	
	/**
	 * 物品单价
	 */
					
	private Double wupindanjia;
	
	/**
	 * 物品品牌
	 */
					
	private String wupinpinpai;
	
	/**
	 * 物品详情
	 */
					
	private String wupinxiangqing;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	
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
	 * 设置：物品名称
	 */
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
	/**
	 * 设置：物品图片
	 */
	public void setWupintupian(String wupintupian) {
		this.wupintupian = wupintupian;
	}
	/**
	 * 获取：物品图片
	 */
	public String getWupintupian() {
		return wupintupian;
	}
	/**
	 * 设置：新旧程度
	 */
	public void setXinjiuchengdu(String xinjiuchengdu) {
		this.xinjiuchengdu = xinjiuchengdu;
	}
	/**
	 * 获取：新旧程度
	 */
	public String getXinjiuchengdu() {
		return xinjiuchengdu;
	}
	/**
	 * 设置：物品数量
	 */
	public void setWupinshuliang(Integer wupinshuliang) {
		this.wupinshuliang = wupinshuliang;
	}
	/**
	 * 获取：物品数量
	 */
	public Integer getWupinshuliang() {
		return wupinshuliang;
	}
	/**
	 * 设置：物品单价
	 */
	public void setWupindanjia(Double wupindanjia) {
		this.wupindanjia = wupindanjia;
	}
	/**
	 * 获取：物品单价
	 */
	public Double getWupindanjia() {
		return wupindanjia;
	}
	/**
	 * 设置：物品品牌
	 */
	public void setWupinpinpai(String wupinpinpai) {
		this.wupinpinpai = wupinpinpai;
	}
	/**
	 * 获取：物品品牌
	 */
	public String getWupinpinpai() {
		return wupinpinpai;
	}
	/**
	 * 设置：物品详情
	 */
	public void setWupinxiangqing(String wupinxiangqing) {
		this.wupinxiangqing = wupinxiangqing;
	}
	/**
	 * 获取：物品详情
	 */
	public String getWupinxiangqing() {
		return wupinxiangqing;
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

}

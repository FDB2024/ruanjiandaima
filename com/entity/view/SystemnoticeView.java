package com.entity.view;

import com.entity.SystemnoticeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 系统公告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-10-30 11:29:44
 */
@TableName("systemnotice")
public class SystemnoticeView  extends SystemnoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SystemnoticeView(){
	}
 
 	public SystemnoticeView(SystemnoticeEntity systemnoticeEntity){
 	try {
			BeanUtils.copyProperties(this, systemnoticeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

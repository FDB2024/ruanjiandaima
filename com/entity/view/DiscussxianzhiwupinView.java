package com.entity.view;

import com.entity.DiscussxianzhiwupinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 闲置物品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-10-30 11:29:44
 */
@TableName("discussxianzhiwupin")
public class DiscussxianzhiwupinView  extends DiscussxianzhiwupinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxianzhiwupinView(){
	}
 
 	public DiscussxianzhiwupinView(DiscussxianzhiwupinEntity discussxianzhiwupinEntity){
 	try {
			BeanUtils.copyProperties(this, discussxianzhiwupinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

package com.entity.view;

import com.entity.HubanghuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 互帮互助
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
@TableName("hubanghuzhu")
public class HubanghuzhuView  extends HubanghuzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HubanghuzhuView(){
	}
 
 	public HubanghuzhuView(HubanghuzhuEntity hubanghuzhuEntity){
 	try {
			BeanUtils.copyProperties(this, hubanghuzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}

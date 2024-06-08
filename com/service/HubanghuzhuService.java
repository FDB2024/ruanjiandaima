package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HubanghuzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HubanghuzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HubanghuzhuView;


/**
 * 互帮互助
 *
 * @author 
 * @email 
 * @date 2023-10-30 11:29:43
 */
public interface HubanghuzhuService extends IService<HubanghuzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HubanghuzhuVO> selectListVO(Wrapper<HubanghuzhuEntity> wrapper);
   	
   	HubanghuzhuVO selectVO(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
   	
   	List<HubanghuzhuView> selectListView(Wrapper<HubanghuzhuEntity> wrapper);
   	
   	HubanghuzhuView selectView(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HubanghuzhuEntity> wrapper);
   	

}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuochepiaodinggouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuochepiaodinggouView;


/**
 * 火车票订购
 *
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface HuochepiaodinggouService extends IService<HuochepiaodinggouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuochepiaodinggouView> selectListView(Wrapper<HuochepiaodinggouEntity> wrapper);
   	
   	HuochepiaodinggouView selectView(@Param("ew") Wrapper<HuochepiaodinggouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuochepiaodinggouEntity> wrapper);
   	

}


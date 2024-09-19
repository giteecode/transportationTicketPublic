package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JipiaodinggouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JipiaodinggouView;


/**
 * 机票订购
 *
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface JipiaodinggouService extends IService<JipiaodinggouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JipiaodinggouView> selectListView(Wrapper<JipiaodinggouEntity> wrapper);
   	
   	JipiaodinggouView selectView(@Param("ew") Wrapper<JipiaodinggouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JipiaodinggouEntity> wrapper);
   	

}


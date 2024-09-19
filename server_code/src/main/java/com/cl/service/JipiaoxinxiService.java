package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JipiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JipiaoxinxiView;


/**
 * 机票信息
 *
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface JipiaoxinxiService extends IService<JipiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JipiaoxinxiView> selectListView(Wrapper<JipiaoxinxiEntity> wrapper);
   	
   	JipiaoxinxiView selectView(@Param("ew") Wrapper<JipiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JipiaoxinxiEntity> wrapper);
   	

}


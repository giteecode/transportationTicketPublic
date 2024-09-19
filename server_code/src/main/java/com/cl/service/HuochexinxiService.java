package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuochexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuochexinxiView;


/**
 * 火车信息
 *
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface HuochexinxiService extends IService<HuochexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuochexinxiView> selectListView(Wrapper<HuochexinxiEntity> wrapper);
   	
   	HuochexinxiView selectView(@Param("ew") Wrapper<HuochexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuochexinxiEntity> wrapper);
   	

}


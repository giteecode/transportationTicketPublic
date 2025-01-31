package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QichedingpiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QichedingpiaoView;


/**
 * 汽车订票
 *
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface QichedingpiaoService extends IService<QichedingpiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QichedingpiaoView> selectListView(Wrapper<QichedingpiaoEntity> wrapper);
   	
   	QichedingpiaoView selectView(@Param("ew") Wrapper<QichedingpiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QichedingpiaoEntity> wrapper);
   	

}


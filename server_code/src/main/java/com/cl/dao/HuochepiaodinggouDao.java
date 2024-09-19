package com.cl.dao;

import com.cl.entity.HuochepiaodinggouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuochepiaodinggouView;


/**
 * 火车票订购
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface HuochepiaodinggouDao extends BaseMapper<HuochepiaodinggouEntity> {
	
	List<HuochepiaodinggouView> selectListView(@Param("ew") Wrapper<HuochepiaodinggouEntity> wrapper);

	List<HuochepiaodinggouView> selectListView(Pagination page,@Param("ew") Wrapper<HuochepiaodinggouEntity> wrapper);
	
	HuochepiaodinggouView selectView(@Param("ew") Wrapper<HuochepiaodinggouEntity> wrapper);
	

}

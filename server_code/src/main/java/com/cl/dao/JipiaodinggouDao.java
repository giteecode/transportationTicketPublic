package com.cl.dao;

import com.cl.entity.JipiaodinggouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JipiaodinggouView;


/**
 * 机票订购
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface JipiaodinggouDao extends BaseMapper<JipiaodinggouEntity> {
	
	List<JipiaodinggouView> selectListView(@Param("ew") Wrapper<JipiaodinggouEntity> wrapper);

	List<JipiaodinggouView> selectListView(Pagination page,@Param("ew") Wrapper<JipiaodinggouEntity> wrapper);
	
	JipiaodinggouView selectView(@Param("ew") Wrapper<JipiaodinggouEntity> wrapper);
	

}

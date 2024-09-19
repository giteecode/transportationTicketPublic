package com.cl.dao;

import com.cl.entity.JipiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JipiaoxinxiView;


/**
 * 机票信息
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface JipiaoxinxiDao extends BaseMapper<JipiaoxinxiEntity> {
	
	List<JipiaoxinxiView> selectListView(@Param("ew") Wrapper<JipiaoxinxiEntity> wrapper);

	List<JipiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JipiaoxinxiEntity> wrapper);
	
	JipiaoxinxiView selectView(@Param("ew") Wrapper<JipiaoxinxiEntity> wrapper);
	

}

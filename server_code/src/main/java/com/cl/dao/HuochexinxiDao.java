package com.cl.dao;

import com.cl.entity.HuochexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuochexinxiView;


/**
 * 火车信息
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface HuochexinxiDao extends BaseMapper<HuochexinxiEntity> {
	
	List<HuochexinxiView> selectListView(@Param("ew") Wrapper<HuochexinxiEntity> wrapper);

	List<HuochexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<HuochexinxiEntity> wrapper);
	
	HuochexinxiView selectView(@Param("ew") Wrapper<HuochexinxiEntity> wrapper);
	

}

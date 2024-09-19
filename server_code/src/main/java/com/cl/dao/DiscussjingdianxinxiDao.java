package com.cl.dao;

import com.cl.entity.DiscussjingdianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjingdianxinxiView;


/**
 * 景点信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface DiscussjingdianxinxiDao extends BaseMapper<DiscussjingdianxinxiEntity> {
	
	List<DiscussjingdianxinxiView> selectListView(@Param("ew") Wrapper<DiscussjingdianxinxiEntity> wrapper);

	List<DiscussjingdianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjingdianxinxiEntity> wrapper);
	
	DiscussjingdianxinxiView selectView(@Param("ew") Wrapper<DiscussjingdianxinxiEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.QichedingpiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QichedingpiaoView;


/**
 * 汽车订票
 * 
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
public interface QichedingpiaoDao extends BaseMapper<QichedingpiaoEntity> {
	
	List<QichedingpiaoView> selectListView(@Param("ew") Wrapper<QichedingpiaoEntity> wrapper);

	List<QichedingpiaoView> selectListView(Pagination page,@Param("ew") Wrapper<QichedingpiaoEntity> wrapper);
	
	QichedingpiaoView selectView(@Param("ew") Wrapper<QichedingpiaoEntity> wrapper);
	

}

package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.HuochexinxiEntity;
import com.cl.entity.view.HuochexinxiView;

import com.cl.service.HuochexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 火车信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/huochexinxi")
public class HuochexinxiController {
    @Autowired
    private HuochexinxiService huochexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuochexinxiEntity huochexinxi,
		HttpServletRequest request){
        EntityWrapper<HuochexinxiEntity> ew = new EntityWrapper<HuochexinxiEntity>();

		PageUtils page = huochexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuochexinxiEntity huochexinxi, 
		HttpServletRequest request){
        EntityWrapper<HuochexinxiEntity> ew = new EntityWrapper<HuochexinxiEntity>();

		PageUtils page = huochexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuochexinxiEntity huochexinxi){
       	EntityWrapper<HuochexinxiEntity> ew = new EntityWrapper<HuochexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huochexinxi, "huochexinxi")); 
        return R.ok().put("data", huochexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuochexinxiEntity huochexinxi){
        EntityWrapper< HuochexinxiEntity> ew = new EntityWrapper< HuochexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huochexinxi, "huochexinxi")); 
		HuochexinxiView huochexinxiView =  huochexinxiService.selectView(ew);
		return R.ok("查询火车信息成功").put("data", huochexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuochexinxiEntity huochexinxi = huochexinxiService.selectById(id);
		huochexinxi = huochexinxiService.selectView(new EntityWrapper<HuochexinxiEntity>().eq("id", id));
        return R.ok().put("data", huochexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuochexinxiEntity huochexinxi = huochexinxiService.selectById(id);
		huochexinxi = huochexinxiService.selectView(new EntityWrapper<HuochexinxiEntity>().eq("id", id));
        return R.ok().put("data", huochexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuochexinxiEntity huochexinxi, HttpServletRequest request){
    	huochexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochexinxi);
        huochexinxiService.insert(huochexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuochexinxiEntity huochexinxi, HttpServletRequest request){
    	huochexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochexinxi);
        huochexinxiService.insert(huochexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuochexinxiEntity huochexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huochexinxi);
        huochexinxiService.updateById(huochexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huochexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

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

import com.cl.entity.HuochepiaodinggouEntity;
import com.cl.entity.view.HuochepiaodinggouView;

import com.cl.service.HuochepiaodinggouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 火车票订购
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/huochepiaodinggou")
public class HuochepiaodinggouController {
    @Autowired
    private HuochepiaodinggouService huochepiaodinggouService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuochepiaodinggouEntity huochepiaodinggou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huochepiaodinggou.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuochepiaodinggouEntity> ew = new EntityWrapper<HuochepiaodinggouEntity>();

		PageUtils page = huochepiaodinggouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochepiaodinggou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuochepiaodinggouEntity huochepiaodinggou, 
		HttpServletRequest request){
        EntityWrapper<HuochepiaodinggouEntity> ew = new EntityWrapper<HuochepiaodinggouEntity>();

		PageUtils page = huochepiaodinggouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochepiaodinggou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuochepiaodinggouEntity huochepiaodinggou){
       	EntityWrapper<HuochepiaodinggouEntity> ew = new EntityWrapper<HuochepiaodinggouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huochepiaodinggou, "huochepiaodinggou")); 
        return R.ok().put("data", huochepiaodinggouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuochepiaodinggouEntity huochepiaodinggou){
        EntityWrapper< HuochepiaodinggouEntity> ew = new EntityWrapper< HuochepiaodinggouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huochepiaodinggou, "huochepiaodinggou")); 
		HuochepiaodinggouView huochepiaodinggouView =  huochepiaodinggouService.selectView(ew);
		return R.ok("查询火车票订购成功").put("data", huochepiaodinggouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuochepiaodinggouEntity huochepiaodinggou = huochepiaodinggouService.selectById(id);
		huochepiaodinggou = huochepiaodinggouService.selectView(new EntityWrapper<HuochepiaodinggouEntity>().eq("id", id));
        return R.ok().put("data", huochepiaodinggou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuochepiaodinggouEntity huochepiaodinggou = huochepiaodinggouService.selectById(id);
		huochepiaodinggou = huochepiaodinggouService.selectView(new EntityWrapper<HuochepiaodinggouEntity>().eq("id", id));
        return R.ok().put("data", huochepiaodinggou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuochepiaodinggouEntity huochepiaodinggou, HttpServletRequest request){
    	huochepiaodinggou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochepiaodinggou);
        huochepiaodinggouService.insert(huochepiaodinggou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuochepiaodinggouEntity huochepiaodinggou, HttpServletRequest request){
    	huochepiaodinggou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochepiaodinggou);
        huochepiaodinggouService.insert(huochepiaodinggou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuochepiaodinggouEntity huochepiaodinggou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huochepiaodinggou);
        huochepiaodinggouService.updateById(huochepiaodinggou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huochepiaodinggouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

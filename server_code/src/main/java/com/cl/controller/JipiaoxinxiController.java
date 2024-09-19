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

import com.cl.entity.JipiaoxinxiEntity;
import com.cl.entity.view.JipiaoxinxiView;

import com.cl.service.JipiaoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 机票信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/jipiaoxinxi")
public class JipiaoxinxiController {
    @Autowired
    private JipiaoxinxiService jipiaoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JipiaoxinxiEntity jipiaoxinxi,
		HttpServletRequest request){
        EntityWrapper<JipiaoxinxiEntity> ew = new EntityWrapper<JipiaoxinxiEntity>();

		PageUtils page = jipiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jipiaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JipiaoxinxiEntity jipiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<JipiaoxinxiEntity> ew = new EntityWrapper<JipiaoxinxiEntity>();

		PageUtils page = jipiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jipiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JipiaoxinxiEntity jipiaoxinxi){
       	EntityWrapper<JipiaoxinxiEntity> ew = new EntityWrapper<JipiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jipiaoxinxi, "jipiaoxinxi")); 
        return R.ok().put("data", jipiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JipiaoxinxiEntity jipiaoxinxi){
        EntityWrapper< JipiaoxinxiEntity> ew = new EntityWrapper< JipiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jipiaoxinxi, "jipiaoxinxi")); 
		JipiaoxinxiView jipiaoxinxiView =  jipiaoxinxiService.selectView(ew);
		return R.ok("查询机票信息成功").put("data", jipiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JipiaoxinxiEntity jipiaoxinxi = jipiaoxinxiService.selectById(id);
		jipiaoxinxi = jipiaoxinxiService.selectView(new EntityWrapper<JipiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", jipiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JipiaoxinxiEntity jipiaoxinxi = jipiaoxinxiService.selectById(id);
		jipiaoxinxi = jipiaoxinxiService.selectView(new EntityWrapper<JipiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", jipiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JipiaoxinxiEntity jipiaoxinxi, HttpServletRequest request){
    	jipiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jipiaoxinxi);
        jipiaoxinxiService.insert(jipiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JipiaoxinxiEntity jipiaoxinxi, HttpServletRequest request){
    	jipiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jipiaoxinxi);
        jipiaoxinxiService.insert(jipiaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JipiaoxinxiEntity jipiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jipiaoxinxi);
        jipiaoxinxiService.updateById(jipiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jipiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

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

import com.cl.entity.JipiaodinggouEntity;
import com.cl.entity.view.JipiaodinggouView;

import com.cl.service.JipiaodinggouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 机票订购
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/jipiaodinggou")
public class JipiaodinggouController {
    @Autowired
    private JipiaodinggouService jipiaodinggouService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JipiaodinggouEntity jipiaodinggou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jipiaodinggou.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JipiaodinggouEntity> ew = new EntityWrapper<JipiaodinggouEntity>();

		PageUtils page = jipiaodinggouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jipiaodinggou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JipiaodinggouEntity jipiaodinggou, 
		HttpServletRequest request){
        EntityWrapper<JipiaodinggouEntity> ew = new EntityWrapper<JipiaodinggouEntity>();

		PageUtils page = jipiaodinggouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jipiaodinggou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JipiaodinggouEntity jipiaodinggou){
       	EntityWrapper<JipiaodinggouEntity> ew = new EntityWrapper<JipiaodinggouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jipiaodinggou, "jipiaodinggou")); 
        return R.ok().put("data", jipiaodinggouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JipiaodinggouEntity jipiaodinggou){
        EntityWrapper< JipiaodinggouEntity> ew = new EntityWrapper< JipiaodinggouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jipiaodinggou, "jipiaodinggou")); 
		JipiaodinggouView jipiaodinggouView =  jipiaodinggouService.selectView(ew);
		return R.ok("查询机票订购成功").put("data", jipiaodinggouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JipiaodinggouEntity jipiaodinggou = jipiaodinggouService.selectById(id);
		jipiaodinggou = jipiaodinggouService.selectView(new EntityWrapper<JipiaodinggouEntity>().eq("id", id));
        return R.ok().put("data", jipiaodinggou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JipiaodinggouEntity jipiaodinggou = jipiaodinggouService.selectById(id);
		jipiaodinggou = jipiaodinggouService.selectView(new EntityWrapper<JipiaodinggouEntity>().eq("id", id));
        return R.ok().put("data", jipiaodinggou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JipiaodinggouEntity jipiaodinggou, HttpServletRequest request){
    	jipiaodinggou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jipiaodinggou);
        jipiaodinggouService.insert(jipiaodinggou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JipiaodinggouEntity jipiaodinggou, HttpServletRequest request){
    	jipiaodinggou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jipiaodinggou);
        jipiaodinggouService.insert(jipiaodinggou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JipiaodinggouEntity jipiaodinggou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jipiaodinggou);
        jipiaodinggouService.updateById(jipiaodinggou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jipiaodinggouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

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

import com.cl.entity.QichexinxiEntity;
import com.cl.entity.view.QichexinxiView;

import com.cl.service.QichexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/qichexinxi")
public class QichexinxiController {
    @Autowired
    private QichexinxiService qichexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QichexinxiEntity qichexinxi,
                @RequestParam(required = false) Double piaojiastart,
                @RequestParam(required = false) Double piaojiaend,
		HttpServletRequest request){
        EntityWrapper<QichexinxiEntity> ew = new EntityWrapper<QichexinxiEntity>();
                if(piaojiastart!=null) ew.ge("piaojia", piaojiastart);
                if(piaojiaend!=null) ew.le("piaojia", piaojiaend);

		PageUtils page = qichexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QichexinxiEntity qichexinxi, 
                @RequestParam(required = false) Double piaojiastart,
                @RequestParam(required = false) Double piaojiaend,
		HttpServletRequest request){
        EntityWrapper<QichexinxiEntity> ew = new EntityWrapper<QichexinxiEntity>();
                if(piaojiastart!=null) ew.ge("piaojia", piaojiastart);
                if(piaojiaend!=null) ew.le("piaojia", piaojiaend);

		PageUtils page = qichexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QichexinxiEntity qichexinxi){
       	EntityWrapper<QichexinxiEntity> ew = new EntityWrapper<QichexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qichexinxi, "qichexinxi")); 
        return R.ok().put("data", qichexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QichexinxiEntity qichexinxi){
        EntityWrapper< QichexinxiEntity> ew = new EntityWrapper< QichexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qichexinxi, "qichexinxi")); 
		QichexinxiView qichexinxiView =  qichexinxiService.selectView(ew);
		return R.ok("查询汽车信息成功").put("data", qichexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QichexinxiEntity qichexinxi = qichexinxiService.selectById(id);
		qichexinxi = qichexinxiService.selectView(new EntityWrapper<QichexinxiEntity>().eq("id", id));
        return R.ok().put("data", qichexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QichexinxiEntity qichexinxi = qichexinxiService.selectById(id);
		qichexinxi = qichexinxiService.selectView(new EntityWrapper<QichexinxiEntity>().eq("id", id));
        return R.ok().put("data", qichexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QichexinxiEntity qichexinxi, HttpServletRequest request){
    	qichexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichexinxi);
        qichexinxiService.insert(qichexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QichexinxiEntity qichexinxi, HttpServletRequest request){
    	qichexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichexinxi);
        qichexinxiService.insert(qichexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QichexinxiEntity qichexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qichexinxi);
        qichexinxiService.updateById(qichexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qichexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

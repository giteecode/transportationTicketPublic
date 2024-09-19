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

import com.cl.entity.QichedingpiaoEntity;
import com.cl.entity.view.QichedingpiaoView;

import com.cl.service.QichedingpiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车订票
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-23 17:23:55
 */
@RestController
@RequestMapping("/qichedingpiao")
public class QichedingpiaoController {
    @Autowired
    private QichedingpiaoService qichedingpiaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QichedingpiaoEntity qichedingpiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			qichedingpiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QichedingpiaoEntity> ew = new EntityWrapper<QichedingpiaoEntity>();

		PageUtils page = qichedingpiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichedingpiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QichedingpiaoEntity qichedingpiao, 
		HttpServletRequest request){
        EntityWrapper<QichedingpiaoEntity> ew = new EntityWrapper<QichedingpiaoEntity>();

		PageUtils page = qichedingpiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichedingpiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QichedingpiaoEntity qichedingpiao){
       	EntityWrapper<QichedingpiaoEntity> ew = new EntityWrapper<QichedingpiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qichedingpiao, "qichedingpiao")); 
        return R.ok().put("data", qichedingpiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QichedingpiaoEntity qichedingpiao){
        EntityWrapper< QichedingpiaoEntity> ew = new EntityWrapper< QichedingpiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qichedingpiao, "qichedingpiao")); 
		QichedingpiaoView qichedingpiaoView =  qichedingpiaoService.selectView(ew);
		return R.ok("查询汽车订票成功").put("data", qichedingpiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QichedingpiaoEntity qichedingpiao = qichedingpiaoService.selectById(id);
		qichedingpiao = qichedingpiaoService.selectView(new EntityWrapper<QichedingpiaoEntity>().eq("id", id));
        return R.ok().put("data", qichedingpiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QichedingpiaoEntity qichedingpiao = qichedingpiaoService.selectById(id);
		qichedingpiao = qichedingpiaoService.selectView(new EntityWrapper<QichedingpiaoEntity>().eq("id", id));
        return R.ok().put("data", qichedingpiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QichedingpiaoEntity qichedingpiao, HttpServletRequest request){
    	qichedingpiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichedingpiao);
        qichedingpiaoService.insert(qichedingpiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QichedingpiaoEntity qichedingpiao, HttpServletRequest request){
    	qichedingpiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qichedingpiao);
        qichedingpiaoService.insert(qichedingpiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QichedingpiaoEntity qichedingpiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qichedingpiao);
        qichedingpiaoService.updateById(qichedingpiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qichedingpiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

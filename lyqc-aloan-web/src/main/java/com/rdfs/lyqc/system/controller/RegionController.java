package com.rdfs.lyqc.system.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdfs.lyqc.cache.service.CacheRegionService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyRegion;


@Controller
@RequestMapping("region")
public class RegionController {

	private Logger logger = LoggerFactory.getLogger(RegionController.class);
	
	@Autowired
	private CacheRegionService cacheRegionDataService;
	
	/**
     * 加载城市和省份
     * @param request
     * @param response
     */
    @RequestMapping("loadPC")
    public void loadPC(HttpServletRequest request,HttpServletResponse response, SyRegion reg){
    	PrintWriter pw = null	;
    	try{
    		pw = response.getWriter();
    		List<SyRegion> regs = cacheRegionDataService.getCityList(reg.getRegCode());
    		pw.print(JacksonUtil.toJson(regs));
    	} catch(Exception e){
    		logger.error("加载失败,错误信息：",e);
    		pw.print("");
    	}
    }
}

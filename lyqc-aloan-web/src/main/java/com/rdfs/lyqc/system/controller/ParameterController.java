package com.rdfs.lyqc.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.core.bean.Page;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.cache.service.CacheMasterService;
import com.rdfs.lyqc.system.entity.SyParameter;
import com.rdfs.lyqc.system.service.ParameterService;

@Controller
@RequestMapping("param")
public class ParameterController {
	
    @Autowired
    private ParameterService parameterService;
    
    @Autowired
    private CacheMasterService cacheMasterService;
    
    private Logger logger = LoggerFactory.getLogger(ParameterController.class);
    
    @RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, SyParameter param){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = parameterService.pageList(param, AuthUtil.getPage(request), OperMode.LIKE, "name","key");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, SyParameter param){
    	try{
    		param = parameterService.getEntityById(SyParameter.class, param.getId(), true);
    		request.setAttribute("parameter", param);
    	} catch(Exception e){
    		logger.error("进入参数编辑页面失败,",e);
    	}
    	return "system/param/add";
    }
    
    @RequestMapping("save")
    public String save(HttpServletRequest request, SyParameter param){
    	try{
    		param = parameterService.saveParameter(param);
    		cacheMasterService.cacheParamOption(param.getKey(), param.getValue());
    		request.setAttribute("msg", "保存成功!");
    	} catch(Exception e){
    		request.setAttribute("msg", "保存失败"+e.getMessage());
    		request.setAttribute("parameter", param);
    		logger.error("保存参数失败,",e);
    		return "system/param/add";
    	}
    	return "system/param/list";
    }
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, SyParameter param){
    	try{
    		parameterService.deleteEntity(param);
    		request.setAttribute("msg", "删除成功.");
    	} catch(Exception e){
    		request.setAttribute("msg", "删除失败,"+e.getMessage());
    		logger.error("删除参数失败,",e);
    	}
    	return "system/param/list";
    }
}

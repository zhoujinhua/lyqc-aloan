package com.rdfs.lyqc.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.core.bean.Page;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.cache.service.CacheMasterService;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.service.DictItemService;


@Controller
@RequestMapping("dict")
public class DictController {
	
    @Autowired
    private DictItemService dictItemService;
    
    @Autowired
    private CacheMasterService cacheMasterService;
    
    private Logger logger = LoggerFactory.getLogger(DictController.class);
    
    @RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, SyDictItem arg){
		int length = ServletRequestUtils.getIntParameter(request, "length", 10);
		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		int pn = start == 0?1:(start/length+1);
		Map<String, Object> map = new HashMap<String,Object>();
		Page<SyDictItem> page = dictItemService.pageList(arg, pn, OperMode.LIKE, "name","code","status","key");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
    
    @RequestMapping("save")
    public String saveArgControl(HttpServletRequest request, SyDictItem dictItem) {
    	try{
    		dictItem = dictItemService.saveDictItem(dictItem);
    		cacheMasterService.cacheDict(dictItem);
    		request.setAttribute("msg", "操作成功");
    	} catch(Exception e){
    		logger.error("保存失败,错误信息：",e);
    		request.setAttribute("dict", dictItem);
    		request.setAttribute("msg", "操作失败,"+e.getMessage());
    		return "param/dict/add";
    	}
    	return "system/dict/list";
    }
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, SyDictItem dictItem) {
    	dictItem = dictItemService.getEntityById(SyDictItem.class, dictItem.getId(), true);
    	request.setAttribute("dict", dictItem);
    	return "system/dict/add";
    }
    
    @RequestMapping("delete")
    public String deleteArgControls(HttpServletRequest request, SyDictItem dictItem) {
    	try{
    		dictItemService.deleteEntity(dictItem);
    		request.setAttribute("msg", "操作成功");
    	} catch(Exception e){
    		logger.error("停用/启用失败,错误信息：",e);
    		request.setAttribute("msg", "操作失败,"+e.getMessage());
    	}
    	return "system/dict/list";
    }
    
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, SyDictItem dictItem) {
    	dictItem = dictItemService.getEntityById(SyDictItem.class, dictItem.getId(), true);

    	request.setAttribute("dict", dictItem);
    	return "system/dict/detail";
    }
    
}

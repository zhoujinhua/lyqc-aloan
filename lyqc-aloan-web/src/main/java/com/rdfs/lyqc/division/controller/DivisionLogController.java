package com.rdfs.lyqc.division.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.utils.PageUtil;
import com.rdfs.lyqc.division.entity.DhDivisionLog;
import com.rdfs.lyqc.division.service.DivisionLogService;

@Controller
@RequestMapping("divisionLog")
public class DivisionLogController {

	@Autowired
	private DivisionLogService divisionLogService ;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhDivisionLog log){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = divisionLogService.pageList(log, PageUtil.getPage(request));
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
}

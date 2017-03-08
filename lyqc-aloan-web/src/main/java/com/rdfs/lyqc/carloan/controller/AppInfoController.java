package com.rdfs.lyqc.carloan.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.core.bean.Page;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.hibernate.enums.OrderMode;
import com.rdfs.lyqc.carloan.entity.DmAppAnnex;
import com.rdfs.lyqc.carloan.entity.DmAppApproval;
import com.rdfs.lyqc.carloan.entity.vo.VAppInfo;
import com.rdfs.lyqc.carloan.service.AppInfoService;

@Controller
@RequestMapping("appInfo")
public class AppInfoController {

	@Autowired
	private AppInfoService appInfoService;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, VAppInfo appInfo){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(appInfo, AuthUtil.getPage(request), OperMode.LIKE, "appCode","proppserName",
				"idType","idno","mobile","liveProvince","liveCity","overdueRange","isCurrOverdue","overdueStatus","collPhoneOperator");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("approvalList")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DmAppApproval approval){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(approval, AuthUtil.getPage(request), OrderMode.DESC, "approvalTime", OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("annexList")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DmAppAnnex annex){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(annex, AuthUtil.getPage(request), OperMode.LIKE, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
}

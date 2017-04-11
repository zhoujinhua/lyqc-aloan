package com.rdfs.lyqc.dianc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.framework.core.utils.ReturnUitl;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.enums.OperMode;
import com.rdfs.framework.hibernate.enums.OrderMode;
import com.rdfs.framework.hibernate.utils.PageUtil;
import com.rdfs.lyqc.carloan.entity.DmAppInfo;
import com.rdfs.lyqc.carloan.entity.vo.VAppInfo;
import com.rdfs.lyqc.carloan.service.AppInfoService;
import com.rdfs.lyqc.dianc.entity.DhCollectionReg;
import com.rdfs.lyqc.dianc.service.CollectionRegService;

@Controller
@RequestMapping("dianc")
public class DianCuiController {

	@Autowired
	private CollectionRegService collectionRegService;
	
	@Autowired
	private AppInfoService appInfoService;
	
	private Logger logger = LoggerFactory.getLogger(DianCuiController.class);
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhCollectionReg reg){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = collectionRegService.pageList(reg, PageUtil.getPage(request), OrderMode.DESC, "remarkTime", OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, DmAppInfo appInfo){
		appInfo = appInfoService.getEntityByCode(DmAppInfo.class, appInfo.getAppCode(), true);
		request.setAttribute("appInfo", appInfo);
		return "dianc/info/detail";
	}
	
	@RequestMapping("regDetail")
	public String regDetail(HttpServletRequest request, DmAppInfo appInfo){
		appInfo = appInfoService.getEntityByCode(DmAppInfo.class, appInfo.getAppCode(), true);
		request.setAttribute("appInfo", appInfo);
		return "dianc/reg/detail";
	}
	
	@RequestMapping("addReg")
	public String addReg(HttpServletRequest request, VAppInfo appInfo){
		appInfo = appInfoService.getEntityByCode(VAppInfo.class, appInfo.getAppCode(), true);
		request.setAttribute("vAppInfo", appInfo);
		return "dianc/reg/add";
	}
	
	@RequestMapping("saveReg")
	public void saveReg(HttpServletRequest request, HttpServletResponse response, DhCollectionReg reg){
		try{
			collectionRegService.saveReg(reg);
			ReturnUitl.write(response, 1);
		} catch(Exception e){
			ReturnUitl.write(response, 0, "保存催收登记信息失败,"+e.getMessage());
			logger.error("保存催收登记信息失败,", e);
		}
	}
}

package com.rdfs.lyqc.shouc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdfs.framework.core.utils.ReturnUitl;
import com.rdfs.lyqc.carloan.entity.vo.VAppInfo;
import com.rdfs.lyqc.carloan.service.AppInfoService;
import com.rdfs.lyqc.shouc.entity.DhClocarReg;
import com.rdfs.lyqc.shouc.service.ClocarRegService;

@Controller
@RequestMapping("shouc")
public class ShouCheController {

	@Autowired
	private ClocarRegService clocarRegService;
	
	@Autowired
	private AppInfoService appInfoService;
	
	private Logger logger = LoggerFactory.getLogger(ShouCheController.class);
	
	@RequestMapping("addReg")
	public String addReg(HttpServletRequest request, VAppInfo appInfo){
		appInfo = appInfoService.getEntityByCode(VAppInfo.class, appInfo.getAppCode(), true);
		request.setAttribute("vAppInfo", appInfo);
		return "dianc/reg/add";
	}
	
	@RequestMapping("saveReg")
	public void saveReg(HttpServletRequest request, HttpServletResponse response, DhClocarReg reg){
		try{
			clocarRegService.saveReg(reg);
			ReturnUitl.write(response, 1);
		} catch(Exception e){
			ReturnUitl.write(response, 0, "保存催收登记信息失败,"+e.getMessage());
			logger.error("保存催收登记信息失败,", e);
		}
	}
}

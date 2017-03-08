package com.rdfs.lyqc.dianc.controller;

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
import com.rdfs.lyqc.dianc.entity.DhCollectionReg;
import com.rdfs.lyqc.dianc.service.CollectionRegService;

@Controller
@RequestMapping("dianc")
public class DianCuiController {

	@Autowired
	private CollectionRegService collectionRegService;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhCollectionReg reg){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = collectionRegService.pageList(reg, AuthUtil.getPage(request), OrderMode.DESC, "remarkTime", OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
	
	
}

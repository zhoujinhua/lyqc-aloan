package com.rdfs.lyqc.fin.controller;

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
import com.rdfs.lyqc.fin.entity.DmFinRepayment;
import com.rdfs.lyqc.fin.service.FinRepaymentService;

@Controller
@RequestMapping("fin")
public class FianceController {

	@Autowired
	private FinRepaymentService finRepaymentService;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DmFinRepayment repayment){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = finRepaymentService.pageList(repayment, AuthUtil.getPage(request), OrderMode.DESC, "paymentDate", OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
}
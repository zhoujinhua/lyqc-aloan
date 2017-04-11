package com.rdfs.lyqc.division.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdfs.lyqc.division.service.DivisionRuleService;

@Controller
@RequestMapping("oper")
public class OperDivisionController {

	@Autowired
	private DivisionRuleService divisionRuleService;
	
	private Logger logger = LoggerFactory.getLogger(OperDivisionController.class);
	
	@RequestMapping("setOper")
	public String setOper(HttpServletRequest request, String userId, String appCodes){
		try{
			divisionRuleService.updateUserSet(userId, appCodes);
			request.setAttribute("msg", "指派催收员成功!");
		}catch(Exception e){
			request.setAttribute("msg", "指派催收员失败,"+e.getMessage());
			logger.error("指派催收员失败,",e);
		}
		return "division/oper/list";
	}
}

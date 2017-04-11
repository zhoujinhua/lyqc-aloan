package com.rdfs.lyqc.division.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.core.utils.JacksonUtil;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.enums.OperMode;
import com.rdfs.framework.hibernate.enums.OrderMode;
import com.rdfs.framework.hibernate.utils.PageUtil;
import com.rdfs.lyqc.division.entity.DhDivisionRule;
import com.rdfs.lyqc.division.service.DivisionRuleService;
import com.rdfs.lyqc.division.utils.DivisionUtil;

/**
 * 分单规则
 * @author zhoufei
 *
 */

@Controller
@RequestMapping("division")
public class AutoDivisionController {

	@Autowired
	private DivisionRuleService divisionRuleService;
	
	private Logger logger = LoggerFactory.getLogger(AutoDivisionController.class);
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhDivisionRule rule){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = divisionRuleService.pageList(rule, PageUtil.getPage(request), OrderMode.DESC, "createTime", OperMode.LIKE, "name", "status");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, DhDivisionRule rule){
		try{
			divisionRuleService.saveRule(rule);
			request.setAttribute("msg", "保存分件规则成功!");
		}catch(Exception e){
			request.setAttribute("msg", "保存分件规则失败,"+e.getMessage());
			logger.error("保存分件规则失败,",e);
			request.setAttribute("rule", rule);
			return "division/auto/add";
		}
		return "division/auto/list";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, DhDivisionRule rule){
		rule = divisionRuleService.getInitRule(rule);
		request.setAttribute("rule", rule);
		return "division/auto/add";
	}
	
	@RequestMapping("userTree")
	public void userTree(HttpServletRequest request, HttpServletResponse response, DhDivisionRule rule){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			List<TreeDto> list = divisionRuleService.formatUserTree(rule);
			pw.print(JacksonUtil.toJson(list));
		} catch(Exception e){
			logger.error("加载失败,错误信息：",e);
		}
	}
	
	@RequestMapping("setUser")
	public String setUser(HttpServletRequest request, DhDivisionRule rule){
		try{
			String ids = request.getParameter("ids");
			divisionRuleService.updateUserSet(rule, ids.split(","));
			request.setAttribute("msg", "催收员设置成功!");
		}catch(Exception e){
			logger.error("任务失败,错误信息：",e);
			request.setAttribute("msg", "催收员设置失败,"+e.getMessage());
		}
		return "division/auto/list";
	}
	
	@RequestMapping("run")
	public String run(HttpServletRequest request, DhDivisionRule rule){
		try{
			rule = divisionRuleService.getInitRule(rule);
			DivisionUtil.runSingle(rule);
			request.setAttribute("msg", "调用成功!");
		}catch(Exception e){
			request.setAttribute("msg", "调用失败,"+e.getMessage());
			logger.error("调用分担任务失败,",e);
		}
		return "division/auto/list";
	}
}

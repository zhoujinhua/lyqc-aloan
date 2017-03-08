package com.rdfs.lyqc.system.controller;

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

import com.rdfs.core.bean.Page;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyDepartment;
import com.rdfs.lyqc.system.service.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, SyDepartment department){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = departmentService.pageList(department, AuthUtil.getPage(request), OperMode.LIKE, "departmentName","status");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());	
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SyDepartment department){
		department = departmentService.getEntityById(SyDepartment.class, department.getDepartmentId(), true);
		
		request.setAttribute("department", department);
		return "system/department/add";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, SyDepartment department){
		try {
			departmentService.saveDepartment(department);
			request.setAttribute("msg","操作成功!");
		} catch(Exception e){
			logger.error("操作失败,错误信息：",e);
			request.setAttribute("msg","操作失败,"+e.getMessage());
			request.setAttribute("department", department);
			return "system/department/add";
		}
		return "system/department/list";
	}
	
	@RequestMapping("view")
	public String view(HttpServletRequest request,HttpServletResponse response,SyDepartment department){
		department = departmentService.getEntityById(SyDepartment.class, department.getDepartmentId(), true);
		
		request.setAttribute("department", department);
		return "system/department/view";
	}
	
	@RequestMapping("deptTree")
	public void deptTree(HttpServletRequest request, HttpServletResponse response){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			List<TreeDto> treeList = departmentService.genDeptTree();
			pw.write(JacksonUtil.toJson(treeList));
		}catch(Exception e){
			logger.error("生成部门树失败,",e);
		}
	}
}

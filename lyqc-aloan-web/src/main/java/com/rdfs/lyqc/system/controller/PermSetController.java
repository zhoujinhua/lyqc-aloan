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
import com.rdfs.core.bean.UserDto;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyPermSet;
import com.rdfs.lyqc.system.service.PermSetService;


@Controller
@RequestMapping("permset")
public class PermSetController {

	@Autowired
	private PermSetService permSetService;
	
	private Logger logger = LoggerFactory.getLogger(PermSetController.class);
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, SyPermSet permSet){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = permSetService.pageList(permSet, AuthUtil.getPage(request), OperMode.LIKE, "permName","permStatus");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, SyPermSet permSet){
		permSet = permSetService.getEntityById(SyPermSet.class,permSet.getId(),true);
		request.setAttribute("permSet", permSet);
		
		return "system/permset/add";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, SyPermSet permSet){
		try{
			UserDto user = AuthUtil.getUserDto(request);
			
			permSetService.savePermSet(permSet, user);
			request.setAttribute("msg", "保存成功!");
		} catch(Exception e){
			logger.error("保存失败,错误信息：",e);
			request.setAttribute("msg","保存失败,"+e.getMessage());
			request.setAttribute("permSet", permSet);
			return "system/permset/add";
		}
		return "system/permset/list";
	}
	
	@RequestMapping("view")
	public String view(HttpServletRequest request,HttpServletResponse response,SyPermSet permSet){
		permSet = permSetService.getEntityById(SyPermSet.class,permSet.getId(),true);
		request.setAttribute("permSet", permSet);
		
		return "system/permset/view";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, SyPermSet permSet){
		try{
			permSetService.deleteEntity(permSet);
			request.setAttribute("msg", "删除成功!");
		} catch(Exception e){
			logger.error("删除失败,错误信息：",e);
			request.setAttribute("msg","删除失败,"+e.getMessage());
		}
		return "system/permset/list";
	}
	
	@RequestMapping("setItem")
	public String setItem(HttpServletRequest request, SyPermSet permSet){
		try{
			String ids = request.getParameter("ids");
			if(ids==null || "".equals(ids)){
				throw new RuntimeException("请务必设置权限集对应菜单.");
			}
			permSetService.updatePermSet(permSet,ids.split(","));
			request.setAttribute("msg", "权限集菜单设置成功!");
		}catch(Exception e){
			logger.error("任务失败,错误信息：",e);
			request.setAttribute("msg", "权限集菜单设置失败,"+e.getMessage());
		}
		return "system/permset/list";
	}
	
	@RequestMapping("viewMenuTree")
	public void viewMenuTree(HttpServletRequest request,HttpServletResponse response,SyPermSet permSet){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			
			List<TreeDto> list = permSetService.getMenuTree(permSet);
			pw.print(JacksonUtil.toJson(list));
		}catch(Exception e){
			logger.error("任务失败,错误信息：",e);
		}
	}
	
	/**
	 * 用户登录后加载菜单
	 */
	@RequestMapping("getMenuJson")
	public void getMenuJson(HttpServletRequest request,HttpServletResponse response){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			UserDto userDto = AuthUtil.getUserDto(request);
			String jsonArray = permSetService.getUserMenuTree(userDto);
			pw.print(jsonArray);
		} catch(Exception e){
			logger.error("任务失败,错误信息：",e);
		}
	}
}

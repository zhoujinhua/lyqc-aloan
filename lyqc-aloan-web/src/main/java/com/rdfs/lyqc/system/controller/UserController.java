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

import com.rdfs.framework.auth.entity.SyPermSet;
import com.rdfs.framework.cache.service.CacheResourceService;
import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.core.bean.UserDto;
import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.utils.AuthUtil;
import com.rdfs.framework.core.utils.JacksonUtil;
import com.rdfs.framework.core.utils.JsonUtil;
import com.rdfs.framework.core.utils.RdfsUtils;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.enums.OperMode;
import com.rdfs.framework.hibernate.utils.PageUtil;
import com.rdfs.lyqc.cache.service.CacheUserService;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheUserService cacheUserDataService;
	
	@Autowired
	private CacheResourceService cacheResourceService;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request ,SyUser user){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = userService.pageList(user, PageUtil.getPage(request), OperMode.LIKE, "userStatus","userName","trueName","userType");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, SyUser user) {
		try {
			userService.saveUser(user);
			request.setAttribute("msg", "保存成功");
		} catch (Exception e) {
			logger.error("用户保存失败.",e);
			request.setAttribute("msg", e.getMessage());
			
			request.setAttribute("user", user);
			return "system/user/add";
		}
		return "system/user/list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, SyUser user) {
		try {
			userService.updateUser(user );
			request.setAttribute("msg", "保存成功");
		} catch (Exception e) {
			logger.error("用户更新失败.",e);
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			return "system/user/add";
		}
		return "system/user/list";
	}
	
	@RequestMapping("initPwd")
	public String initPwd(HttpServletRequest request, SyUser user) {
		try {
			userService.updateUserPassword(user);
			request.setAttribute("msg", "用户重置密码成功!");
		} catch (Exception e) {
			logger.error("用户密码重置失败.",e);
			request.setAttribute("msg", "用户重置密码失败," + e.getMessage());
		}
		return "system/user/list";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request, SyUser user) {
		try {
			user.setUserStatus(Constants.IS.NO);
			userService.updateEntity(user, "userStatus");
			request.setAttribute("msg", "用户停用成功!");
		} catch (Exception e) {
			logger.error("用户停用失败.",e);
			request.setAttribute("msg", "用户停用失败," + e.getMessage());
		}
		return "system/user/list";
	}
	
	@RequestMapping("activate")
	public String activate(HttpServletRequest request, SyUser user) {
		try {
			user.setUserStatus(Constants.IS.YES);
			this.userService.updateEntity(user, "userStatus");
			request.setAttribute("msg", "用户激活成功!");
		} catch (Exception e) {
			logger.error("用户激活失败.",e);
			request.setAttribute("msg", "用户激活失败," + e.getMessage());
		}
		return "system/user/list";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, SyUser user) {
		user = userService.getEntityByCode(SyUser.class,user.getUserId(),true);
		request.setAttribute("user", user);
		return "system/user/add";
	}
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, SyUser user) {
		UserDto userDto = AuthUtil.getUserDto(request);
		user = userService.getEntityByCode(SyUser.class, userDto.getUserId(), false);
		request.setAttribute("user", user);
		return "system/user/modify";
	}
	@RequestMapping("saveModify")
	public String saveModify(HttpServletRequest request, SyUser user) {
		try{
			userService.updateEntity(user, "address","trueName","sex","phone","email","cardType","cardId","postalCode");
			user = userService.getEntityByCode(SyUser.class, user.getUserId(), true);
			
			UserDto userDto = AuthUtil.getUserDto(request);
			RdfsUtils.copyProperties(user, userDto);
			cacheUserDataService.resetUserDto(userDto.getJuid());
			cacheUserDataService.cacheUserDto(userDto);
			
			request.setAttribute("msg", "修改成功!");
		} catch(Exception e){
			request.setAttribute("msg", "修改失败,请联系管理员,"+e.getMessage());
		}
		request.setAttribute("user", user);
		return "system/user/modify";
	}
	
	@RequestMapping("detail")
	public String view(HttpServletRequest request, SyUser user) {
		user = userService.getEntityByCode(SyUser.class,user.getUserId(),true);
		request.setAttribute("user", user);
		return "system/user/detail";
	}
	
	@RequestMapping("viewPermSetTree")
	public void viewPermSetTree(HttpServletRequest request, HttpServletResponse response, SyUser user) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			
			List<TreeDto> list = userService.getPermSetTree(user);
			pw.print(JacksonUtil.toJson(list));
		} catch (Exception e) {
			logger.error("生成权限集树失败.",e);
		}
	}
	
	@RequestMapping("setPermSet")
	public String setPermSet(HttpServletRequest request, HttpServletResponse response, SyUser user) {
		try {
			String ids = request.getParameter("ids");
			String[] permIds = ids.split(",");
			userService.updateSyUserPermSets(user, permIds);
			request.setAttribute("msg","权限集设置成功!");
		} catch (Exception e) {
			logger.error("用户设置权限集失败.",e);
			request.setAttribute("msg","权限集设置失败,"+e.getMessage());
		}
		return "system/user/list";
	}
	
	/**
	 * 用户登录后加载菜单
	 */
	@RequestMapping("getMenuJson")
	public void getMenuJson(HttpServletRequest request, HttpServletResponse response){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();

			UserDto userDto = AuthUtil.getUserDto(request);
			SyUser user = userService.getEntityByCode(SyUser.class, userDto.getUserId(), true);
			List<SyPermSet> list = user.getPermSets();
			Object ob = cacheResourceService.getMenuTree(list);
			pw.print(JsonUtil.toJson(ob));
		} catch(Exception e){
			logger.error("任务失败,错误信息：",e);
		}
	}
}

package com.rdfs.lyqc.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.core.utils.RdfsId;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.lyqc.cache.service.CacheUserService;
import com.rdfs.lyqc.common.utils.Md5Util;
import com.rdfs.lyqc.common.utils.ReturnUitl;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheUserService cacheUserDataService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, SyUser user){
		HttpSession session = request.getSession();
		String password = user.getPassword();
		
		String yzm = user.getRandcode();
		String randCode = (String) session.getAttribute("randomCode");
		if(!yzm.equals(randCode)){
			session.setAttribute("msg", "验证码输入有误,请重新输入!");
			return "redirect:/";
		}
		
		//根据用户名查询
		SyUser syUser = null;
		List<SyUser> list = userService.getList(user, "userName");
		if(list == null || list.isEmpty()){
			session.setAttribute("msg", "此用户不存在");
			return "redirect:/";
		}else{
			syUser = list.get(0);
			 String status = syUser.getUserStatus();
			 if(!status.equals(Constants.IS.YES)){  //未生效
				 session.setAttribute("msg", "该用户未生效.");
				 return "redirect:/";
			 }else{  //密码校验
				 String pwd = syUser.getPassword();
				 if(!(pwd).equals(Md5Util.getMD5Str(password))){
					 
					 session.setAttribute("msg", "用户名或者密码错误");
					 return "redirect:/";
				 }
				 
				 String juid = RdfsId.uuid();
				 UserDto userDto = new UserDto();
				 RdfsUtils.copyProperties(syUser, userDto);
				 userDto.setJuid(juid);
				 userDto.setLoginTime(RdfsUtils.getDateTimeStr());
				 userDto.setClientIp(AuthUtil.getClientIpAddr(request));
				 userDto.setClientKey(request.getHeader("USER-AGENT"));
				 cacheUserDataService.cacheUserDto(userDto);
				 
				 return "redirect:view/index.jsp?juid="+juid;
			 }
		}
	}
	
	/**
	 * 登陆验证码校验
	 * @param request
	 * @param model
	 */
	@RequestMapping("checkYZM")
	public void checkYZM(HttpServletRequest request, HttpServletResponse response, Model model){
		String yzm = request.getParameter("yzm");
		HttpSession session = request.getSession();
		String randCode = (String) session.getAttribute("randomCode");
		if(yzm.equals(randCode)){
			ReturnUitl.write(response, 0);  //成功
		}else{
			ReturnUitl.write(response, 1);  //失败
		}
	}
	
	/**
	 * 修改密码时,校验旧密码
	 * @param request
	 * @param response
	 */
	@RequestMapping("vilidatePwd")
	public void vilidatePwd(HttpServletRequest request, HttpServletResponse response){
		String oldPwd = request.getParameter("oldPwd");
		UserDto user = AuthUtil.getUserDto(request);
		String pwd = user.getPassword();
		if(Md5Util.getMD5Str(oldPwd).equals(pwd)){
			ReturnUitl.write(response, 0);  //成功
		}else{
			ReturnUitl.write(response, 1);  //失败
		}
	}
	
	/**
	 * 密码修改
	 *data: {'oldPwd':oldPwd,'newPwd':newPwd,'confirmPwd':confirmPwd}
	 * @param request
	 * @param response
	 */
	@RequestMapping("modifyPwd")
	public void modifyPwd(HttpServletRequest request, HttpServletResponse response){
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String confirmPwd = request.getParameter("confirmPwd");
		HttpSession session = request.getSession();
		String resopnseMsg = "未知错误";
		if(oldPwd == null || newPwd == null || confirmPwd == null || 
				("").equals(oldPwd.trim()) || ("").equals(newPwd.trim()) || ("").equals(confirmPwd.trim())){
			resopnseMsg = "数据不完整,修改失败!";
			ReturnUitl.write(response, 1, resopnseMsg); // 数据不完整,修改失败
			return;
		}
		UserDto user = AuthUtil.getUserDto(request);
		String pwd = user.getPassword();
		if(!Md5Util.getMD5Str(oldPwd).equals(pwd)){
			resopnseMsg = "原密码错误!";
			ReturnUitl.write(response, 2, resopnseMsg);  //原始密码错误
			return;
		}
		
		if(!newPwd.equals(confirmPwd)){
			resopnseMsg = "两次输入密码不相等!";
			ReturnUitl.write(response, 3, resopnseMsg);  //两次输入密码不相等
			return;
		}
		
		
		//根据用户名查询
		SyUser syUser = new SyUser();
		RdfsUtils.copyProperties(user, syUser);
		syUser = userService.getList(syUser, "userName").get(0);
		syUser.setPassword(Md5Util.getMD5Str(newPwd));
		userService.updateEntity(syUser ,"password");
		resopnseMsg = "["+syUser.getUserName()+"] 用户,您修改的新密码是:"+newPwd+",请牢记!点击[确定]跳转至登陆页面";
		
		//注销session,重新登录
		session.invalidate();
		ReturnUitl.write(response, 0, resopnseMsg);  //密码修改成功
	}
	
	/**
	 * 退出系统
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		UserDto user = AuthUtil.getUserDto(request);
		if(user!=null && user.getJuid()!=null && !"".equals(user.getJuid())){
			cacheUserDataService.resetUserDto(user.getJuid());
		}
		session.invalidate();
		return "redirect:/";
	}
	
}

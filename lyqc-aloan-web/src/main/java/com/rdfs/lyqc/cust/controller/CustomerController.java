package com.rdfs.lyqc.cust.controller;

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
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.carloan.entity.DmAppInfo;
import com.rdfs.lyqc.carloan.entity.vo.VAppInfo;
import com.rdfs.lyqc.carloan.service.AppInfoService;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.common.utils.ReturnUitl;
import com.rdfs.lyqc.cust.entity.DhContactAddr;
import com.rdfs.lyqc.cust.entity.DhContactPhone;
import com.rdfs.lyqc.cust.entity.DhPhoneRemark;
import com.rdfs.lyqc.cust.service.ContactPhoneService;
import com.rdfs.lyqc.cust.service.PhoneRemarkService;

@Controller
@RequestMapping("cust")
public class CustomerController {

	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private ContactPhoneService contactPhoneService;
	@Autowired
	private PhoneRemarkService phoneRemarkService;
	private Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, DmAppInfo appInfo){
		appInfo = appInfoService.getEntityByCode(DmAppInfo.class, appInfo.getAppCode(), true);
		request.setAttribute("appInfo", appInfo);
		return "cust/detail";
	}
	
	@RequestMapping("phoneList")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhContactPhone phone){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(phone, AuthUtil.getPage(request), OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("addrList")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhContactAddr addr){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(addr, AuthUtil.getPage(request), OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
	
	@RequestMapping("remarkList")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, DhPhoneRemark remark){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = appInfoService.pageList(remark, AuthUtil.getPage(request), OperMode.EQ, "appCode");
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
		map.put("recordsFiltered", page.getCount());
		
		return map;
	}
	
	@RequestMapping("custTree")
	public void custTree(HttpServletRequest request, HttpServletResponse response, DhContactPhone phone){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			List<TreeDto> list = contactPhoneService.formatCustTree(phone);
			pw.print(JacksonUtil.toJson(list));
		} catch(Exception e){
			logger.error("加载失败,错误信息：",e);
		}
	}
	
	@RequestMapping("addRemark")
	public String addRemark(HttpServletRequest request, DhContactPhone phone){
		if(!StringUtils.isBlank(phone.getAppCode())){
			VAppInfo appInfo = contactPhoneService.getEntityByCode(VAppInfo.class, phone.getAppCode(), true);
			request.setAttribute("vAppInfo", appInfo);
		}
		if(phone.getId() == null){
			request.setAttribute("phone", phone);
		} else {
			DhContactPhone contactPhone = contactPhoneService.getEntityById(DhContactPhone.class, phone.getId(), true);
			request.setAttribute("phone", contactPhone);
		}
		
		return "cust/remark/remark";
	}
	
	@RequestMapping("saveRemark")
	public void saveRemark(HttpServletRequest request, HttpServletResponse response, DhPhoneRemark remark, DhContactAddr addr){
		try{
			phoneRemarkService.savePhoneRemark(remark, addr);
			ReturnUitl.write(response, 1);
		} catch(Exception e){
			logger.error("加载失败,错误信息：",e);
			ReturnUitl.write(response, 0, "保存失败,"+e.getMessage());
		}
	}
}

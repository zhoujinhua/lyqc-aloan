package com.rdfs.lyqc.dealer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdfs.core.bean.Page;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.lyqc.cache.service.CacheDealerService;
import com.rdfs.lyqc.common.utils.ReturnUitl;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;
import com.rdfs.lyqc.dealer.service.DealerCompanyService;

@Controller
@RequestMapping("dealercompany")
public class DealerCompanyController{

	private Logger logger = LoggerFactory.getLogger(DealerCompanyController.class);
	
    @Autowired
    private DealerCompanyService dealerCompanyService;
    
    @Autowired
    private CacheDealerService cacheDealerDataService;
    
    @RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request ,SyDealerCompany company){
		int length = ServletRequestUtils.getIntParameter(request, "length", 10);
		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		int pn = start == 0?1:(start/length+1);
		
		Map<String, Object> map = new HashMap<String,Object>();
		Page<SyDealerCompany> page = dealerCompanyService.pageList(company, pn, OperMode.LIKE, "companyCode","companyName");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
    
    @RequestMapping("listDC")
	@ResponseBody
	public Map<String,Object> listOnline(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();
		
		List<SyDealerCompany> vBeans = cacheDealerDataService.getDealerCompanyList();
		map.put("aaData", vBeans);
	    return map;
	}
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request ,SyDealerCompany company){
		try {
    		company = dealerCompanyService.getEntityById(SyDealerCompany.class, company.getCompanyCode(), true);
			request.setAttribute("dc", company);
		} catch (Exception e) {
			logger.error("执行编辑经销商单位信息失败,",e);
		}  
    	return "dealer/company/add";
    }
    
    @RequestMapping("save")
    public String save(HttpServletRequest request, SyDealerCompany company){
    	try{
			dealerCompanyService.saveDealerCompany(company);
    		request.setAttribute("msg", "保存成功.");
    	} catch(Exception e){
    		logger.error("保存经销商单位信息失败,",e);
    		company.setCompanyCode(null);
    		request.setAttribute("dc", company);
    		return "dealer/company/add";
    	}
    	return "dealer/company/list";
    }
    
    @RequestMapping("update")
    public String update(HttpServletRequest request, SyDealerCompany company){
    	try{
			dealerCompanyService.updateDealerCompany(company);
    		request.setAttribute("msg", "保存成功.");
    	} catch(Exception e){
    		logger.error("保存经销商单位信息失败,",e);
    		request.setAttribute("dc", company);
    		return "dealer/company/add";
    	}
    	return "dealer/company/list";
    }
    
    @RequestMapping("view")
    public String view(HttpServletRequest request, SyDealerCompany company){
    	try {
			company = dealerCompanyService.getEntityById(SyDealerCompany.class, company.getCompanyCode(), true);
			request.setAttribute("dc", company);
		} catch (Exception e) {
			logger.error("任务失败,错误信息：",e);
			e.printStackTrace();
		} 
    	return "dealer/company/view";
    }
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, SyDealerCompany company){
    	try{
    		dealerCompanyService.deleteEntity(company);
    		request.setAttribute("msg", "删除成功！");
    	} catch (Exception e) {
    		logger.error("任务失败,错误信息：",e);
    		request.setAttribute("msg", "删除失败,！"+e.getMessage());
    	}
    	return "dealer/company/list";
    }
    
    @RequestMapping("check")
    public void check(HttpServletRequest request, HttpServletResponse response, SyDealerCompany company){
		company = dealerCompanyService.getEntityById(SyDealerCompany.class, company.getCompanyCode(), false);
		if(company!=null){
			ReturnUitl.write(response, 0, "经销商代码重复.");
		} else {
			ReturnUitl.write(response, 1);
		}
    }
}

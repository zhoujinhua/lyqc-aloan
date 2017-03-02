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
import com.rdfs.lyqc.dealer.entity.SyDealer;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;
import com.rdfs.lyqc.dealer.service.DealerService;

@Controller
@RequestMapping("dealer")
public class DealerController {
	
	private Logger logger = LoggerFactory.getLogger(DealerController.class);
	
    @Autowired
    private DealerService dealerService;
    
    @Autowired
    private CacheDealerService cacheDealerDataService;
    
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request ,SyDealer dealer, SyDealerCompany company){
		int length = ServletRequestUtils.getIntParameter(request, "length", 10);
		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		int pn = start == 0?1:(start/length+1);
		dealer.setCompany(company);
		
		Map<String, Object> map = new HashMap<String,Object>();
		Page<SyDealer> page = dealerService.pageList(dealer, pn, OperMode.LIKE, "dealerCode","dealerName","company.companyCode","company.companyName","status");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("listDC")
	@ResponseBody
	public Map<String,Object> listDC(HttpServletRequest request ){
		Map<String, Object> map = new HashMap<String,Object>();
		
		List<SyDealer> list = cacheDealerDataService.getDealerList();
		map.put("aaData", list);
	    return map;
	}
	
	/**
	 * by User
	 * @param request
	 * @return
	 */
	@RequestMapping("listBU")
	@ResponseBody
	public Map<String,Object> listBU(HttpServletRequest request ){
		Map<String, Object> map = new HashMap<String,Object>();
		
		List<SyDealer> list = dealerService.getList();
		map.put("aaData", list);
	    return map;
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, SyDealer dealer){
		try{
			dealer = dealerService.getEntityById(SyDealer.class, dealer.getDealerCode(), true);
			request.setAttribute("dc", dealer);
		} catch (Exception e) {
			logger.error("执行编辑经销商门店信息失败,",e);
		}  
		return "dealer/dealer/add";
	}
	
	@RequestMapping("save")
    public String save(HttpServletRequest request, SyDealer dealer){
		try{
    		dealerService.saveDealer(dealer);
		} catch(Exception e){
			logger.error("保存经销商单位信息失败,",e);
			dealer.setDealerCode(null);
			request.setAttribute("dc", dealer);
			return "dealer/dealer/add";
		}
		return "dealer/dealer/list";
    }
	
	@RequestMapping("update")
    public String update(HttpServletRequest request, SyDealer dealer){
		try{
    		dealerService.updateDealer(dealer);
		} catch(Exception e){
			logger.error("保存经销商单位信息失败,",e);
			request.setAttribute("dc", dealer);
			return "dealer/dealer/add";
		}
		return "dealer/dealer/list";
    }
	
	@RequestMapping("view")
    public String view(HttpServletRequest request, SyDealer dealer){
    	try {
    		dealer = dealerService.getEntityById(SyDealer.class, dealer.getDealerCode(), true);
			request.setAttribute("dc", dealer);
		} catch (Exception e) {
			logger.error("查看失败,错误信息：",e);
			e.printStackTrace();
		} 
    	return "dealer/dealer/view";
    }
	
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, SyDealer dealer){
    	try{
    		dealerService.deleteEntity(dealer);
    		request.setAttribute("msg", "删除成功！");
        } catch (Exception e) {
        	logger.error("删除失败,错误信息：",e);
        	request.setAttribute("msg", "删除失败,！"+e.getMessage());
        }
    	return "dealer/dealer/list";
    }
    
    @RequestMapping("check")
    public void check(HttpServletRequest request, HttpServletResponse response, SyDealer dealer){
    	dealer = dealerService.getEntityById(SyDealer.class, dealer.getDealerCode(), false);
		if(dealer!=null){
			ReturnUitl.write(response, 0, "经销商门店代码重复.");
		} else {
			ReturnUitl.write(response, 1);
		}
    }
}

package com.rdfs.lyqc.system.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.core.bean.UserDto;
import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.utils.AuthUtil;
import com.rdfs.framework.core.utils.JacksonUtil;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.enums.OperMode;
import com.rdfs.framework.hibernate.utils.PageUtil;
import com.rdfs.lyqc.system.entity.SyAnnouncement;
import com.rdfs.lyqc.system.service.AnnouncementService;
import com.rdfs.lyqc.system.service.UserService;


@Controller
@RequestMapping("announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(AnnouncementController.class);
	
	/**
	 * 查看单个公告
	 * @param announcement
	 */
	@RequestMapping("viewSingle")
	public String viewSingle(HttpServletRequest request,HttpServletResponse response,SyAnnouncement announcement){
		if(announcement.getId() != null){
			announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), true);
		} else {
			UserDto user = AuthUtil.getUserDto(request);
			announcement.setIsTop(Constants.IS.YES);
			announcement.setIsPublish(Constants.IS.YES);
	        Page page = announcementService.pageList(announcement,user, new Page(1, 0));
	        
	        if(page.getItems()!=null && !page.getItems().isEmpty()){
	        	announcement = (SyAnnouncement) page.getItems().get(0);
	        }
		}
		request.setAttribute("announcement", announcement);
		return "system/announcement/viewSingle";
	}
	
	/**
	 * 个人消息队列
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("myList")
	@ResponseBody
	public Map<String, Object> myList(HttpServletRequest request,HttpServletResponse response){
		UserDto user = AuthUtil.getUserDto(request);
		
		Map<String, Object> map = new HashMap<String,Object>();
        Page page = announcementService.pageList(null,user, PageUtil.getPage(request));
        
        map.put("aaData", page.getItems());
        map.put("recordsTotal", page.getCount());	
	    map.put("recordsFiltered", page.getCount());
		return map;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, SyAnnouncement announcement){
		Map<String, Object> map = new HashMap<String,Object>();
		Page page = announcementService.pageList(announcement, PageUtil.getPage(request), OperMode.LIKE, "headline","postType","isPublish");
		
		map.put("aaData", page.getItems());
		map.put("recordsTotal", page.getCount());	
	    map.put("recordsFiltered", page.getCount());
	    
	    return map;
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, SyAnnouncement announcement){
		announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), true);
		request.setAttribute("announcement", announcement);
		return "system/announcement/add";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, SyAnnouncement announcement){
		try{
			UserDto user = AuthUtil.getUserDto(request);
			
			announcementService.saveAnnouncement(announcement, user);
			announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), true);
			request.setAttribute("msg", "保存成功!");
			request.setAttribute("announcement", announcement);
		}catch(Exception e){
			logger.error("保存失败,错误信息：",e);
			request.setAttribute("msg","保存失败,"+e.getMessage());
			request.setAttribute("announcement", announcement);
			return "system/announcement/add";
		}
		return "system/announcement/publish";
	}
	
	@RequestMapping("savePublish")
	public String savePublish(HttpServletRequest request, SyAnnouncement announcement){
		try{
			announcementService.updateAnnouncement(announcement);
			request.setAttribute("msg", "保存成功!");
		}catch(Exception e){
			logger.error("保存失败,错误信息：",e);
			request.setAttribute("msg","保存失败,"+e.getMessage());
			request.setAttribute("announcement", announcement);
			return "param/announcement/publish";
		}
		return "system/announcement/list";
	}
	
	@RequestMapping("view")
	public String view(HttpServletRequest request, SyAnnouncement announcement){
		announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), true);
		request.setAttribute("announcement", announcement);
		return "system/announcement/view";
	}
	
	@RequestMapping("userTree")
	public void viewUserAjax(HttpServletRequest request,HttpServletResponse response,SyAnnouncement announcement){
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), true);
			List<TreeDto> list = userService.formatUserTree(null, announcement.getUsers());
			pw.print(JacksonUtil.toJson(list));
		} catch(Exception e){
			logger.error("加载失败,错误信息：",e);
		}
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, SyAnnouncement announcement){
		try{
			announcementService.deleteEntity(announcement);
			request.setAttribute("msg", "删除成功!");
		}catch(Exception e){
			logger.error("删除失败,错误信息：",e);
			request.setAttribute("msg","删除失败,"+e.getMessage());
		}
		return "system/announcement/list";
	}
	
	@RequestMapping("upload")
    public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request, HttpServletResponse response){
    	PrintWriter pw = null;
    	try {
    		pw = response.getWriter();
    		response.setContentType("text/html;charset=UTF-8");
    		String fileName = file.getOriginalFilename();
    		String path = AuthUtil.getParam("")+fileName;
			String id = request.getParameter("id");
			FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
			
			SyAnnouncement announcement = announcementService.getEntityById(SyAnnouncement.class, Integer.parseInt(id), false);
			announcement.setFilename(fileName);
			announcement.setFileAddr(path);
			announcementService.updateEntity(announcement, "filename","fileAddr");
			pw.print("{\"msg\":\"success\",\"fileName\":\""+fileName+"\"}");
    	} catch (IOException e) {
    		logger.error("上传失败,错误信息：",e);
    		pw.print("{\"msg\":\""+e.getMessage()+"\"}");
			e.printStackTrace();
		}
    }
	
	@RequestMapping("download")
	public void download(HttpServletRequest request, HttpServletResponse response,SyAnnouncement announcement){
		try{
			announcement = announcementService.getEntityById(SyAnnouncement.class, announcement.getId(), false);
			//DownloadUtil.download(request, response, new File(announcement.getFileAddr()), announcement.getFilename());
		} catch(Exception e){
			logger.error("下载失败,错误信息：",e);
			try {
				show_msg(response, "下载失败,"+e.getMessage());
			} catch (IOException e1) {
				logger.error("下载失败,错误信息："+e1.getStackTrace());
				e1.printStackTrace();
			}
		}
	}
	public void show_msg(HttpServletResponse response,String msg) throws IOException{
	    response.setContentType("text/html; charset=gbk");  
	    PrintWriter out = response.getWriter();   
	    out.println("<script language='javascript'>");   
    	out.println("alert('"+msg+"');");
    	out.println("history.go(-1);");
	    out.print("</script>");   
	}
	
}

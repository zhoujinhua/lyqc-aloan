package com.rdfs.lyqc.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.bean.Page;
import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.utils.CacheCxtUtil;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.system.entity.SyAnnouncement;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.service.AnnouncementService;
import com.rdfs.lyqc.system.service.TreeService;

@Service
public class AnnouncementServiceImpl extends HibernateServiceSupport implements AnnouncementService {

	@Autowired
	private TreeService treeService;
	
	@Override
	public SyAnnouncement saveAnnouncement(SyAnnouncement announcement, UserDto user) {
		if(announcement.getId()!=null){
			updateEntity(announcement, "headline","content","postType");
		} else {
			
			announcement.setUserId(user.getUserId());
			announcement.setUserName(user.getTrueName());
			announcement.setCreateTime(new Date());
			
			saveEntity(announcement);
		}
		return announcement;
	}

	private String genHql(SyAnnouncement announcement, UserDto user){
		StringBuffer sb = new StringBuffer();
		if(user != null){
			sb.append("select u from SyAnnouncement u left join u.users as user where (u.isAll = '"+Constants.IS.YES+"' or user.id = '" + user.getUserId()+"')");
			sb.append(" and u.isPublish = '1' and u.publishTime <= '"+RdfsUtils.date2String(new Date(), "YYYY-MM-DD")+"'");
		} else {
			sb.append(" from SyAnnouncement u where 1=1 ");
		}
		if(announcement!=null ){
			if(announcement.getHeadline()!=null && !"".equals(announcement.getHeadline()))	{
				sb.append(" and u.headline = '"+announcement.getHeadline()+"'");
			}
			if(announcement.getPostType()!=null){
				sb.append(" and u.postType='"+announcement.getPostType()+"'");
			}
			if(announcement.getIsTop()!=null){
				sb.append(" and u.isTop='"+announcement.getIsTop()+"'");
			}
			if(announcement.getIsPublish()!=null){
				sb.append(" and u.isPublish='"+announcement.getIsPublish()+"'");
			}
		}
		sb.append(" order by u.publishTime desc");
		return sb.toString();
	}
	
	@Override
	public Page<SyAnnouncement> pageList(SyAnnouncement announcement, UserDto user, int pn) {
		String hql = genHql(announcement, user);
		return pageList(pn, hql);
	}

	@Override
	public void updateAnnouncement(SyAnnouncement announcement) {
		updateEntity(announcement, "isAll","isPublish","isTop","isAttach","publishTime","topDay");
		SyAnnouncement syAnnouncement = getEntityById(SyAnnouncement.class, announcement.getId(), true);
		syAnnouncement.getUsers().clear();
		
		if(!announcement.getIsAll().equals(Constants.IS.YES)){
			String userIds = announcement.getUserIds();
			for(String userId : userIds.split(",")){
				SyUser user = getEntityByCode(SyUser.class, userId, false);
				
				syAnnouncement.getUsers().add(user);
			}
		}
		
	}

	@Override
	public List<TreeDto> formatUserTree(SyAnnouncement announcement) throws Exception {
		List<SyDictItem> dictItems = CacheCxtUtil.getDicList("_user_type");
		List<TreeDto> treeList = treeService.getList(dictItems, "code", "desc", null, null);
		
		SyUser syUser = new SyUser(null, Constants.IS.YES);
		List<SyUser> users = getList(syUser,"userStatus");
		
		treeList.addAll(treeService.getList(users, "userId", "trueName", "userType", announcement.getUsers()));
		return treeList;
	}
}

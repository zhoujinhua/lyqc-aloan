package com.rdfs.lyqc.system.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rdfs.framework.core.bean.UserDto;
import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.utils.RdfsUtils;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.system.entity.SyAnnouncement;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl extends HibernateServiceSupport implements AnnouncementService {
	
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
	public Page pageList(SyAnnouncement announcement, UserDto user, Page page) {
		String hql = genHql(announcement, user);
		return pageList(page, hql);
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
}

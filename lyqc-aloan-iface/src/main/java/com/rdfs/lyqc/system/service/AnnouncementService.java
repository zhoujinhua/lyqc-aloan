package com.rdfs.lyqc.system.service;

import com.rdfs.core.bean.Page;
import com.rdfs.core.bean.UserDto;
import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyAnnouncement;

public interface AnnouncementService extends HibernateService {

	SyAnnouncement saveAnnouncement(SyAnnouncement announcement, UserDto user);

	Page pageList(SyAnnouncement announcement, UserDto user, Page page);

	void updateAnnouncement(SyAnnouncement announcement);

}

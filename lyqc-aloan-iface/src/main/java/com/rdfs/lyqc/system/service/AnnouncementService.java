package com.rdfs.lyqc.system.service;

import java.util.List;

import com.rdfs.core.bean.Page;
import com.rdfs.core.bean.UserDto;
import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyAnnouncement;
import com.rdfs.lyqc.common.dto.TreeDto;

public interface AnnouncementService extends HibernateService {

	SyAnnouncement saveAnnouncement(SyAnnouncement announcement, UserDto user);

	Page<SyAnnouncement> pageList(SyAnnouncement announcement, UserDto user, int pn);

	void updateAnnouncement(SyAnnouncement announcement);

	List<TreeDto> formatUserTree(SyAnnouncement announcement) throws Exception;
}

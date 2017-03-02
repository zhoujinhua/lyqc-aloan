package com.rdfs.lyqc.system.service;

import java.util.List;

import com.rdfs.core.bean.UserDto;
import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyPermSet;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.common.dto.TreeDto;

public interface PermSetService extends HibernateService {

	List<TreeDto> getPermSetTree(SyUser user) throws Exception;

	void updatePermSet(SyPermSet permSet, String[] split);
	
	List<TreeDto> getMenuTree(SyPermSet permSet) throws Exception;

	String getUserMenuTree(UserDto user);

	void savePermSet(SyPermSet permSet, UserDto user);
}

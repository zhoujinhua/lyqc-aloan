package com.rdfs.lyqc.system.service;

import java.util.List;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyUser;

public interface UserService extends HibernateService {

	void updateUser(SyUser user);
	
	void updateUserPassword(SyUser user);
	
	void updateSyUserPermSets(SyUser user, String[] permIds);
	
	void saveUser(SyUser user);

	List<TreeDto> formatUserTree(SyUser user, List<SyUser> userList) throws Exception;

	List<TreeDto> getPermSetTree(SyUser user) throws Exception;
}

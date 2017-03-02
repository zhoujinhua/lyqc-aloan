package com.rdfs.lyqc.system.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyUser;

public interface UserService extends HibernateService {

	void updateUser(SyUser user);
	
	void updateUserPassword(SyUser user);
	
	void updateSyUserPermSets(SyUser user, String[] permIds);
	
	void saveUser(SyUser user);
}

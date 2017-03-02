package com.rdfs.lyqc.cache.service;

import java.util.List;

import com.rdfs.core.bean.UserDto;
import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyUser;

public interface CacheUserService extends HibernateService{

	UserDto getUserDto(String juid);

	void cacheUserDto(UserDto userDto);

	void resetUserDto(String juid);

	void cacheUserData();
	
	SyUser getUser(String userId);
	
	void cacheUser(SyUser user);

	List<SyUser> getUserList();
	
}

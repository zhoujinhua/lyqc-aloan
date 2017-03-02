package com.rdfs.lyqc.cache.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyResource;

/**
 * 缓存菜单项 
 */
public interface CacheResourceService extends HibernateService{

	void cacheResourceData();

	SyResource getResource(String itemId);

	
}

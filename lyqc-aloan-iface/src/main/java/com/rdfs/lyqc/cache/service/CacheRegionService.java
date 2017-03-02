package com.rdfs.lyqc.cache.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyRegion;

public interface CacheRegionService extends HibernateService{

	List<SyRegion> getProvinceList();

	List<SyRegion> getCityList(String regCode);

	void cacheRegionData();

	SyRegion getRegion(String regCode);

	List<SyRegion> getRegionList();

}

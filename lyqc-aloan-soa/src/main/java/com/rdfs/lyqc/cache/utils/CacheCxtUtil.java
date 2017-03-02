package com.rdfs.lyqc.cache.utils;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.spring.SpringContextBeanFactory;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.lyqc.cache.service.CacheDealerService;
import com.rdfs.lyqc.cache.service.CacheMasterService;
import com.rdfs.lyqc.cache.service.CacheRegionService;
import com.rdfs.lyqc.cache.service.CacheResourceService;
import com.rdfs.lyqc.cache.service.CacheUserService;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.entity.SyRegion;

import redis.clients.jedis.Jedis;

@SuppressWarnings("all")
public class CacheCxtUtil {

	private static Logger log = LoggerFactory.getLogger(CacheCxtUtil.class);
	
	private static CacheUserService cacheUserService = SpringContextBeanFactory.getBean("cacheUserServiceImpl");
	private static CacheMasterService cacheMasterService = SpringContextBeanFactory.getBean("cacheMasterServiceImpl");
	private static CacheRegionService cacheRegionService = SpringContextBeanFactory.getBean("cacheRegionServiceImpl");
	private static CacheDealerService cacheDealerService = SpringContextBeanFactory.getBean("cacheDealerServiceImpl");
	private static CacheResourceService cacheResourceService = SpringContextBeanFactory.getBean("cacheResourceServiceImpl");

	/**
	 * 初始化cache
	 */
	public static void cacheAll(){
		cacheUserService.cacheUserData();
		cacheMasterService.cacheDictData();
		cacheMasterService.cacheParamData();
		cacheRegionService.cacheRegionData();
		cacheDealerService.cacheDealerData();
		cacheResourceService.cacheResourceData();
	}
	
	/**
	 * 从缓存中获取全局参数配置值
	 * @param key
	 * @return
	 */
	public static String getParam(String key){
		return cacheMasterService.getParam(key);
	}
	
	/**
	 * 从缓存中获取字典对照集合
	 * @param key
	 * @return
	 */
	public static List<SyDictItem> getDicList(String key){
		return cacheMasterService.getDicList(key);
	}
	
	/**
	 * 从缓存中获取字典对照描述
	 * @param key
	 * @param code
	 * @return
	 */
	public static String getDicDesc(String key, String code){
		return cacheMasterService.getDicDesc(key, code);
	}
	
	/**
	 * 从缓存中获取省份列表
	 * @return
	 */
	public static List<SyRegion> getProvinceList(){
		return cacheRegionService.getProvinceList();
	}
	
	/**
	 * 根据省份ID从缓存中获取城市列表
	 * @param regCode
	 * @return
	 */
	public static List<SyRegion> getCityList(String regCode){
		return cacheRegionService.getCityList(regCode);
	}
	
	/**
	 * 根据区域代码获取区域
	 * @param regCode
	 * @return
	 */
	public static SyRegion getRegion(String regCode){
		return cacheRegionService.getRegion(regCode);
	}
	
	/**
	 * 获取全部地区
	 * @return
	 */
	public static List<SyRegion> getRegionList(){
		return cacheRegionService.getRegionList();
	}
	
	/**
	 * 根据登录用户标识获取登录用户信息
	 * @param juid
	 * @return
	 */
	public static UserDto getUserDto(String juid){
		return cacheUserService.getUserDto(juid);
	}
	
	synchronized public static String getSeq(String prefix){
		String value = JedisUtil.getString(Constants.KEYS.APP_SEQ + prefix);
		if(StringUtils.isBlank(value)){
			value = "000001";
			JedisUtil.setString(Constants.KEYS.APP_SEQ + prefix, value, 86500);
		} else {
			value = com.rdfs.core.utils.StringUtils.prefixZoreFill(String.valueOf(Integer.parseInt(value)+1), 6);
			JedisUtil.setString(Constants.KEYS.APP_SEQ + prefix, value, 86500);
		}
		return value;
	}
	
	synchronized public static String genAppCode(){
		String seq = CacheCxtUtil.getSeq(RdfsUtils.date2String(new Date(), "yyyyMMdd"));
		String appCode = RdfsUtils.date2String(new Date(), "yyyyMMddHHmmss")+seq;
		
		return appCode;
	}
}

package com.rdfs.lyqc.cache.utils;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rdfs.framework.cache.service.CacheParamsService;
import com.rdfs.framework.cache.service.CacheResourceService;
import com.rdfs.framework.core.bean.UserDto;
import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.redis.JedisUtil;
import com.rdfs.framework.core.spring.SpringContextBeanFactory;
import com.rdfs.framework.core.utils.RdfsUtils;
import com.rdfs.framework.core.utils.StringUtils;
import com.rdfs.framework.params.entity.SyRegion;
import com.rdfs.framework.taglib.bean.DictItem;
import com.rdfs.framework.taglib.bean.Region;
import com.rdfs.lyqc.cache.service.CacheUserService;

@SuppressWarnings("all")
public class CacheCxtUtil {

	private static Logger log = LoggerFactory.getLogger(CacheCxtUtil.class);
	
	private static CacheUserService cacheUserService = SpringContextBeanFactory.getBean("cacheUserServiceImpl");
	private static CacheResourceService cacheResourceService = SpringContextBeanFactory.getBean("cacheResourceServiceImpl");
	private static CacheParamsService cacheParamsService = SpringContextBeanFactory.getBean("cacheParamsServiceImpl");
	
	/**
	 * 初始化cache
	 */
	public static void cacheAll(){
		cacheUserService.cacheUserData();
		cacheParamsService.cacheDictData();
		cacheParamsService.cacheParamData();
		cacheParamsService.cacheRegionData();
		cacheResourceService.cacheResourceData();
	}
	
	/**
	 * 从缓存中获取全局参数配置值
	 * @param key
	 * @return
	 */
	public static String getParam(String key){
		return cacheParamsService.getParam(key);
	}
	
	/**
	 * 从缓存中获取字典对照集合
	 * @param key
	 * @return
	 */
	public static List<DictItem> getDicList(String key){
		return cacheParamsService.getDicList(key);
	}
	
	/**
	 * 从缓存中获取字典对照描述
	 * @param key
	 * @param code
	 * @return
	 */
	public static String getDicDesc(String key, String code){
		return cacheParamsService.getDicDesc(key, code);
	}
	
	/**
	 * 从缓存中获取省份列表
	 * @return
	 */
	public static List<Region> getProvinceList(){
		return cacheParamsService.getProvinceList();
	}
	
	/**
	 * 根据省份ID从缓存中获取城市列表
	 * @param regCode
	 * @return
	 */
	public static List<Region> getCityList(String regCode){
		return cacheParamsService.getCityList(regCode);
	}
	
	/**
	 * 根据区域代码获取区域
	 * @param regCode
	 * @return
	 */
	public static SyRegion getRegion(String regCode){
		return (SyRegion) cacheParamsService.getRegion(regCode);
	}
	
	/**
	 * 获取全部地区
	 * @return
	 */
	public static List<Region> getRegionList(){
		return cacheParamsService.getRegionList();
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
			value = StringUtils.prefixZoreFill(String.valueOf(Integer.parseInt(value)+1), 6);
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

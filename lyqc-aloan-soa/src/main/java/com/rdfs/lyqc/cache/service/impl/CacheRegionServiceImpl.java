package com.rdfs.lyqc.cache.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheRegionService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyRegion;

import redis.clients.jedis.Jedis;

@Service
public class CacheRegionServiceImpl extends HibernateServiceSupport implements CacheRegionService {
	
	private Logger log = LoggerFactory.getLogger(CacheRegionServiceImpl.class);

	@Override
	public void cacheRegionData(){
		Map<String, String> map = new HashMap<>();
		List<SyRegion> provinces = getList(" from SyRegion where regLevel = '0'");
		Jedis jedis = JedisUtil.getJedisClient();
		for(SyRegion province : provinces){
			jedis.hset(Constants.KEYS.REGION_KEY, province.getRegCode(), JacksonUtil.toJson(province));
			jedis.hset(Constants.KEYS.REGION_PROVINCE_KEY, province.getRegCode(), JacksonUtil.toJson(province));
			SyRegion syRegion = new SyRegion();
			syRegion.setRegCodePar(province.getRegCode());
			List<SyRegion> citys = getList(syRegion, "regCodePar");
			
			if(citys!=null && !citys.isEmpty()){
				map.put(province.getRegCode(), JacksonUtil.toJson(citys));
				for(SyRegion city : citys){
					jedis.hset(Constants.KEYS.REGION_KEY, city.getRegCode(), JacksonUtil.toJson(city));
				}
			}
		}
		jedis.hmset(Constants.KEYS.REGION_CITY_KEY, map);
		JedisUtil.close(jedis);
	}
	
	@Override
	public List<SyRegion> getProvinceList(){
		List<SyRegion> regions = Lists.newArrayList();
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> proList = jedis.hvals(Constants.KEYS.REGION_PROVINCE_KEY);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(proList)) {
			log.error(RdfsUtils.merge("没有获取到省份列表"));
		}else {
			for (String province : proList) {
				regions.add((SyRegion)JacksonUtil.fromJson(province, SyRegion.class));
			}
		}
		return regions;
	}
	
	@Override
	public List<SyRegion> getCityList(String regCode){
		List<SyRegion> regions = Lists.newArrayList();
		if (RdfsUtils.isEmpty(regCode)) {
			log.error("获取城市失败：省份代码不能为空。");
			return regions;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String jsonValue = jedis.hget(Constants.KEYS.REGION_CITY_KEY, regCode);
		JedisUtil.close(jedis);
		if(!StringUtils.isBlank(jsonValue)){
			regions = JacksonUtil.fromJson(jsonValue, new TypeReference<List<SyRegion>>(){});
		}
		return regions;
	}
	
	@Override
	public SyRegion getRegion(String regCode){
		if (RdfsUtils.isEmpty(regCode)) {
			log.error("获取地区信息失败：地区代码不能为空。");
			return null;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String proString = jedis.hget(Constants.KEYS.REGION_KEY, regCode);
		JedisUtil.close(jedis);
		return JacksonUtil.fromJson(proString, SyRegion.class);
	}
	
	@Override
	public List<SyRegion> getRegionList(){
		List<SyRegion> regions = Lists.newArrayList();
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> proList = jedis.hvals(Constants.KEYS.REGION_KEY);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(proList)) {
			log.error(RdfsUtils.merge("没有获取到区域列表"));
		}else {
			for (String province : proList) {
				regions.add((SyRegion)JacksonUtil.fromJson(province, SyRegion.class));
			}
		}
		return regions;
	}
}

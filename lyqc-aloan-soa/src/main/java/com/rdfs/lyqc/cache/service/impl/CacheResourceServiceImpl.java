package com.rdfs.lyqc.cache.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheResourceService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyResource;

import redis.clients.jedis.Jedis;

@Service
public class CacheResourceServiceImpl extends HibernateServiceSupport implements CacheResourceService {

	private static Logger log = LoggerFactory.getLogger(CacheResourceServiceImpl.class);
	
	@Override
	public void cacheResourceData(){
		List<SyResource> list = getList("from SyResource");
		if(list!=null && !list.isEmpty()){
			Jedis jedis = JedisUtil.getJedisClient();
			for(SyResource resource : list){
				jedis.hset(Constants.KEYS.RESOURCE_KEY, resource.getItemId(), JacksonUtil.toJson(resource));
			}
			JedisUtil.close(jedis);
		}
	}
	
	@Override
	public SyResource getResource(String itemId){
		if (RdfsUtils.isEmpty(itemId)) {
			log.error("获取菜单项信息失败：菜单项ID不能为空。");
			return null;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String proString = jedis.hget(Constants.KEYS.RESOURCE_KEY, itemId);
		JedisUtil.close(jedis);
		if(!StringUtils.isBlank(proString)){
			return JacksonUtil.fromJson(proString, SyResource.class);
		}
		return null;
	}
}

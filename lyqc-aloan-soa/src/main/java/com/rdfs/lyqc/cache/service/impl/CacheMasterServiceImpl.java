package com.rdfs.lyqc.cache.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheMasterService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.entity.SyParameter;

import redis.clients.jedis.Jedis;

@Service
public class CacheMasterServiceImpl extends HibernateServiceSupport implements CacheMasterService{

	private static Logger log = LoggerFactory.getLogger(CacheMasterServiceImpl.class);
	
	/**
	 * 将全局参数信息刷到缓存
	 */
	public void cacheParamData() {
		List<SyParameter> parameters = getList(" from SyParameter");
		Map<String, String> cacheMap = Maps.newHashMap();
		for (SyParameter parameter : parameters) {
			cacheMap.put(parameter.getKey(), parameter.getValue());
		}
		if (RdfsUtils.isNotEmpty(cacheMap)) {
			Jedis jedis = JedisUtil.getJedisClient();
			jedis.hmset(Constants.KEYS.PARAM_KEY, cacheMap);
			JedisUtil.close(jedis);
		}
	}
	
	/**
	 * 将单个参数配置项刷到缓存，如果已存在则覆盖
	 * @param fieldKey 参数KEY
	 * @param value 参数值
	 */
	@Override
	public void cacheParamOption(String fieldKey, String value) {
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hset(Constants.KEYS.PARAM_KEY, fieldKey, value);
		JedisUtil.close(jedis);
	}
	
	/**
	 * 将单个参数配置项刷从缓存中删除
	 * @param fieldKey 参数KEY
	 */
	public void delParamOption(String fieldKey) {
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hdel(Constants.KEYS.PARAM_KEY, fieldKey);
		JedisUtil.close(jedis);
	}

	/**
	 * 从缓存中获取全局参数配置值
	 * 
	 * @param key
	 * @return
	 */
	public String getParam(String key) {
		return AuthUtil.getParam(key);
	}

	/**
	 * 将字典表刷到缓存
	 */
	public void cacheDictData() {
		SyDictItem item = new SyDictItem();
		item.setStatus(Constants.IS.YES);
		List<SyDictItem> dictItems = getList(item, OperMode.EQ, "isEnable");
		Jedis jedis = JedisUtil.getJedisClient();
		// 将字典对照项目载入缓存
		for (SyDictItem dictItem : dictItems) {
			jedis.hset(Constants.KEYS.DIC_KEY + dictItem.getKey(), dictItem.getCode(), JacksonUtil.toJson(dictItem));
		}
		JedisUtil.close(jedis);
	}
	
	/**
	 * 将单个字典刷到缓存
	 */
	@Override
	public void cacheDict(SyDictItem dictItem) {
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hset(Constants.KEYS.DIC_KEY + dictItem.getKey(), dictItem.getCode(), JacksonUtil.toJson(dictItem));
		JedisUtil.close(jedis);
	}
	
	/**
	 * 将单个字典从缓存中删除
	 */
	public void delDic(SyDictItem dictItem) {
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hdel(Constants.KEYS.DIC_KEY + dictItem.getKey(), dictItem.getCode());
		JedisUtil.close(jedis);
	}

	/**
	 * 从缓存中获取字典对照集合
	 * 
	 * @param key
	 * @return
	 */
	public List<SyDictItem> getDicList(String key) {
		List<SyDictItem> dictItems = Lists.newArrayList();
		if (RdfsUtils.isEmpty(key)) {
			log.error("获取字典对照失败：字典Key不能为空。");
			return dictItems;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> dicList = jedis.hvals(Constants.KEYS.DIC_KEY + key);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(dicList)) {
			log.error(RdfsUtils.merge("没有获取到Key为[{0}]的数据字典。", key));
		}else {
			for (String dicString : dicList) {
				dictItems.add((SyDictItem)JacksonUtil.fromJson(dicString, SyDictItem.class));
			}
		}
		return dictItems;
	}

	/**
	 * 从缓存中获取字典对照描述
	 * 
	 * @param key
	 * @param code
	 * @return
	 */
	public String getDicDesc(String key, String code) {
		String desc = StringUtils.EMPTY;
		if (RdfsUtils.isEmpty(key)) {
			log.error("获取字典对照失败：字典Key不能为空。");
			return desc;
		}
		if (RdfsUtils.isEmpty(code)) {
			log.error("获取字典对照失败：字典code不能为空。");
			return desc;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String dicJson = jedis.hget(Constants.KEYS.DIC_KEY + key, code);
		JedisUtil.close(jedis);
		if (RdfsUtils.isNotEmpty(dicJson)) {
			SyDictItem aos_dicPO = (SyDictItem)JacksonUtil.fromJson(dicJson, SyDictItem.class);
		    desc = aos_dicPO.getDesc();
		}
		return desc;
	}

}

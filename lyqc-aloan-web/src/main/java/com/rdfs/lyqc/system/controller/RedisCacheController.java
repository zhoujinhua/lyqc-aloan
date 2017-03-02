package com.rdfs.lyqc.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import com.rdfs.core.bean.HashDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.service.Dto;
import com.rdfs.core.utils.JsonUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.lyqc.cache.utils.CacheCxtUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("redis")
public class RedisCacheController {
	
	private Logger logger = LoggerFactory.getLogger(RedisCacheController.class);
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, String appKey){
		int length = ServletRequestUtils.getIntParameter(request, "length", 10);
		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		Map<String, Object> map = new HashMap<String,Object>();
		
		if(StringUtils.isBlank(appKey)){
			appKey = Constants.APP_KEY;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		Set<String> keySet = jedis.keys("*" + appKey + "*");
		List<String> keyList = new ArrayList<String>(keySet);
		List<Dto> list = Lists.newArrayList();
		for (String key_ : keyList) {
			Dto dto = new HashDto();
			dto.put("key_", key_);
			dto.put("type_", jedis.type(key_));
			long ttl_ = jedis.ttl(key_);
			dto.put("ttl_", ttl_ == -1 ? "永久有效" : ttl_ + "秒");
			list.add(dto);
		}
		JedisUtil.close(jedis);
		length = start + length;
		length = length > list.size() ? list.size() : length;
		List<Dto> outList = list.subList(start, length);

		map.put("aaData", outList);
		map.put("recordsTotal", list.size());
	    map.put("recordsFiltered", list.size());
	    
	    return map;
	}
	
	@RequestMapping("listValues")
	@ResponseBody
	public Map<String,Object> listValues(HttpServletRequest request, String key, String type) {
		int length = ServletRequestUtils.getIntParameter(request, "length", 10);
		int start = ServletRequestUtils.getIntParameter(request, "start", 0);
		List<Dto> outList = Lists.newArrayList();
		Map<String, Object> map = new HashMap<String,Object>();
		length = start + length ;
		
		Jedis jedis = JedisUtil.getJedisClient();
		int total = 0;
		if (type.equalsIgnoreCase("string")) {
			Dto dto = new HashDto();
			dto.put("field_", "-");
			dto.put("value_", jedis.get(key));
			outList.add(dto);
			total = outList.size();
		} else if (type.equalsIgnoreCase("hash")) {
			Set<String> fieldSet = jedis.hkeys(key);
			List<String> fiedList = new ArrayList<>(fieldSet);
			total = fiedList.size();
			length = length > fiedList.size() ? fiedList.size() : length;
			fiedList = fiedList.subList(start, length);
			for (String field : fiedList) {
				Dto dto = new HashDto();
				dto.put("field_", field);
				dto.put("value_", jedis.hget(key, field));
				outList.add(dto);
			}
		} else if (type.equalsIgnoreCase("list")) {
			List<String> valueList = jedis.lrange(key, start, length);
			for (String value : valueList) {
				Dto dto = new HashDto();
				dto.put("field_", "-");
				dto.put("value_", value);
				outList.add(dto);
			}
			total = jedis.llen(key).intValue();
		} else if (type.equalsIgnoreCase("set")) {
			// 由于API的限制，不能对SET类型进行有效的分页操作。所以随机取出10000条记录返回。
			List<String> valueList = jedis.srandmember(key, 10000);
			for (String value : valueList) {
				Dto dto = new HashDto();
				dto.put("field_", "-");
				dto.put("value_", value);
				outList.add(dto);
			}
			total = jedis.scard(key).intValue();
		}
		JedisUtil.close(jedis);
		
		map.put("aaData", outList);
		map.put("recordsTotal", total);
	    map.put("recordsFiltered", total);
	    
	    return map;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, String key_, String value_, String type_, String ttl_){
		try{
			Jedis jedis = JedisUtil.getJedisClient();
			value_ = StringUtils.replace(value_, "\n", "");
			jedis.del(key_);
			if (type_.equals(Constants.REDIS_TYPE.STRING)) {
				jedis.set(key_, value_);
			} else if (type_.equals(Constants.REDIS_TYPE.LIST)) {
				if (StringUtils.startsWith(value_, "[{")) {
					List<Dto> list = JsonUtil.fromJson(value_);
					for (Dto dto : list) {
						jedis.lpush(key_, JsonUtil.toJson(dto));
					}
				}else {
					List<String> list = JsonUtil.fromJson(value_, new TypeToken<List<String>>() {}.getType());
					for (String string : list) {
						jedis.lpush(key_, string);
					}
				}
			} else if (type_.equals(Constants.REDIS_TYPE.SET)) {
				if (StringUtils.startsWith(value_, "[{")) {
					List<Dto> list = JsonUtil.fromJson(value_);
					for (Dto dto : list) {
						jedis.sadd(key_, JsonUtil.toJson(dto));
					}
				}else {
					List<String> list = JsonUtil.fromJson(value_, new TypeToken<List<String>>() {}.getType());
					for (String string : list) {
						jedis.sadd(key_, string);
					}
				}

			} else if (type_.equals(Constants.REDIS_TYPE.MAP)) {
				Dto dto = JsonUtil.fromJson(value_, HashDto.class);
				Map<String, String> map = Maps.newHashMap();
				@SuppressWarnings({ "rawtypes", "unchecked" })
				Iterator<String> keyIterator = (Iterator) dto.keySet().iterator();
				while (keyIterator.hasNext()) {
					String myKey = (String) keyIterator.next();
					String value = dto.getString(myKey);
					map.put(myKey, value);
				}
				jedis.hmset(key_, map);
			}
			if (Integer.parseInt(ttl_) > 0) {
				jedis.expire(key_, Integer.parseInt(ttl_));
			}
			JedisUtil.close(jedis);
			request.setAttribute("msg", "保存成功!");
		} catch (Exception e){
			logger.error("保存缓存失败,",e);
			request.setAttribute("msg", "保存失败,"+e.getMessage());
		}
		
		return "system/redis/list";
	}
	
	@RequestMapping("monitor")
	@ResponseBody
	public String monitor(){
		Jedis jedis = JedisUtil.getJedisClient();
		String info = jedis.info();
		JedisUtil.close(jedis);
		return info;
	}
	
	@RequestMapping("flushAll")
	public String flushAll(HttpServletRequest request, HttpServletResponse response) {
		try{
			Jedis jedis = JedisUtil.getJedisClient();
			jedis.flushAll();
			JedisUtil.close(jedis);
			request.setAttribute("msg", "缓存数据库被清空。");
		}catch(Exception e){
			logger.error("清空缓存数据库失败,",e);
			request.setAttribute("msg", "清空缓存数据库失败,"+e.getMessage());
		}
		return "system/redis/list";
	}
	
	@RequestMapping("delete")
	public String delByKey(HttpServletRequest request, HttpServletResponse response, String key) {
		try{
			JedisUtil.delString(key);
			request.setAttribute("msg", RdfsUtils.merge("键[{0}]已成功删除。", key));
		}catch(Exception e){
			logger.error("删除失败,",e);
			request.setAttribute("msg", "删除失败,"+e.getMessage());
		}
		return "system/redis/list";
	}

	@RequestMapping("build")
	public String build(HttpServletRequest request, HttpServletResponse response) {
		try{
			Jedis jedis = JedisUtil.getJedisClient();
			jedis.flushAll();
			JedisUtil.close(jedis);
			CacheCxtUtil.cacheAll();
			request.setAttribute("msg", "重建缓存成功.");
		}catch(Exception e){
			logger.error("重建缓存成功,",e);
			request.setAttribute("msg", "重建缓存成功,"+e.getMessage());
		}
		return "system/redis/list";
	}
}

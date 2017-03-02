package com.rdfs.lyqc.cache.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.exeption.RdfsException;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.utils.CacheCxtUtil;
import com.rdfs.lyqc.cache.service.CacheUserService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyUser;

import redis.clients.jedis.Jedis;

@Service
public class CacheUserServiceImpl extends HibernateServiceSupport implements CacheUserService{

	private static Logger log = LoggerFactory.getLogger(CacheUserServiceImpl.class);

	/**
	 * 将在线用户信息从缓存中重置
	 * 
	 * @param UserDto
	 */
	@Override
	public void resetUserDto(String juid) {
		if (RdfsUtils.isNotEmpty(juid)) {
			JedisUtil.delString(juid);
		}
	}
	
	/**
	 * 从缓存中获取用户信息
	 * 
	 * @param juid
	 * @return
	 */
	public UserDto getUserDto(String juid) {
		return AuthUtil.getUserDto(juid);
	}

	/**
	 * 缓存在线用户信息
	 */
	@Override
	public void cacheUserDto(UserDto userDto) {
		if (RdfsUtils.isEmpty(userDto.getJuid())) {
			throw new RdfsException("JUID不能为空");
		}
		String userJson = JacksonUtil.toJson(userDto);
		String value = CacheCxtUtil.getParam("user_login_timeout_");
		if(StringUtils.isBlank(value)){
			value = "18000";
		}
		JedisUtil.setString(userDto.getJuid(), userJson, Integer.valueOf(value));
	}

	@Override
	public void cacheUserData() {
		List<SyUser> list = getList("from SyUser where userStatus ='" + Constants.IS.YES + "'");
		if(list!=null && !list.isEmpty()){
			Jedis jedis = JedisUtil.getJedisClient();
			for(SyUser user : list){
				jedis.hset(Constants.KEYS.USER_KEY, user.getUserId(), JacksonUtil.toJson(user));
			}
			JedisUtil.close(jedis);
		}
	}

	@Override
	public List<SyUser> getUserList(){
		List<SyUser> users = Lists.newArrayList();
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> proList = jedis.hvals(Constants.KEYS.USER_KEY);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(proList)) {
			log.error(RdfsUtils.merge("没有获取到系统用户列表"));
		}else {
			for (String province : proList) {
				users.add((SyUser)JacksonUtil.fromJson(province, SyUser.class));
			}
		}
		return users;
	}
	
	@Override
	public SyUser getUser(String userId) {
		if (RdfsUtils.isEmpty(userId)) {
			log.error("获取用户信息失败：用户ID不能为空。");
			return null;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String proString = jedis.hget(Constants.KEYS.USER_KEY, userId);
		JedisUtil.close(jedis);
		return JacksonUtil.fromJson(proString, SyUser.class);
	}

	@Override
	public void cacheUser(SyUser user) {
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hset(Constants.KEYS.USER_KEY, user.getUserId(), JacksonUtil.toJson(user));
		JedisUtil.close(jedis);
	}

}

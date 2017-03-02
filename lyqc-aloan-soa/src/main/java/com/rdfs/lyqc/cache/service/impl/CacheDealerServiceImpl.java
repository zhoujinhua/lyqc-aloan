package com.rdfs.lyqc.cache.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.core.utils.RdfsUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheDealerService;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.dealer.entity.SyDealer;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;

import redis.clients.jedis.Jedis;

@Service
public class CacheDealerServiceImpl extends HibernateServiceSupport implements CacheDealerService {

	private Logger log = LoggerFactory.getLogger(CacheDealerServiceImpl.class);
	
	@Override
	public void cacheDealerData(){
		List<SyDealer> list = getList(" from SyDealer where status = '" + Constants.IS.YES + "'");
		if(list!=null && !list.isEmpty()){
			Jedis jedis = JedisUtil.getJedisClient();
			for(SyDealer dealer : list){
				jedis.hset(Constants.KEYS.DEALER_KEY, dealer.getDealerCode()+"", JacksonUtil.toJson(dealer));
				if(dealer.getCompany()!=null){
					jedis.hset(Constants.KEYS.DEALER_COMPANY_KEY, dealer.getCompany().getCompanyCode()+"", JacksonUtil.toJson(dealer.getCompany()));
				}
			}
			JedisUtil.close(jedis);
		}
	}
	
	@Override
	public List<SyDealer> getDealerList(){
		List<SyDealer> dealerList = Lists.newArrayList();
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> codeList = jedis.hvals(Constants.KEYS.DEALER_KEY);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(codeList)) {
			log.error(RdfsUtils.merge("没有获取到经销商门店列表"));
		}else {
			for (String code : codeList) {
				dealerList.add((SyDealer)JacksonUtil.fromJson(code, SyDealer.class));
			}
		}
		return dealerList;
	}
	
	@Override
	public SyDealer getDealer(Integer dealerCode){
		if (RdfsUtils.isEmpty(dealerCode)) {
			log.error("获取经销商门店信息失败：门店代码不能为空。");
			return null;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String proString = jedis.hget(Constants.KEYS.DEALER_KEY, dealerCode+"");
		JedisUtil.close(jedis);
		return JacksonUtil.fromJson(proString, SyDealer.class);
	}
	
	@Override
	public List<SyDealerCompany> getDealerCompanyList(){
		List<SyDealerCompany> dealerList = Lists.newArrayList();
		Jedis jedis = JedisUtil.getJedisClient();
		List<String> codeList = jedis.hvals(Constants.KEYS.DEALER_COMPANY_KEY);
		JedisUtil.close(jedis);
		if (RdfsUtils.isEmpty(codeList)) {
			log.error(RdfsUtils.merge("没有获取到经销商门店列表"));
		}else {
			for (String code : codeList) {
				dealerList.add((SyDealerCompany)JacksonUtil.fromJson(code, SyDealerCompany.class));
			}
		}
		return dealerList;
	}
	
	@Override
	public SyDealerCompany getDealerCompany(Integer companyCode){
		if (RdfsUtils.isEmpty(companyCode)) {
			log.error("获取经销商单位信息失败：单位代码不能为空。");
			return null;
		}
		Jedis jedis = JedisUtil.getJedisClient();
		String proString = jedis.hget(Constants.KEYS.DEALER_COMPANY_KEY, companyCode+"");
		JedisUtil.close(jedis);
		return JacksonUtil.fromJson(proString, SyDealerCompany.class);
	}
	
	@Override
	public void cacheDealer(SyDealer dealer){
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hset(Constants.KEYS.DEALER_KEY , dealer.getDealerCode()+"", JacksonUtil.toJson(dealer));
		JedisUtil.close(jedis);
	}
	
	@Override
	public void deleteDealer(SyDealer dealer){
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hdel(Constants.KEYS.DEALER_KEY , dealer.getDealerCode()+"");
		JedisUtil.close(jedis);
	}
	
	@Override
	public void cacheDealerCompany(SyDealerCompany dealerCompany){
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hset(Constants.KEYS.DEALER_COMPANY_KEY , dealerCompany.getCompanyCode()+"", JacksonUtil.toJson(dealerCompany));
		JedisUtil.close(jedis);
	}
	
	@Override
	public void deleteDealerCompany(SyDealerCompany dealerCompany){
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.hdel(Constants.KEYS.DEALER_COMPANY_KEY , dealerCompany.getCompanyCode()+"");
		JedisUtil.close(jedis);
	}
}

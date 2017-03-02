package com.rdfs.lyqc.dealer.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheDealerService;
import com.rdfs.lyqc.dealer.entity.SyDealer;
import com.rdfs.lyqc.dealer.service.DealerService;

@Service
public class DealerServiceImpl extends HibernateServiceSupport implements DealerService {

	@Autowired
	private CacheDealerService cacheDealerService;
	
	@Override
	public void saveDealer(SyDealer dealer) {
		dealer.setStatus(Constants.IS.YES);
		dealer.setUpdateTime(new Date());
		saveEntity(dealer);
	}

	@Override
	public void updateDealer(SyDealer dealer) {
		dealer.setUpdateTime(new Date());
		this.updateEntity(dealer, "dealerName", "accountType", "province", "city", "dealerType",
				"saleArea", "recAccountName", "recAccountCard","recAccountBank2", "recAccountBank", "recAccountNo",
				"bankProvince", "bankCity", "remarks", "updateTime");
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getEntityById(Class<T> type, int id, boolean init) {
		SyDealer dealer = cacheDealerService.getDealer(id);
		if(!StringUtils.isBlankObj(dealer)){
			return (T) dealer;
		}
		return super.getEntityById(type, id, init);
	}

	@Override
	public List<SyDealer> getList() {
		UserDto userDto = AuthUtil.getCurrentUserDto();
		String hql = "select sd from SyDealer sd, SyUserDealer su where sd.dealerCode = su.dealer.dealerCode and su.user.userId = '" + userDto.getUserId() + "'";
		return getList(hql);
	}
	
}

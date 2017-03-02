package com.rdfs.lyqc.dealer.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.dealer.entity.SyDealer;

public interface DealerService extends HibernateService {

	void saveDealer(SyDealer dealer);

	void updateDealer(SyDealer dealer);

	List<SyDealer> getList();

}

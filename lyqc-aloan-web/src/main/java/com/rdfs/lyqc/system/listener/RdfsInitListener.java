package com.rdfs.lyqc.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.rdfs.core.contants.Constants;
import com.rdfs.core.redis.JedisUtil;
import com.rdfs.lyqc.cache.utils.CacheCxtUtil;

/**
 * <b>系统启动监听器</b>
 */
public class RdfsInitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			initCache(sce);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始缓存或重建缓存
	 */
	private void initCache(ServletContextEvent sce){
		CacheCxtUtil.cacheAll(); //cache数据
		JedisUtil.setString(Constants.KEYS.CXT, sce.getServletContext().getContextPath(), 0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

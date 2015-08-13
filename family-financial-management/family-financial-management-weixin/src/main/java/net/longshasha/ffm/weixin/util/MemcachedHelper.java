package net.longshasha.ffm.weixin.util;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * @project family-financial-management-web
 * @classpath net.longshasha.ffm.web.util.MemcachedHelper
 * @author 陈雨清 2015年8月13日 下午6:25:41
 */

public class MemcachedHelper {
	private static MemCachedClient mcc = new MemCachedClient();

	private static MemcachedHelper helper = new MemcachedHelper();

	// 设置与缓存服务器的连接池
	static {
		// 服务器列表和其权重
		String[] servers = { "118.193.139.162:11211" };
		Integer[] weights = { 5 };

		// 获取socke连接池的实例对象
		SockIOPool pool = SockIOPool.getInstance();

		// 设置服务器信息
		pool.setServers(servers);
		pool.setWeights(weights);

		// 设置初始连接数、最小和最大连接数以及最大处理时间
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 6);

		// 设置主线程的睡眠时间
		pool.setMaintSleep(30);

		// 设置TCP的参数，连接超时等
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);

		// 初始化连接池
		pool.initialize();

	}

	private MemcachedHelper() {
	}

	public static MemcachedHelper newInstance() {
		return helper;
	}

	public void set(String key, Object value) {
		mcc.set(key, value);
	}

	public Object get(String key) {
		return mcc.get(key);
	}

	public boolean delete(String key) {
		return mcc.delete(key);
	}
}

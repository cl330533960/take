package xin.cymall.service;

import xin.cymall.entity.SrvCouponSet;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 22:18:33
 */
public interface SrvCouponSetService {
	
	SrvCouponSet get(String id);
	
	List<SrvCouponSet> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvCouponSet srvCouponSet);
	
	void update(SrvCouponSet srvCouponSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}

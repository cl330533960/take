package xin.cymall.service;

import xin.cymall.entity.SrvCoupon;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 13:47:41
 */
public interface SrvCouponService {
	
	SrvCoupon get(String id);
	
	List<SrvCoupon> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvCoupon srvCoupon);
	
	void update(SrvCoupon srvCoupon);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	Long findByOrderNo(String orderNo);
}

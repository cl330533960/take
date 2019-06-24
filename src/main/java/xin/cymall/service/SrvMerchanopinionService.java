package xin.cymall.service;

import xin.cymall.entity.SrvMerchanopinion;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-24 11:52:55
 */
public interface SrvMerchanopinionService {
	
	SrvMerchanopinion get(String id);
	
	List<SrvMerchanopinion> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvMerchanopinion srvMerchanopinion);
	
	void update(SrvMerchanopinion srvMerchanopinion);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}

package xin.cymall.service;

import xin.cymall.entity.SrvMerchanclear;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 18:38:42
 */
public interface SrvMerchanclearService {
	
	SrvMerchanclear get(String id);
	
	List<SrvMerchanclear> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvMerchanclear srvMerchanclear);
	
	void update(SrvMerchanclear srvMerchanclear);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}

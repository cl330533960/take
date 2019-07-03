package xin.cymall.service;

import xin.cymall.entity.SrvRestauranapply;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-03 22:17:41
 */
public interface SrvRestauranapplyService {
	
	SrvRestauranapply get(String id);
	
	List<SrvRestauranapply> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvRestauranapply srvRestauranapply);
	
	void update(SrvRestauranapply srvRestauranapply);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}

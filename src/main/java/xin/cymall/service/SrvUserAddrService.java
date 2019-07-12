package xin.cymall.service;

import xin.cymall.entity.wchart.SrvUserAddr;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-12 15:14:54
 */
public interface SrvUserAddrService {
	
	SrvUserAddr get(String id);
	
	List<SrvUserAddr> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvUserAddr srvUserAddr);
	
	void update(SrvUserAddr srvUserAddr);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void modifyLocation(SrvUserAddr srvUserAddr);

}

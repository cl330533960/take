package xin.cymall.service;

import xin.cymall.entity.wchart.SrvWxUser;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-12 15:25:58
 */
public interface SrvWxUserService {
	
	SrvWxUser get(String id);
	
	List<SrvWxUser> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvWxUser srvWxUser);
	
	void update(SrvWxUser srvWxUser);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	SrvWxUser getByOpenId(String openId);
}

package xin.cymall.service;

import xin.cymall.entity.SrvUserComment;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-24 17:30:19
 */
public interface SrvUserCommentService {
	
	SrvUserComment get(String id);
	
	List<SrvUserComment> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvUserComment srvUserComment);
	
	void update(SrvUserComment srvUserComment);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}

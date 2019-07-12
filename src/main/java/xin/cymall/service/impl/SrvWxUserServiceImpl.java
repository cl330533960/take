package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvWxUserDao;
import xin.cymall.entity.wchart.SrvWxUser;
import xin.cymall.service.SrvWxUserService;




@Service("srvWxUserService")
@Transactional
public class SrvWxUserServiceImpl implements SrvWxUserService {
	@Autowired
	private SrvWxUserDao srvWxUserDao;
	
	@Override
	public SrvWxUser get(String id){
		return srvWxUserDao.get(id);
	}

	@Override
	public List<SrvWxUser> getList(Map<String, Object> map){
		return srvWxUserDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvWxUserDao.getCount(map);
	}

	@Override
	public void save(SrvWxUser srvWxUser){
		srvWxUserDao.save(srvWxUser);
	}

	@Override
	public void update(SrvWxUser srvWxUser){
		srvWxUserDao.update(srvWxUser);
	}

	@Override
	public void delete(String id){
		srvWxUserDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvWxUserDao.deleteBatch(ids);
	}

	@Override
	public SrvWxUser getByOpenId(String openId) {
		return srvWxUserDao.getByOpenId(openId);
	}

	
}

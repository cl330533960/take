package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.utils.StringUtil;
import xin.cymall.common.utils.UUID;
import xin.cymall.dao.SrvUserAddrDao;
import xin.cymall.dao.SrvWxUserDao;
import xin.cymall.entity.wchart.SrvUserAddr;
import xin.cymall.entity.wchart.SrvWxUser;
import xin.cymall.service.SrvUserAddrService;

import java.util.List;
import java.util.Map;




@Service("srvUserAddrService")
@Transactional
public class SrvUserAddrServiceImpl implements SrvUserAddrService {
	@Autowired
	private SrvUserAddrDao srvUserAddrDao;
	@Autowired
	private SrvWxUserDao srvWxUserDao;
	
	@Override
	public SrvUserAddr get(String id){
		return srvUserAddrDao.get(id);
	}

	@Override
	public List<SrvUserAddr> getList(Map<String, Object> map){
		return srvUserAddrDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvUserAddrDao.getCount(map);
	}

	@Override
	public void save(SrvUserAddr srvUserAddr){
		srvUserAddrDao.save(srvUserAddr);
	}

	@Override
	public void update(SrvUserAddr srvUserAddr){
		srvUserAddrDao.update(srvUserAddr);
	}

	@Override
	public void delete(String id){
		srvUserAddrDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvUserAddrDao.deleteBatch(ids);
	}

	@Transactional
	@Override
	public void modifyLocation(SrvUserAddr srvUserAddr) {
		SrvWxUser srvWxUser = srvWxUserDao.getByOpenId(srvUserAddr.getWxId());
		if(srvUserAddr!=null){
			srvUserAddr.setUserId(srvWxUser.getId());
		}else{
			SrvWxUser wxUser = new SrvWxUser();
			wxUser.setId(UUID.generateId());
			wxUser.setWxId(srvUserAddr.getWxId());
			srvWxUserDao.save(wxUser);
			srvUserAddr.setUserId(wxUser.getId());
		}
		if(StringUtil.isEmpty(srvUserAddr.getId()))
			srvUserAddrDao.save(srvUserAddr);
		else
			srvUserAddrDao.update(srvUserAddr);
	}

}

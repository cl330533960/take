package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xin.cymall.common.utils.UUID;
import xin.cymall.dao.SrvCouponDao;
import xin.cymall.dao.SrvCouponSetDao;
import xin.cymall.dao.SrvWxUserDao;
import xin.cymall.entity.SrvCoupon;
import xin.cymall.entity.SrvCouponSet;
import xin.cymall.entity.wchart.SrvWxUser;
import xin.cymall.service.SrvWxUserService;




@Service("srvWxUserService")
@Transactional
public class SrvWxUserServiceImpl implements SrvWxUserService {
	@Autowired
	private SrvWxUserDao srvWxUserDao;
	@Autowired
	private SrvCouponSetDao srvCouponSetDao;
	@Autowired
	private SrvCouponDao srvCouponDao;
	
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
	@Transactional
	public void save(SrvWxUser srvWxUser){
		srvWxUserDao.save(srvWxUser);
		Map<String,Object> map = new HashMap();
		map.put("type","2");
		map.put("openClose","1");
		List<SrvCouponSet> list = srvCouponSetDao.getList(map);
		if(list.size()>0){
			SrvCouponSet srvCouponSet = list.get(0);
			SrvCoupon srvCoupon = new SrvCoupon();
			srvCoupon.setId(UUID.generateId());
			srvCoupon.setAmount(srvCouponSet.getAmount());
			srvCoupon.setUserId(srvWxUser.getId());
			srvCoupon.setIsUse("0");
			srvCoupon.setType("2");
			srvCoupon.setSendTime(new Date());
			srvCouponDao.save(srvCoupon);
		}
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

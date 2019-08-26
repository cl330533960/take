package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvCouponDao;
import xin.cymall.entity.SrvCoupon;
import xin.cymall.service.SrvCouponService;




@Service("srvCouponService")
@Transactional
public class SrvCouponServiceImpl implements SrvCouponService {
	@Autowired
	private SrvCouponDao srvCouponDao;
	
	@Override
	public SrvCoupon get(String id){
		return srvCouponDao.get(id);
	}

	@Override
	public List<SrvCoupon> getList(Map<String, Object> map){
		return srvCouponDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvCouponDao.getCount(map);
	}

	@Override
	public void save(SrvCoupon srvCoupon){
		srvCouponDao.save(srvCoupon);
	}

	@Override
	public void update(SrvCoupon srvCoupon){
		srvCouponDao.update(srvCoupon);
	}

	@Override
	public void delete(String id){
		srvCouponDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvCouponDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvCoupon srvCoupon=get(id);
			srvCoupon.setIsUse(stateValue);
            update(srvCoupon);
        }
    }

	@Override
	public Long findByOrderNo(String orderNo) {
		return srvCouponDao.findByOrderNo(orderNo);
	}

}

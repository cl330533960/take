package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvCouponSetDao;
import xin.cymall.entity.SrvCouponSet;
import xin.cymall.service.SrvCouponSetService;




@Service("srvCouponSetService")
@Transactional
public class SrvCouponSetServiceImpl implements SrvCouponSetService {
	@Autowired
	private SrvCouponSetDao srvCouponSetDao;
	
	@Override
	public SrvCouponSet get(String id){
		return srvCouponSetDao.get(id);
	}

	@Override
	public List<SrvCouponSet> getList(Map<String, Object> map){
		return srvCouponSetDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvCouponSetDao.getCount(map);
	}

	@Override
	public void save(SrvCouponSet srvCouponSet){
		srvCouponSetDao.save(srvCouponSet);
	}

	@Override
	public void update(SrvCouponSet srvCouponSet){
		srvCouponSetDao.update(srvCouponSet);
	}

	@Override
	public void delete(String id){
		srvCouponSetDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvCouponSetDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvCouponSet srvCouponSet=get(id);
            update(srvCouponSet);
        }
    }
	
}

package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvMerchanclearDao;
import xin.cymall.dao.SrvRestaurantDao;
import xin.cymall.entity.SrvMerchanclear;
import xin.cymall.entity.SrvRestaurant;
import xin.cymall.service.SrvMerchanclearService;




@Service("srvMerchanclearService")
@Transactional
public class SrvMerchanclearServiceImpl implements SrvMerchanclearService {
	@Autowired
	private SrvMerchanclearDao srvMerchanclearDao;

	@Autowired
	private SrvRestaurantDao srvRestaurantDao;
	
	@Override
	public SrvMerchanclear get(String id){
		return srvMerchanclearDao.get(id);
	}

	@Override
	public List<SrvMerchanclear> getList(Map<String, Object> map){
		return srvMerchanclearDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvMerchanclearDao.getCount(map);
	}

	@Override
	public void save(SrvMerchanclear srvMerchanclear){
		srvMerchanclearDao.save(srvMerchanclear);
	}

	@Override
	public void update(SrvMerchanclear srvMerchanclear){
		srvMerchanclearDao.update(srvMerchanclear);
	}

	@Override
	public void delete(String id){
		srvMerchanclearDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvMerchanclearDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvMerchanclear srvMerchanclear=get(id);
			//srvMerchanclear.setState(stateValue);
            update(srvMerchanclear);
        }
    }

	@Override
	public List<SrvRestaurant> getBalanceList(Map<String, Object> map) {
		return srvRestaurantDao.getBalanceList(map);
	}

	@Override
	public int getBalanceCount(Map<String, Object> map) {
		return srvRestaurantDao.getBalanceCount(map);
	}

	@Transactional
	public void saveClearInfo(SrvMerchanclear srvMerchanclear){
		srvRestaurantDao.getBalance(srvMerchanclear.getRestaurantId());
		srvMerchanclearDao.save(srvMerchanclear);
		srvRestaurantDao.updateBalance(srvMerchanclear.getClearAmount(),srvMerchanclear.getRestaurantId());
	}

}

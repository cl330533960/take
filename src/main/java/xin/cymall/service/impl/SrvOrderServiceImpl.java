package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvOrderDao;
import xin.cymall.entity.SrvOrder;
import xin.cymall.service.SrvOrderService;




@Service("srvOrderService")
@Transactional
public class SrvOrderServiceImpl implements SrvOrderService {
	@Autowired
	private SrvOrderDao srvOrderDao;
	
	@Override
	public SrvOrder get(String id){
		return srvOrderDao.get(id);
	}

	@Override
	public List<SrvOrder> getList(Map<String, Object> map){
		return srvOrderDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvOrderDao.getCount(map);
	}

	@Override
	public void save(SrvOrder srvOrder){
		srvOrderDao.save(srvOrder);
	}

	@Override
	public void update(SrvOrder srvOrder){
		srvOrderDao.update(srvOrder);
	}

	@Override
	public void delete(String id){
		srvOrderDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvOrderDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvOrder srvOrder=get(id);
			srvOrder.setStatus(stateValue);
            update(srvOrder);
        }
    }
	
}

package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvMerchanopinionDao;
import xin.cymall.entity.SrvMerchanopinion;
import xin.cymall.service.SrvMerchanopinionService;




@Service("srvMerchanopinionService")
@Transactional
public class SrvMerchanopinionServiceImpl implements SrvMerchanopinionService {
	@Autowired
	private SrvMerchanopinionDao srvMerchanopinionDao;
	
	@Override
	public SrvMerchanopinion get(String id){
		return srvMerchanopinionDao.get(id);
	}

	@Override
	public List<SrvMerchanopinion> getList(Map<String, Object> map){
		return srvMerchanopinionDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvMerchanopinionDao.getCount(map);
	}

	@Override
	public void save(SrvMerchanopinion srvMerchanopinion){
		srvMerchanopinionDao.save(srvMerchanopinion);
	}

	@Override
	public void update(SrvMerchanopinion srvMerchanopinion){
		srvMerchanopinionDao.update(srvMerchanopinion);
	}

	@Override
	public void delete(String id){
		srvMerchanopinionDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvMerchanopinionDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvMerchanopinion srvMerchanopinion=get(id);
			srvMerchanopinion.setStatus(stateValue);
            update(srvMerchanopinion);
        }
    }
	
}

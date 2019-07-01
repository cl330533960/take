package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvBaseSetDao;
import xin.cymall.entity.SrvBaseSet;
import xin.cymall.service.SrvBaseSetService;




@Service("srvBaseSetService")
@Transactional
public class SrvBaseSetServiceImpl implements SrvBaseSetService {
	@Autowired
	private SrvBaseSetDao srvBaseSetDao;
	
	@Override
	public SrvBaseSet get(String id){
		return srvBaseSetDao.get(id);
	}

	@Override
	public List<SrvBaseSet> getList(Map<String, Object> map){
		return srvBaseSetDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvBaseSetDao.getCount(map);
	}

	@Override
	public void save(SrvBaseSet srvBaseSet){
		srvBaseSetDao.save(srvBaseSet);
	}

	@Override
	public void update(SrvBaseSet srvBaseSet){
		srvBaseSetDao.update(srvBaseSet);
	}

	@Override
	public void delete(String id){
		srvBaseSetDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvBaseSetDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvBaseSet srvBaseSet=get(id);
            update(srvBaseSet);
        }
    }
	
}

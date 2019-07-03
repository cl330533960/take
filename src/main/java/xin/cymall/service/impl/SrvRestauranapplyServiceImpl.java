package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvRestauranapplyDao;
import xin.cymall.entity.SrvRestauranapply;
import xin.cymall.service.SrvRestauranapplyService;




@Service("srvRestauranapplyService")
@Transactional
public class SrvRestauranapplyServiceImpl implements SrvRestauranapplyService {
	@Autowired
	private SrvRestauranapplyDao srvRestauranapplyDao;
	
	@Override
	public SrvRestauranapply get(String id){
		return srvRestauranapplyDao.get(id);
	}

	@Override
	public List<SrvRestauranapply> getList(Map<String, Object> map){
		return srvRestauranapplyDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvRestauranapplyDao.getCount(map);
	}

	@Override
	public void save(SrvRestauranapply srvRestauranapply){
		srvRestauranapplyDao.save(srvRestauranapply);
	}

	@Override
	public void update(SrvRestauranapply srvRestauranapply){
		srvRestauranapplyDao.update(srvRestauranapply);
	}

	@Override
	public void delete(String id){
		srvRestauranapplyDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvRestauranapplyDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvRestauranapply srvRestauranapply=get(id);
			srvRestauranapply.setStatus(stateValue);
            update(srvRestauranapply);
        }
    }
	
}

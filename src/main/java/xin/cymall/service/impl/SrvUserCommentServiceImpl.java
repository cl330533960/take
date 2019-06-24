package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvUserCommentDao;
import xin.cymall.entity.SrvUserComment;
import xin.cymall.service.SrvUserCommentService;




@Service("srvUserCommentService")
@Transactional
public class SrvUserCommentServiceImpl implements SrvUserCommentService {
	@Autowired
	private SrvUserCommentDao srvUserCommentDao;
	
	@Override
	public SrvUserComment get(String id){
		return srvUserCommentDao.get(id);
	}

	@Override
	public List<SrvUserComment> getList(Map<String, Object> map){
		return srvUserCommentDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvUserCommentDao.getCount(map);
	}

	@Override
	public void save(SrvUserComment srvUserComment){
		srvUserCommentDao.save(srvUserComment);
	}

	@Override
	public void update(SrvUserComment srvUserComment){
		srvUserCommentDao.update(srvUserComment);
	}

	@Override
	public void delete(String id){
		srvUserCommentDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvUserCommentDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvUserComment srvUserComment=get(id);
			srvUserComment.setState(stateValue);
            update(srvUserComment);
        }
    }
	
}

package kr.scott.ngg.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.work.dao.WorkDao;
import kr.scott.ngg.work.domain.WorkVO;
@Service("workService")
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	WorkDao workdao;

	public WorkServiceImpl () {}
	
	@Override
	public int doInsert(WorkVO inVO) {
		return workdao.doInsert(inVO);
	}

	@Override
	public int doDelete(WorkVO inVO) {
		return workdao.doDelete(inVO);
	}

	@Override
	public int doUpdate(WorkVO inVO) {
		return workdao.doUpdate(inVO);
	}

	@Override
	public WorkVO doSelectOne(WorkVO inVO) {
		
		WorkVO outVO = workdao.doSelectOne(inVO); 
		if(null != outVO) {
			workdao.doReadCnt(outVO);
		}
		
		return outVO;
	}

	@Override
	public List<WorkVO> doRetrieve(SearchVO inVO) {
		return workdao.doRetrieve(inVO);
	}

}

package kr.scott.ngg.status.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.status.dao.StatusDao;
import kr.scott.ngg.status.domain.StatusVO;

@Service("statusService")
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	StatusDao dao;

	@Override
	public int doInsert(StatusVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(StatusVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public int doUpdate(StatusVO inVO) throws SQLException {
		return dao.doUpdate(inVO);
	}

	@Override
	public StatusVO doSelectOne(StatusVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<StatusVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

	@Override
	public List<StatusVO> doRetrieveCal(StatusVO inVO) throws SQLException {
		return dao.doRetrieveCal(inVO);
	}

}

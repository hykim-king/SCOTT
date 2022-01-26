package kr.scott.ngg.report.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.report.dao.ReportDao;
import kr.scott.ngg.report.domain.ReportVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDao dao;

	@Override
	public int doInsert(ReportVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(ReportVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public int doUpdate(ReportVO inVO) throws SQLException {
		return dao.doUpdate(inVO);
	}

	@Override
	public ReportVO doSelectOne(ReportVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<ReportVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

}

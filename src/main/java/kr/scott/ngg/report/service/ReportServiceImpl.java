package kr.scott.ngg.report.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.report.dao.ReportDao;
import kr.scott.ngg.report.domain.ReportVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReportDao rDao;
	
	@Override
	public int doInsert(ReportVO inVO) {

		return rDao.doInsert(inVO);
	}

}

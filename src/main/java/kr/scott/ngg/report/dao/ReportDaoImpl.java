package kr.scott.ngg.report.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.report.domain.ReportVO;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	final String NAMESPACE = "kr.scott.ngg.ReportMapper";

	@Override
	public int doInsert(ReportVO inVO) {
		LOG.debug("dao) doInsert => param: " + inVO);

		String statement = NAMESPACE + ".doInsert";
		LOG.debug("dao) doInsert => statement: " + statement);

		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao) doInsert => flag: " + flag);

		return flag;
	}

	@Override
	public int doUpdate(ReportVO inVO) {
		LOG.debug("dao) doUpdate => param: " + inVO);

		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("dao) doUpdate => statement: " + statement);

		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("dao) doUpdate => flag: " + flag);

		return flag;
	}

	@Override
	public List<ReportVO> doRetrieve(SearchVO inVO) {
		LOG.debug("dao) doRetrieve => param: " + inVO);

		String statement = NAMESPACE + ".doRetrieve";
		LOG.debug("dao) doRetrieve => statement: " + statement);

		List<ReportVO> list = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("dao) doRetrieve => list: " + list);

		return list;
	}

}// --class

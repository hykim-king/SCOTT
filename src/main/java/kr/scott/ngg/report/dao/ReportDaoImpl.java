package kr.scott.ngg.report.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.report.domain.ReportVO;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	final String NAMESPACE = "kr.scott.ngg.ReportMapper";

	@Override
	public int doInsert(ReportVO inVO) {
		LOG.debug("dao) doInsert => param: "+inVO);
		
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("dao) doInsert => statement: "+statement);

		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao) doInsert => flag: "+flag);
		
		return flag;
	}
	

}//--class

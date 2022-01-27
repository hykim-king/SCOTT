package kr.scott.ngg.report;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.scott.ngg.report.dao.ReportDao;
import kr.scott.ngg.report.domain.ReportVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ReportDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	ReportDao rDao;
	
	ReportVO report01;

	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => dao: "+rDao);

		assertNotNull(context);
		assertNotNull(rDao);
		
		report01 = new ReportVO(0, 
								20, 
								"", 
								0, 
								0, 
								"신고 테스트", 
								0);
	}

	@Test
	public void doInsert() {
		LOG.debug("daoTest) doInsert()=====================");
		
		rDao.deleteAll();
		
		rDao.doInsert(report01);
	}

}

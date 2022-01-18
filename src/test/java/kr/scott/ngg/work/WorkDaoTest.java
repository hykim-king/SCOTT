package kr.scott.ngg.work;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.scott.ngg.file.dao.FileDao;
import kr.scott.ngg.file.domain.FileVO;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.work.dao.WorkDao;
import kr.scott.ngg.work.domain.WorkVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class WorkDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	WorkDao workDao;
	
	@Autowired
	FileDao fileDao;
	
	WorkVO work01;
	UserVO user01;
	FileVO file01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => workDao: "+workDao);
		LOG.debug("daoTest) setUp => fileDao: "+fileDao);

		assertNotNull(context);
		assertNotNull(workDao);
		assertNotNull(fileDao);
		
		user01 = new UserVO("testid01", 
							"test1234", 
							"김테스", 
							"testid01@mail.com", 
							"1990-01-01", 
							0, 
							321.3, 
							123.3, 
							0, 
							1234, 
							0);
		
		file01 = new FileVO(0, 
							"img.png", 
							"20202020_1234123412_img.png", 
							"C:/imgs/");
		
		work01 = new WorkVO("테스트글입니다", 
							user01.getUserId(), 
							"운동정보test", 
							0, 
							0, 
							0);
	}

	@Test
	public void doDelete() {
		LOG.debug("daoTest) doDelete()=====================");
		workDao.deleteAll();
		
		workDao.doInsert(work01);
		assertEquals(1, workDao.getCount());
		
		workDao.doDelete(work01);
		assertEquals(0, workDao.getCount());
	}
	
	@Test
	@Ignore
	public void doInsert() {
		LOG.debug("daoTest) doInsert()=====================");
		
		workDao.deleteAll();

		workDao.doInsert(work01);
		
		assertEquals(1, workDao.getCount());
	}

}

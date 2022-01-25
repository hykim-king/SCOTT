package kr.scott.ngg.work;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

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
import org.springframework.test.context.web.WebAppConfiguration;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.file.dao.FileDao;
import kr.scott.ngg.file.domain.FileVO;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.work.dao.WorkDao;
import kr.scott.ngg.work.domain.WorkVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
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
	
	
	SearchVO search;
	
	
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
		
		
		work01 = new WorkVO("테스트글입니다", 
							user01.getUserId(), 
							"운동정보test1", 
							0, 
							0, 
							0);
		
		search = new SearchVO();
	
	}

	@Test
	@Ignore
	public void doDelete() {
		LOG.debug("daoTest) doDelete()=====================");
		workDao.deleteAll();
		
		workDao.doInsert(work01);
		assertEquals(1, workDao.getCount());
		
		workDao.doDelete(work01);
		LOG.debug(work01);
		assertEquals(0, workDao.getCount());
	}
	
	@Test
	@Ignore
	public void totalTest() {
		LOG.debug("daoTest) doInsert()=====================");
		//전체 삭제 -> 단건추가 -> 단건조회 -> 업데이트 -> 조회수 증가 -> 단건 삭제
		
		
		//전체 삭제
		workDao.deleteAll();
		
		//단건 추가
		workDao.doInsert(work01);
		assertEquals(1, workDao.getCount());
		
		//딘건조회(검색조건 user_id)
		WorkVO vo   = workDao.idLike(work01);
		WorkVO vsVO = workDao.doSelectOne(vo);
		LOG.debug("vo: "+vo);
		LOG.debug("vsVO: "+vsVO);
		isSameWorSq(vo, vsVO);
		
		//업데이트
		vo.setWorkContent(vo.getWorkContent()+"_f");
		int flag = workDao.doUpdate(vo);
		assertEquals(1, flag);
		
		//조회수 증가
		flag = workDao.doReadCnt(vo);
		WorkVO increasedVo = workDao.doSelectOne(vo);
		LOG.debug("increasevo: "+increasedVo);
		assertEquals(1, flag);
		
		//단건삭제
		workDao.doDelete(vo);
		LOG.debug("vo: "+vo);
		assertEquals(0, workDao.getCount());
		
		//조회
		List<WorkVO> list =workDao.doRetrieve(search);
		assertEquals(1, list.size());
	}
	@Test
	@Ignore
	public void doRetrieve () throws SQLException{
		
		
		
		List<WorkVO> list =workDao.doRetrieve(search);
		assertEquals(1, list.size());
	}
	
	private void isSameWorSq(WorkVO outVO,WorkVO userVO) {
		assertEquals(outVO.getWorkSq(), userVO.getWorkSq());
	}
}

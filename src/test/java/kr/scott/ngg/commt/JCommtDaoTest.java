/**
 * 
 */
package kr.scott.ngg.commt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import kr.scott.ngg.commt.dao.CommtDao;
import kr.scott.ngg.commt.domain.CommtVO;

/**
 * @author USER
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //applicationContext.xml loading
public class JCommtDaoTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	//spring 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입 한다.
    @Autowired
    ApplicationContext  context;
    
    @Autowired
    CommtDao dao;
    
    CommtVO commt01;
    CommtVO commt02;
    CommtVO commt03;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("1====================");
		LOG.debug("1=context="+context);
		LOG.debug("1=context="+dao);
		
		commt01=new CommtVO(1, "아디01", "내용01", 123, 1);
		commt02=new CommtVO(1, "아디02", "내용02", 123, 2);
		commt03=new CommtVO(2, "아디03", "내용03", 123, 3);
				
		assertNotNull(dao);
		assertNotNull(context);
	}
	
	@Test
	@Ignore
	public void selectPageCommt() throws SQLException {
		LOG.debug("====================");
		LOG.debug("selectPageCommt");
		LOG.debug("====================");
		
		dao.deleteAll();
		
		assertEquals(1, dao.insertCommt(commt01));
		assertEquals(1, dao.insertCommt(commt02));
		assertEquals(1, dao.insertCommt(commt03));
		
		int communitySq=1;
		List<CommtVO> list=dao.selectPageCommt(communitySq);
		assertEquals(2, list.size());
	}
	
	@Test
	@Ignore
	public void deleteCommt() throws SQLException {
		LOG.debug("====================");
		LOG.debug("deleteCommt");
		LOG.debug("====================");
		
		dao.deleteAll();
		
		assertEquals(1, dao.insertCommt(commt01));
		assertEquals(1, dao.insertCommt(commt02));
		assertEquals(1, dao.insertCommt(commt03));
		
		//sqld에서 다음에 올 값을 예측하여 수동으로 넣어야 됨.
		assertEquals(1, dao.deleteCommt(213));
	}
	
	@Test
	public void updateCommt() throws SQLException {
		LOG.debug("====================");
		LOG.debug("deleteCommt");
		LOG.debug("====================");
		
		dao.deleteAll();
		
		assertEquals(1, dao.insertCommt(commt01));
		assertEquals(1, dao.insertCommt(commt02));
		assertEquals(1, dao.insertCommt(commt03));
		
		//sqld에서 다음에 올 값을 예측하여 수동으로 넣어야 됨.
		commt01.setCommentSq(267);
		//업데이트
		commt01.setCommentContent("내용이당");
		commt01.setCommentFile(8888);
		
		assertEquals(1, dao.updateCommt(commt01));
		
	}
	

	@Test
	@Ignore
	public void addAndGet() throws SQLException {
		LOG.debug("====================");
		LOG.debug("=addAndGet()=");
		LOG.debug("====================");
		
		//1. 전체삭제
		//2. 1건 입력
		//3. 건수 check
		//4. 데이터 1건 조회
		//5. 입력데이터와 비교
		
		dao.deleteAll();
		
		int flag = dao.doInsert(commt01);
		assertEquals(1, flag);
		assertEquals(1, dao.getCount());
	}

}

package kr.scott.ngg.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import kr.scott.ngg.user.dao.UserDao;
import kr.scott.ngg.user.domain.UserVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	UserVO user01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => dao: "+dao);

		assertNotNull(context);
		assertNotNull(dao);
		
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
	}
	
	//@Test
	//@Ignore
	public void doUpdate() {
		LOG.debug("daoTest) doUpdate()=====================");
		
		// 전부 지우고 한 건 넣기
		dao.deleteAll();
		
		dao.doInsert(user01);
		assertEquals(1, dao.getCount());
		
		// 데이터 setting해서 update하기
		user01.setUserHeight(user01.getUserHeight() + 100);
		user01.setUserWeight(user01.getUserWeight() + 100);
		user01.setUserActkcal(user01.getUserActkcal() + 100);
		
		user01.setUserNn(user01.getUserNn() + "NGG");
		user01.setUserEmail(user01.getUserEmail() + "NGG");
		user01.setUserGender(1);
		user01.setUserGoal(user01.getUserGoal() + 1);
		user01.setUserGrade(user01.getUserGrade() + 1);
		user01.setUserPoint(user01.getUserPoint() + 100);
		user01.setUserBirth("1999-09-09");
		
		// 비밀번호 변경
		user01.setUserPw(user01.getUserPw()+"NGG");
		
		// 회원 탈퇴
		user01.setUserIsActive(0);
		
		// 운영자 변경
		user01.setUserIsAdmin(1);
		
		// 최종접속일
		user01.setUserLastLogin("2023-01-01");
		
		int flag = dao.doUpdate(user01);
		assertEquals(1, flag);
		
		UserVO upVO = new UserVO();
		upVO.setUserId(user01.getUserId());
		upVO = dao.doSelectOne(user01);
		LOG.debug("daoTest) doUpdate => upVO: "+upVO);
		assertNotNull(upVO);
	}
	
	//@Test
	//@Ignore
	public void doSelectOne() {
		LOG.debug("daoTest) doSelectOne()=====================");
		dao.deleteAll();
		
		dao.doInsert(user01);
		assertEquals(1, dao.getCount());
		
		UserVO outVO = dao.doSelectOne(user01);
		LOG.debug("daoTest) doSelectOne => outVO: "+outVO);
		
		assertNotNull(outVO);
	}
	
	//@Test
	//@Ignore
	public void doDelete() {
		LOG.debug("daoTest) doDelete()=====================");
		
		doInsert();
		
		dao.doDelete(user01);
		assertEquals(0, dao.getCount());
	}
	

	@Test
	//@Ignore
	public void doInsert() {
		LOG.debug("daoTest) doInsert()=====================");
		
		dao.deleteAll();
		
		dao.doInsert(user01);
		assertEquals(1, dao.getCount());
		
	}

}

package kr.scott.ngg.meal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.dao.MealDao;
import kr.scott.ngg.meal.domain.MealVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MealDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MealDao dao;
	
	MealVO meal1, meal2, meal3;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => dao: "+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
		
		meal1 = new MealVO(0, "testid01", "아침,고등어,123;점심,빵,33;", "20220101", "20220103");
		meal2 = new MealVO(0, "ppikkuppikku", "점심,라면,555;간식,사과,126;", "20220123", "20220123");
		meal3 = new MealVO(0, "one11the22one", "점심,파스타,667;저녁,라면,556;", "20220111", "20220113");
	}

	
	@Test
	public void orderTest() {
		LOG.debug("daoTest) orderTest =============");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 3건 등록
		dao.doInsert(meal1);
		dao.doInsert(meal2);
		dao.doInsert(meal3);
		assertEquals(3, dao.getCount());
				
		// 정렬
		SearchVO searchVO = new SearchVO();
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		searchVO.setOrderDiv("meal_reg_dt");
		searchVO.setOrderDir("DESC");
		
		List<MealVO> list = dao.doRetrieve(searchVO);
		assertNotNull(list);
		
		for(MealVO vo : list) {
			LOG.debug("-data-> "+vo);
		}
	}
	
	
	@Test
	@Ignore
	public void doRetrieveSearch() {
		LOG.debug("daoTest) 검색어 검색 =============");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 3건 등록
		dao.doInsert(meal1);
		dao.doInsert(meal2);
		dao.doInsert(meal3);
		assertEquals(3, dao.getCount());
				
		// 검색조건 : user_id(10), meal_content(20)
		SearchVO searchVO = new SearchVO();
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		
		searchVO.setSearchDiv("20");
		searchVO.setSearchWord("라면");
		
		List<MealVO> list = dao.doRetrieve(searchVO);
		assertNotNull(list);
		
		for(MealVO vo : list) {
			LOG.debug("-data-> "+vo);
		}
	}
	
	@Test
	@Ignore
	public void doUpdate() {
		LOG.debug("daoTest) doUpdate =============");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(meal1);
		assertEquals(1, flag);
		
		// 마지막 등록한 값 가져오기 
		MealVO lastVO = dao.getLastData();
		
		// 값 수정
		lastVO.setMealContent("콘텐츠가 있긴 했음?");
		
		// 수정
		flag = dao.doUpdate(lastVO);
		assertEquals(1, flag);
		
		// 수정한 값 가져와서 비교
		MealVO vsVO = dao.doSelectOne(lastVO);
		isSameObj(lastVO, vsVO);
	}
	
	
	@Test
	@Ignore
	public void doDelete() {
		LOG.debug("daoTest) doDelete()=====================");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(meal1);
		assertEquals(1, flag);
		
		// 마지막에 등록한 값 가져오기
		MealVO lastVO = dao.getLastData();
		
		// 마지막 등록한 값 삭제
		flag = dao.doDelete(lastVO);
		assertEquals(1, flag);
		
	}
	
	@Test
	@Ignore
	public void doInsert() {
		LOG.debug("daoTest) doInsert()=====================");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(meal1);
		assertEquals(1, flag);
		
	}
	
	private void isSameObj(MealVO orgVO, MealVO vsVO) {
		assertEquals(orgVO.getMealContent(), vsVO.getMealContent());
		assertEquals(orgVO.getUserId(), vsVO.getUserId());
	}
	

}//--class

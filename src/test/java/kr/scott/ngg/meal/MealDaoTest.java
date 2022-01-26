package kr.scott.ngg.meal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
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
import kr.scott.ngg.meal.domain.MealdetailVO;

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
	MealdetailVO md1, md2, md3, md4, md5, md6;
	List<MealdetailVO> mdList;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => dao: "+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
		
		// new MealVO(mealSq, mealDate, userId, mealKcal, mealDivs)
		meal1 = new MealVO(0, "2022-01-25", "ppikkuppikku", 15055, "123");
		meal2 = new MealVO(0, "2022-01-24", "ppikkuppikku", 233, "2");
		meal3 = new MealVO(0, "2022-01-25", "one11pun11man", 1555, "23");
		
		// new MealdetailVO(mealdetailSq, mealSq, mealDiv, foodName, foodKcal, foodCt)
		md1 = new MealdetailVO(0, 0, 1, "청국장", 332, 1);
		md2 = new MealdetailVO(0, 0, 1, "현미밥", 422, 2);
		md3 = new MealdetailVO(0, 0, 1, "콜라", 3232, 3);
		md4 = new MealdetailVO(0, 0, 2, "피자", 2535, 3);
		md5 = new MealdetailVO(0, 0, 3, "김밥", 120, 3);
		md6 = new MealdetailVO(0, 0, 3, "라면", 332, 2);
		
		mdList = new ArrayList<MealdetailVO>();
	}

	@Test
	@Ignore
	public void test() {
		LOG.debug("daoTest) test =============");
		
		//dao.deleteAll();
		
//		dao.doInsert(meal1);
//		dao.doInsert(meal2);
//		dao.doInsert(meal3);
//		assertEquals(3, dao.getCount());
		
		MealVO mealVO = dao.getLastData();
		assertNotNull(mealVO);
		
		
	}
	
	
	@Test
	@Ignore
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
	public void doRetrieveSearch2() {
		LOG.debug("daoTest) 기간 검색 =============");
		// 전체 삭제
		dao.deleteAll();
		
		// 3건 등록
		dao.doInsert(meal1);
		dao.doInsert(meal2);
		dao.doInsert(meal3);
		assertEquals(3, dao.getCount());
		
		// 기간검색: meal_reg_dt(30), meal_mod_dt(40)
		SearchVO searchVO = new SearchVO();
		
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		searchVO.setSearchDiv("30");
		
		searchVO.setStartDate("2021/12/31");
		searchVO.setEndDate("20220105");

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
//		lastVO.setMealContent("콘텐츠가 있긴 했음?");
		
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
	//@Ignore
	public void doInsert() {
		LOG.debug("daoTest) doInsert()=====================");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(meal1);
		assertEquals(1, flag);
		
	}
	
	private void isSameObj(MealVO orgVO, MealVO vsVO) {
		assertEquals(orgVO.getUserId(), vsVO.getUserId());
	}
	

}//--class

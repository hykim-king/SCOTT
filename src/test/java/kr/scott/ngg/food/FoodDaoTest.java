package kr.scott.ngg.food;

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
import kr.scott.ngg.food.dao.FoodDao;
import kr.scott.ngg.food.domain.FoodVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class FoodDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	FoodDao dao;
	
	FoodVO food1, food2, food3;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("daoTest) setUp()=====================");
		LOG.debug("daoTest) setUp => context: "+context);
		LOG.debug("daoTest) setUp => dao: "+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
		
		food1 = new FoodVO(0, "김치볶음밥", 123, 0);
		food2 = new FoodVO(0, "동치미", 1233, 2);
		food3 = new FoodVO(0, "냉면", 1243, 1);
	}


	@Test
	public void orderTest() {
		LOG.debug("daoTest) orderTest =============");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 3건 등록
		dao.doInsert(food1);
		dao.doInsert(food2);
		dao.doInsert(food3);
		assertEquals(3, dao.getCount());
				
		// 정렬
		SearchVO searchVO = new SearchVO();
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		searchVO.setOrderDiv("food_kcal");
		searchVO.setOrderDir("DESC");
		
		List<FoodVO> list = dao.doRetrieve(searchVO);
		assertNotNull(list);
		
		for(FoodVO vo : list) {
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
		dao.doInsert(food1);
		dao.doInsert(food2);
		dao.doInsert(food3);
		assertEquals(3, dao.getCount());
				
		// 검색조건 : food_name
		SearchVO searchVO = new SearchVO();
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		
		searchVO.setSearchDiv("");
		searchVO.setSearchWord("치");
		
		List<FoodVO> list = dao.doRetrieve(searchVO);
		assertNotNull(list);
		
		for(FoodVO vo : list) {
			LOG.debug("-mealdata-> "+vo);
		}
	}
	
	
	@Test
	@Ignore
	public void doUpdate() {
		LOG.debug("daoTest) doUpdate =============");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(food1);
		assertEquals(1, flag);
		
		// 마지막 등록한 값 가져오기 
		FoodVO lastVO = dao.getLastData();
		
		// 값 수정
		lastVO.setFoodCt(3);
		lastVO.setFoodKcal(2342);
		lastVO.setFoodName("초콜렛");
		
		// 수정
		flag = dao.doUpdate(lastVO);
		assertEquals(1, flag);
		
		// 수정한 값 가져와서 비교
		FoodVO vsVO = dao.doSelectOne(lastVO);
		isSameObj(lastVO, vsVO);
	}
	
	
	@Test
	@Ignore
	public void doDelete() {
		LOG.debug("daoTest) doDelete()=====================");
		
		// 전체 삭제
		dao.deleteAll();
		
		// 1건 등록
		int flag = dao.doInsert(food1);
		assertEquals(1, flag);
		
		// 마지막에 등록한 값 가져오기
		FoodVO lastVO = dao.getLastData();
		
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
		int flag = dao.doInsert(food1);
		assertEquals(1, flag);
	}
	
	private void isSameObj(FoodVO foodVO, FoodVO vsVO) {
		assertEquals(foodVO.getFoodSq(), vsVO.getFoodSq());
		assertEquals(foodVO.getFoodName(), vsVO.getFoodName());
		assertEquals(foodVO.getFoodKcal(), vsVO.getFoodKcal());
		assertEquals(foodVO.getFoodCt(), vsVO.getFoodCt());
	}

}

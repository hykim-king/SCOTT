package kr.scott.ngg.meal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

import kr.scott.ngg.meal.dao.MealDao;
import kr.scott.ngg.meal.dao.MealdetailDao;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MealdetailDaoTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MealDao dao;
	
	@Autowired
	MealdetailDao mdao;
	
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
	public void doInsert() {
		dao.deleteAll();

		mdList.add(md1);
		mdList.add(md2);
		mdList.add(md3);
		mdList.add(md4);
		mdList.add(md5);
		mdList.add(md6);
		
		
		
		dao.doInsert(meal1);
		assertEquals(1, dao.getCount());
		
	}

}

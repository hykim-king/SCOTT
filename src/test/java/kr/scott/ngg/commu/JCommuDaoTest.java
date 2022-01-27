/**
 * 
 */
package kr.scott.ngg.commu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
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

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.commu.dao.CommuDao;
import kr.scott.ngg.commu.domain.CommuVO;

/**
 * @author USER
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //applicationContext.xml loading
public class JCommuDaoTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	//spring 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입 한다.
    @Autowired
    ApplicationContext  context;
    
    @Autowired
    CommuDao dao;
    
    CommuVO commu01;
    CommuVO commu02;
    CommuVO commu03;
    
    SearchVO  search;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("1====================");
		LOG.debug("1=context="+context);
		LOG.debug("1=context="+dao);
		
//		CommuVO(int communitySq, String communityTitle, String userId, String communityContent, int communityFile,
//				int communityCt, int communityReadCnt)
		
		commu01=new CommuVO(0, "제목01", "아디01", "내용01", 123, 0, 0);
		commu02=new CommuVO(0, "제목02", "아디02", "내용02", 123, 0, 0);
		commu03=new CommuVO(0, "제목03", "아디03", "내용03", 123, 0, 0);
		
		search = new SearchVO();
		
		assertNotNull(dao);
		assertNotNull(context);
	}
	
	public void name() {
		
	}
	
	@Test
//	@Ignore
	public void testingAll() throws SQLException {
		LOG.debug("====================");
		LOG.debug("=addAndGet()=");
		LOG.debug("====================");
		
		//전체 삭제
		//1건 입력
		
		LOG.debug("=deleteAll()=");
		dao.deleteAll();
		
		LOG.debug("=insertCommu()=");
		assertEquals(1, dao.insertCommu(commu01));
		assertEquals(1, dao.insertCommu(commu02));
		assertEquals(1, dao.insertCommu(commu03));
		
		LOG.debug("=selectKeys()=");
		List<Integer> list=dao.selectKeys();
		assertEquals(3, list.size());
		
//		LOG.debug("=selectCommu()=");
//		assertEquals(1, selVO=dao.selectCommu(43));
//		LOG.debug("selVO: "+selVO);
		//
		LOG.debug("=selectCommu()=");
		CommuVO selVO=dao.selectCommu(list.get(0));
		isSameData(commu01, selVO);
		
		LOG.debug("=updateCommu()=");
		selVO.setCommunityTitle("제목 바꿨지롱");
		selVO.setCommunityContent("내용 바꿨지롱");
		selVO.setCommunityFile(8888);
		assertEquals(1, dao.updateCommu(selVO));
		
		LOG.debug("=deleteCommu()=");
		assertEquals(1, dao.deleteCommu(list.get(1)));
		
		LOG.debug("=updateCnt()=");
		assertEquals(1, dao.updateCnt(list.get(2)));
		
		LOG.debug("=selectSearchCommu()=");
		search.setPageNum(1);
		search.setPageSize(10);
		//10아디 20제목 30내용
		search.setSearchDiv("10");
		search.setSearchWord("아디0");
		assertEquals(2, dao.selectSearchCommu(search).size());
		
	}
	
	private void isSameData(CommuVO vo1, CommuVO vo2) {
		assertEquals(vo1.getCommunityTitle(), vo2.getCommunityTitle());
		assertEquals(vo1.getCommunityContent(), vo2.getCommunityContent());
	}

}

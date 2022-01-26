package kr.scott.ngg.work;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.work.dao.WorkDao;
import kr.scott.ngg.work.domain.WorkVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class WorkControllerTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;

	MockMvc mockMvc;
	
	SearchVO search;
	
	@Autowired
	WorkDao dao;
	
	WorkVO wv01;
	WorkVO wv02;
	WorkVO wv03;
	
	UserVO user01;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

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
		wv01=new WorkVO("앙01", user01.getUserId(), "앙", 0, 0, 0);
		wv02=new WorkVO("앙02", user01.getUserId(), "앙앙", 0, 0, 0);
		wv03=new WorkVO("앙03", user01.getUserId(), "앙앙앙", 0, 0, 0);
		
		search = new SearchVO();
	}
	
	@Test
	public void totalTest()throws Exception{
		
	}
	
	@Test
	public void doRetrieve() throws Exception{
		search.setSearchDiv("20");
		search.setSearchWord("앙");
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.get("/work/doRetrieve.do")
				.param("searchDiv", search.getSearchDiv())
				.param("searchWord", search.getSearchWord())
				.param("pageSize", String.valueOf(search.getPageSize()))
				.param("pageNum", String.valueOf(search.getPageNum()));
		ResultActions resultAction =
				mockMvc.perform(createMessage)
				.andExpect(status().isOk());
		String result = resultAction.andDo(print()).andReturn().getResponse().getContentAsString();

		LOG.debug("========================");
		LOG.debug("result: \n" + result);
		LOG.debug("========================");
		
		Gson gson = new Gson();
		
		List<UserVO> list = gson.fromJson(result, new TypeToken<List<WorkVO>>() {
		}.getType());

		assertEquals(list.size(), 10);
	}
	
	
	@Test
	public void doUpdate()throws Exception{
		LOG.debug("============doUpdate");
		
		dao.deleteAll();
		
		int flag = dao.doInsert(wv01);
		assertEquals(1, flag);
		assertEquals(1, dao.getCount());
		
		WorkVO vs = dao.idLike(wv01);
		isSameWorSq(dao.doSelectOne(vs), wv01);
		
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.post("/work/doUpdate.do")
				.param("workSq", wv01.getWorkSq()+"");
		ResultActions resultAction = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = resultAction.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();

		LOG.debug("========================");
		LOG.debug("result: \n" + result);
		LOG.debug("========================");
		
		Gson gson = new Gson();
		MessageVO reM = gson.fromJson(result, MessageVO.class);
	}
	
	@Test
	public void doDelete()throws Exception{
		LOG.debug("============doDelete");

		wv01.setWorkSq(20041);
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.get("/work/doDelete.do")
				.param("workSq", wv01.getWorkSq()+"");
		ResultActions resultAction = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = resultAction.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();

		LOG.debug("========================");
		LOG.debug("result: \n" + result);
		LOG.debug("========================");
	}
	
	public void doSelectOne() throws Exception{
		wv01.setWorkSq(20041);
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.post("/work/doDelete.do")
				.param("workSq", wv01.getWorkSq()+"");
		ResultActions resultAction = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = resultAction.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();

		LOG.debug("========================");
		LOG.debug("result: \n" + result);
		LOG.debug("========================");
	}
	
	
	@Test
	@Ignore
	public void doInsert() throws Exception{
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/work/doInsert.do")
				.param("workTitle", wv01.getWorkTitle())
				.param("userId", user01.getUserId())
				.param("workContent", wv01.getWorkContent())
				.param("workReadCnt", wv01.getWorkReadCnt()+"")
				.param("workFile", wv01.getWorkFile()+"")
				.param("workCt1", wv01.getWorkCt1()+"");

		ResultActions resultAction = this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = resultAction.andDo(print()).andReturn().getResponse().getContentAsString();

		LOG.debug("========================");
		LOG.debug("result: \n" + result);
		LOG.debug("========================");
	}
	
	private void isSameWorSq(WorkVO outVO,WorkVO userVO) {
		assertEquals(outVO.getWorkSq(), userVO.getWorkSq());
	}
	
}

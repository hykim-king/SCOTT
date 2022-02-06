package kr.scott.ngg.meal.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;
import kr.scott.ngg.meal.service.MealService;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.user.service.UserService;

@Controller("mealController")
@RequestMapping("meal")
public class MealController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MealService mealService;
	
	@Autowired
	UserService userService;
	
	public MealController() {
	}
	
	
	/* ---------------------------- VIEW ---------------------------- */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String mainView(Model model, HttpSession sess) throws SQLException {
		LOG.debug("---------- mainView()");
		
		UserVO asdf = new UserVO();
		asdf.setUserId("pp1kkupp1kku");
		UserVO user = userService.doSelectOne(asdf);
		
		sess.setAttribute("user", user);
		
		SearchVO searchVO = new SearchVO();
//		searchVO.setSearchDiv("99");
//		searchVO.setSearchWord("ppikkuppikku");
		
		model.addAttribute("mealList", mealService.doRetrieve(searchVO));
		
		return "user/contents/meal";
	}
	
	
	/* ---------------------------- END VIEW ---------------------------- */
	


	/* ---------------------------- DATA ---------------------------- */
	
	/* 전체 식단 리스트 */
	@RequestMapping(value="/api/meal", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<MealVO> list = mealService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	/* 식단에 속한 음식 정보들을 불러옴 */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doSelectDetail(@PathVariable int mealSq) throws SQLException {
		LOG.debug("ctrl) doSelectDetail() ===================== ");

		MealVO inVO = new MealVO();
		inVO.setMealSq(mealSq);
		
		// 객체 조회
		List<MealdetailVO> list = mealService.getMealdetailList(inVO);
		if(list == null) return new Gson().toJson(new MessageVO("0", "요청하신 식단 정보를 불러올 수 없습니다."));

		return new Gson().toJson(list);
	}
	
	/* 식단 수정 */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.PUT, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doUpdate(@RequestBody Map<String, Object> map) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+map.get("meal"));
		LOG.debug("ctrl) doUpdate => param: "+map.get("mdList"));
		LOG.debug("ctrl) doUpdate => param: "+map.get("delList"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		MealVO mealVO = mapper.convertValue(map.get("meal"), new TypeReference<MealVO>(){});
		List<MealdetailVO> mdList = mapper.convertValue(map.get("mdList"), new TypeReference<List<MealdetailVO>>(){});
		String delList = mapper.convertValue(map.get("delList"), new TypeReference<String>(){});
		
		List<Integer> delSqlist = new ArrayList<Integer>();
		if(delList != null && delList.trim().length() > 0) {
			for(String str:delList.split(",")) {
				if(str.equals("")) continue;
				delSqlist.add(Integer.parseInt(str));
			}
		}
		
		// 수정
		int flag = mealService.tdoUpdate(mealVO, mdList, delSqlist);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag != 0)? "식단이 저장되었습니다.": "식단 저장 중 문제가 발생하였습니다.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	
	/* 식단 삭제 */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.DELETE, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doDelete(@PathVariable int mealSq) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");

		MealVO inVO = new MealVO();
		inVO.setMealSq(mealSq);
		
		// 삭제
		int flag = mealService.tdoDelete(inVO);
		
		// msgId: 삭제성공(1), 삭제실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "식단이 삭제되었습니다.": "식단 삭제 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	

	/* 식단 등록 */
	@RequestMapping(value="/api/meal", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doInsert(@RequestBody Map<String, Object> map) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+map.get("meal"));
		LOG.debug("ctrl) doInsert => param: "+map.get("mdList"));

		ObjectMapper mapper = new ObjectMapper();
		
		MealVO meal = mapper.convertValue(map.get("meal"), new TypeReference<MealVO>(){});
		List<MealdetailVO> mdList = mapper.convertValue(map.get("mdList"), new TypeReference<List<MealdetailVO>>(){});
		
		// 등록
		int flag = mealService.tdoInsert(meal, mdList);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag != 0)? "식단을 등록하었습니다.": "식단 등록 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
}

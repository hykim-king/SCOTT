package kr.scott.ngg.meal.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;
import kr.scott.ngg.meal.service.MealService;
import kr.scott.ngg.meal.service.MealdetailService;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.user.service.UserService;

@Controller("mealController")
@RequestMapping("meal")
public class MealController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MealService mealService;
	
	@Autowired
	MealdetailService mealdetailService;
	
	@Autowired
	UserService userService;
	
	public MealController() {
	}
	
	
	/* ---------------------------- VIEW ---------------------------- */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String mainView(Model model, HttpSession sess) throws SQLException {
		LOG.debug("---------- mainView()");
		
		UserVO asdf = new UserVO();
		asdf.setUserId("test");
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
	
	/* ?????? ?????? ????????? */
	@RequestMapping(value="/api/meal", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doRetrieve(@RequestBody SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<MealVO> list = mealService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "???????????? ???????????? ????????????."));
		
		return new Gson().toJson(list);
	}
	
	/* ????????? ?????? ?????? ???????????? ????????? */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doSelectDetail(@PathVariable int mealSq) throws SQLException {
		LOG.debug("ctrl) doSelectDetail() ===================== ");

		MealVO inVO = new MealVO();
		inVO.setMealSq(mealSq);
		
		// ?????? ??????
		List<MealdetailVO> list = mealdetailService.doRetrieve(inVO);
		if(list == null) return new Gson().toJson(new MessageVO("0", "???????????? ?????? ????????? ????????? ??? ????????????."));

		return new Gson().toJson(list);
	}
	
	/* ?????? ?????? */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.PUT, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doUpdate(@PathVariable int mealSq, @RequestBody Map<String, Object> reqMap) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		
		MealVO mealVO = (MealVO) reqMap.get("mealVO");
		List<MealdetailVO> list = (List<MealdetailVO>) reqMap.get("mealdetailVO");
		
		// ??????
		int flag = mealService.tdoUpdate(mealVO, list);
		
		// msgId: ????????????(1), ????????????(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag != 0)? "????????? ?????????????????????.": "?????? ?????? ??? ????????? ?????????????????????.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	/* ?????? ?????? */
	@RequestMapping(value="/api/meal/{mealSq}", method=RequestMethod.DELETE, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doDelete(@PathVariable int mealSq) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");

		MealVO inVO = new MealVO();
		inVO.setMealSq(mealSq);
		
		// ??????
		int flag = mealService.tdoDelete(inVO);
		
		// msgId: ????????????(1), ????????????(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "????????? ?????????????????????.": "?????? ?????? ??? ????????? ?????????????????????.");
		
		return new Gson().toJson(msgVO);
	}
	

	/* ?????? ?????? */
	@RequestMapping(value="/api/meal", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doInsert(@RequestBody Map<String, Object> reqMap) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+reqMap);
		
		MealVO mealVO = (MealVO) reqMap.get("mealVO");
		MealdetailVO[] list = (MealdetailVO[]) reqMap.get("mealdetailVO");
		

		// ??????
		int flag = mealService.tdoInsert(mealVO, list);
		
		// msgId: ????????????(1), ????????????(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag != 0)? "????????? ?????????????????????.": "?????? ?????? ??? ????????? ?????????????????????.");
		
		return new Gson().toJson(msgVO);
	}
	
	
}

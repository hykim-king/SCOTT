package kr.scott.ngg.meal.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.service.MealService;

@Controller("mealController")
@RequestMapping("meal")
public class MealController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MealService mealService;
	
	public MealController() {
	}
	
	
	/* ---------------------------- VIEW ---------------------------- */
	
	/* ---------------------------- END VIEW ---------------------------- */
	


	/* ---------------------------- LOGIC ---------------------------- */

	@RequestMapping(value="/doRetrieve", method=RequestMethod.GET)
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<MealVO> list = mealService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/doSelectOne", method=RequestMethod.GET)
	public String doSelectOne(MealVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);

		// 객체 조회
		MealVO outVO = mealService.doSelectOne(inVO);
		if(outVO == null) return new Gson().toJson(new MessageVO("0", "요청하신 식단 정보를 불러올 수 없습니다."));

		return new Gson().toJson(outVO);
	}
	
	@RequestMapping(value="/doUpdate", method=RequestMethod.PUT)
	public String doUpdate(MealVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);
		
		// 수정
		int flag = mealService.doUpdate(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "식단이 수정되었습니다.": "식단 수정 중 문제가 발생하였습니다.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/doDelete", method=RequestMethod.DELETE)
	public String doDelete(MealVO inVO) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");
		LOG.debug("ctrl) doDelete => param: "+inVO);

		// 삭제
		int flag = mealService.doDelete(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "식단이 삭제되었습니다.": "식단 삭제 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/doInsert", method=RequestMethod.POST)
	public String doInsert(MealVO inVO) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+inVO);
		
		// 등록
		int flag = mealService.doInsert(inVO);
		
		// msgId: 수정성공(1), 수정실패(0), 입력X(30)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "식단을 등록하었습니다.": "식단 등록 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	/* ---------------------------- END LOGIC ---------------------------- */
	
}

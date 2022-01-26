package kr.scott.ngg.food.controller;

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
import kr.scott.ngg.cmn.StringUtil;
import kr.scott.ngg.food.domain.FoodVO;
import kr.scott.ngg.food.service.FoodService;

@Controller("foodController")
@RequestMapping("food")
public class FoodController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	FoodService foodService;
	
	public FoodController() {
	}
	
	
	/* ---------------------------- VIEW ---------------------------- */
	
	/* ---------------------------- END VIEW ---------------------------- */
	


	/* ---------------------------- LOGIC ---------------------------- */

	@RequestMapping(value="/doRetrieve.do", method=RequestMethod.GET)
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<FoodVO> list = foodService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/doSelectOne.do", method=RequestMethod.GET)
	public String doSelectOne(FoodVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);

		// 객체 조회
		FoodVO outVO = foodService.doSelectOne(inVO);
		if(outVO == null) return new Gson().toJson(new MessageVO("0", "요청하신 음식 데이터 정보를 불러올 수 없습니다."));

		return new Gson().toJson(outVO);
	}
	
	@RequestMapping(value="/doUpdate.do", method=RequestMethod.PUT)
	public String doUpdate(FoodVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 validation
		msgVO = StringUtil.checkRequiredValue(inVO.getFoodName(), "음식 이름");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		// 수정
		int flag = foodService.doUpdate(inVO);
		
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "음식 데이터가 수정되었습니다.": "음식 데이터 수정 중 문제가 발생하였습니다.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/doDelete.do", method=RequestMethod.DELETE)
	public String doDelete(FoodVO inVO) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");
		LOG.debug("ctrl) doDelete => param: "+inVO);

		// 삭제
		int flag = foodService.doDelete(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "음식 데이터가 삭제되었습니다.": "음식 데이터 삭제 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/doInsert.do", method=RequestMethod.POST)
	public String doInsert(FoodVO inVO) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+inVO);
		
		// msgId: 수정성공(1), 수정실패(0), 입력X(30)
		MessageVO msgVO = new MessageVO();

		// 입력된 값 validation
		msgVO = StringUtil.checkRequiredValue(inVO.getFoodName(), "음식 이름");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		// 등록
		int flag = foodService.doInsert(inVO);

		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "음식 데이터를 등록하었습니다.": "음식 데이터 등록 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	/* ---------------------------- END LOGIC ---------------------------- */
	
}
package kr.scott.ngg.report.controller;

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
import kr.scott.ngg.report.domain.ReportVO;
import kr.scott.ngg.report.service.ReportService;

@Controller("reportController")
@RequestMapping("report")
public class ReportController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReportService reportService;
	
	public ReportController() {
	}
	
	
	/* ---------------------------- VIEW ---------------------------- */
	
	/* ---------------------------- END VIEW ---------------------------- */
	


	/* ---------------------------- LOGIC ---------------------------- */

	@RequestMapping(value="/doRetrieve", method=RequestMethod.GET)
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<ReportVO> list = reportService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/doSelectOne", method=RequestMethod.GET)
	public String doSelectOne(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);

		// 객체 조회
		ReportVO outVO = reportService.doSelectOne(inVO);
		if(outVO == null) return new Gson().toJson(new MessageVO("0", "요청하신 신고 정보를 불러올 수 없습니다."));

		return new Gson().toJson(outVO);
	}
	
	@RequestMapping(value="/doUpdate", method=RequestMethod.PUT)
	public String doUpdate(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);
		
		// 수정
		int flag = reportService.doUpdate(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "신고 내용이 수정되었습니다.": "신고 수정 중 문제가 발생하였습니다.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/doDelete", method=RequestMethod.DELETE)
	public String doDelete(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");
		LOG.debug("ctrl) doDelete => param: "+inVO);

		// 삭제
		int flag = reportService.doDelete(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "신고 내용이 삭제되었습니다.": "신고 삭제 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/doInsert", method=RequestMethod.POST)
	public String doInsert(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+inVO);
		
		// 등록
		int flag = reportService.doInsert(inVO);
		
		// msgId: 수정성공(1), 수정실패(0), 입력X(30)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "신고 내용을 등록하었습니다.": "신고 등록 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	/* ---------------------------- END LOGIC ---------------------------- */
	
}
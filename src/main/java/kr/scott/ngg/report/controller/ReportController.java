package kr.scott.ngg.report.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	ReportService rService;
	
	@Autowired
	@Qualifier("mailSender")
	MailSender mailSender;
	
	public ReportController() {}
	
	@RequestMapping(value = "/doReport.do")
	public String reportPopup() throws SQLException {
		LOG.debug("========================");
		LOG.debug("reportpopup");
		LOG.debug("========================");
		return "report/report_popup";
	}
	
	
	@RequestMapping(value = "/doInsert.do",method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String report(ReportVO inVO) throws SQLException{
		LOG.debug("========================");
		LOG.debug("inVO: "+inVO);
		LOG.debug("========================");
		String resultMsg = "";
		
		int flag = rService.doInsert(inVO);
		if(1==flag) {
			resultMsg = "신고가 접수되었습니다";
			sendReportMail(inVO); 
		}else {
			resultMsg = "신고 실패";
		}
		
		MessageVO message = new MessageVO(flag+"",resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("jsonString: "+jsonString);
		return jsonString;
	}
	
	
	private void sendReportMail(ReportVO report) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo("aprk45@naver.com"); //관리자 이메일 
		simpleMessage.setFrom("www.ngg.com");
		simpleMessage.setSubject("신고접수");
		
		simpleMessage.setText("게시구분 "+report.getTypeSq()+"번," +report.getReportCcSq()+"번 게시물에 "+report.getReportUser() + "사용자가 "
		+ report.getReportCt()+"번 항목에 위배되는 신고가 접수되었습니다. 상세 내역은"+report.getReportCt());
		
		mailSender.send(simpleMessage);
	}
	
	@RequestMapping(value="/doRetrieve.do", method=RequestMethod.GET)
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		List<ReportVO> list = rService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/doSelectOne.do", method=RequestMethod.GET)
	public String doSelectOne(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);

		// 객체 조회
		ReportVO outVO = rService.doSelectOne(inVO);
		if(outVO == null) return new Gson().toJson(new MessageVO("0", "요청하신 신고 정보를 불러올 수 없습니다."));

		return new Gson().toJson(outVO);
	}
	
	@RequestMapping(value="/doUpdate.do", method=RequestMethod.PUT)
	public String doUpdate(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");
		LOG.debug("ctrl) doUpdate => param: "+inVO);
		
		// 수정
		int flag = rService.doUpdate(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "신고 내용이 수정되었습니다.": "신고 수정 중 문제가 발생하였습니다.");
		
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/doDelete.do", method=RequestMethod.DELETE)
	public String doDelete(ReportVO inVO) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");
		LOG.debug("ctrl) doDelete => param: "+inVO);

		// 삭제
		int flag = rService.doDelete(inVO);
		
		// msgId: 수정성공(1), 수정실패(0)
		MessageVO msgVO = new MessageVO();
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "신고 내용이 삭제되었습니다.": "신고 삭제 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
}
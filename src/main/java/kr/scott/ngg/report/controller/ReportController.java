package kr.scott.ngg.report.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.report.domain.ReportVO;
import kr.scott.ngg.report.service.ReportService;

@Controller("ReportController")
@RequestMapping("report")
public class ReportController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReportService rService;
	
	
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
			//sendReportMail(); --???
		}else {
			resultMsg = "신고 실패";
		}
		
		MessageVO message = new MessageVO(flag+"",resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("jsonString: "+jsonString);
		return jsonString;
	}
	
	
	
	
	
	private void sendReportMail(ReportVO report, Model model) {
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(); //관리자 이메일 
		simpleMessage.setFrom("www.ngg.com");
		simpleMessage.setSubject("신고접수");
		
		//simpleMessage.setText(user.getName() + "사용자가 " + report.getReportCcSq.name() + "게시물에 "+report.getReportCt.name()+
		// "로 신고했습니다.");
		mailSender.send(simpleMessage);
	}
	
}

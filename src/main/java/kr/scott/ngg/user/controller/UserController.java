package kr.scott.ngg.user.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.cmn.StringUtil;
import kr.scott.ngg.user.domain.UserVO;
import kr.scott.ngg.user.service.UserService;

@Controller("userController")
@RequestMapping("user")
public class UserController {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	UserService userService;
	
	public UserController() {
	}
	
	
	// 로그인 완료 안되면 메인
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainView() {
		return "user/contents/main";
	}
	
	// 로그인 완료되면 메인
	public String myPageView() {
		return "";
	}

	// 가입화면
	public String registView() {
		return "";
	}
	
	// 정보 수정
	public String modifyView() {
		return "";
	}
	
	// 비밀번호 찾기
	public String findPwView() {
		return "";
	}
	
	// 탈퇴 화면
	public String withdrawalView() {
		return "";
	}
	
	
	
	@RequestMapping(value="/api/user", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doRetrieve(SearchVO inVO) throws SQLException {
		LOG.debug("ctrl) doRetrieve() ===================== ");
		LOG.debug("ctrl) doRetrieve => param: "+inVO);
		
		// 목록 검색
		List<UserVO> list = userService.doRetrieve(inVO);
		if(list == null || list.size() < 1) return new Gson().toJson(new MessageVO("0", "데이터가 존재하지 않습니다."));
		
		return new Gson().toJson(list);
	}
	
	
	@RequestMapping(value="/api/user/{userId}", method=RequestMethod.GET, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doSelectOne(@PathVariable String userId) throws SQLException {
		LOG.debug("ctrl) doSelectOne() ===================== ");
		
		UserVO inVO = new UserVO();
		inVO.setUserId(userId);
		inVO = userService.doSelectOne(inVO);
		
		// 조회
		UserVO outVO = userService.doSelectOne(inVO);
		if(outVO == null) return new Gson().toJson(new MessageVO("0", "요청하신 회원 정보를 불러올 수 없습니다."));
		
		return new Gson().toJson(outVO);
	}
	
	
	@RequestMapping(value="/api/user/{userId}", method=RequestMethod.PUT, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doUpdate(@PathVariable String userId, @RequestBody UserVO inVO) throws SQLException {
		LOG.debug("ctrl) doUpdate() ===================== ");

		// msgId: 수정성공(1), 수정실패(0), 입력X(30)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 validation (필수입력사항: id, pw, name, mail, birth, gender)
		// id
		msgVO = StringUtil.checkRequiredValue(inVO.getUserId(), "아이디");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
		
		// pw
		msgVO = StringUtil.checkRequiredValue(inVO.getUserPw(), "비밀번호");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
	
		// name
		msgVO = StringUtil.checkRequiredValue(inVO.getUserNn(), "닉네임");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
		
		// 유저 정보 수정
		int flag = userService.doUpdate(inVO);
		
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "정보가 수정되었습니다.": "정보 수정 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/api/user/{userId}", method=RequestMethod.DELETE, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doDelete(@PathVariable String userId) throws SQLException {
		LOG.debug("ctrl) doDelete() ===================== ");
		LOG.debug("ctrl) doDelete => param: "+userId);
		
		// msgId: 탈퇴성공(1), 탈퇴실패(0)
		MessageVO msgVO = new MessageVO();

		UserVO inVO = new UserVO();
		inVO.setUserId(userId);
		inVO = userService.doSelectOne(inVO);
		
		if(inVO == null) {
			msgVO.setMsgId("0");
			msgVO.setMsgContent("아이디를 찾을 수 없습니다.");
			
			return new Gson().toJson(msgVO);
		}
		
		// 입력 데이터 validation
		// pw
		msgVO = StringUtil.checkRequiredValue(inVO.getUserPw(), "비밀번호");
		LOG.debug("ctrl) doDelete => msgVO: "+msgVO);
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		// 탈퇴: 진짜 삭제하지 않고 is_active=0 처리
		inVO.setUserIsActive(0);
		
		int flag = userService.doUpdate(inVO);
		LOG.debug("ctrl) doDelete => flag: "+flag);

		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "탈퇴되었습니다.": "탈퇴 중 문제가 발생하였습니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/api/user", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doInsert(@RequestBody UserVO inVO) throws SQLException {
		LOG.debug("ctrl) doInsert() ===================== ");
		LOG.debug("ctrl) doInsert => param: "+inVO);
		
		// msgId: 등록 성공(10), DB에 맞는 정보 X(20), 입력X(30)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 validation (필수입력사항: id, pw, name, mail, birth, gender)
		// id
		msgVO = StringUtil.checkRequiredValue(inVO.getUserId(), "아이디");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
		
		// pw
		msgVO = StringUtil.checkRequiredValue(inVO.getUserPw(), "비밀번호");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
	
		// name
		msgVO = StringUtil.checkRequiredValue(inVO.getUserNn(), "닉네임");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
		
		
		// 유저 등록
		int flag = userService.doInsert(inVO);
		LOG.debug("ctrl) doInsert => flag: "+flag);
				
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 1)? "가입 완료 되었습니다.": "가입 중 문제가 발생하였습니다.");

		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/api/user/nnCheck", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String nnCheck(UserVO inVO) throws SQLException {
		LOG.debug("ctrl) nnCheck() ===================== ");
		LOG.debug("ctrl) nnCheck => param: "+inVO);
		
		// msgId: 중복 닉네임(1), 사용가능(0), 입력X(30)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 확인
		// name
		msgVO = StringUtil.checkRequiredValue(inVO.getUserNn(), "닉네임");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		
		// 닉네임 중복 체크
		int flag = userService.nnCheck(inVO);
		LOG.debug("ctrl) nnCheck => flag: "+flag);
		
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 0)? "사용 가능한 닉네임입니다." : "이미 사용 중인 닉네임입니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/api/user/idCheck", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String idCheck(UserVO inVO) throws SQLException {
		LOG.debug("ctrl) idCheck() ===================== ");
		LOG.debug("ctrl) idCheck => param: "+inVO);
		
		// msgId: 중복 아이디(1), 사용가능(0), 입력X(30)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 확인
		// id
		msgVO = StringUtil.checkRequiredValue(inVO.getUserId(), "아이디");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		
		// 아이디 중복 체크
		int flag = userService.idCheck(inVO);
		LOG.debug("ctrl) idCheck => flag: "+flag);
		
		msgVO.setMsgId(flag+"");
		msgVO.setMsgContent((flag == 0)? "사용 가능한 아이디입니다." : "이미 사용 중인 아이디입니다.");
		
		return new Gson().toJson(msgVO);
	}
	
	
	@RequestMapping(value="/api/user/login", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doLogin(@RequestBody UserVO inVO, HttpSession sess) throws SQLException {
		LOG.debug("ctrl) doLogin() ===================== ");
		LOG.debug("ctrl) doLogin => param: "+inVO);
		
		// msgId: 로그인성공(10), DB에 맞는 정보 X(20), 입력X(30), 탈퇴한 회원(40)
		MessageVO msgVO = new MessageVO();
		
		// 입력된 값 validation
		// 아이디
		msgVO = StringUtil.checkRequiredValue(inVO.getUserId(), "아이디");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);

		// 비밀번호
		msgVO = StringUtil.checkRequiredValue(inVO.getUserPw(), "비밀번호");
		if(msgVO.getMsgId().equals("30")) return new Gson().toJson(msgVO);
		
		
		// DB 정보 확인
		msgVO = userService.doLogin(inVO);
		LOG.debug("ctrl) doLogin => msgVO: "+msgVO);
		
		
		// 로그인 성공
		if(msgVO.getMsgId().equals("10")) {
			UserVO loginVO = userService.doSelectOne(inVO);
			
			if(loginVO != null) {
				if(loginVO.getUserIsActive() == 0) { // 탈퇴한 회원
					msgVO.setMsgId("40");
					msgVO.setMsgContent("탈퇴한 회원입니다.");
					
				} else {
					// 최종 접속일 업데이트
					int flag = userService.updateLastLogin(loginVO);
					
					if (flag == 1) {
						sess.setAttribute("user", loginVO); // 세션에 로그인 정보 저장
						msgVO.setMsgContent("["+loginVO.getUserId()+"] 님 로그인 되었습니다."); // 메세지 반환
					}
				}
			}
		}
		
		return new Gson().toJson(msgVO);
	}
	
	@RequestMapping(value="/api/user/logout", method=RequestMethod.POST, 
			produces = "application/json; charset=utf-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doLogout(HttpSession sess) throws SQLException {
		LOG.debug("ctrl) doLogout() ===================== ");
		
		if(sess.getAttribute("user") == null) {
			return new Gson().toJson(new MessageVO("0", "로그인 정보를 찾을 수 없습니다."));
		}

		sess.removeAttribute("user");
		sess.invalidate();
		
		return new Gson().toJson(new MessageVO("1", "로그아웃 되었습니다."));
	}
	
	
}//--class

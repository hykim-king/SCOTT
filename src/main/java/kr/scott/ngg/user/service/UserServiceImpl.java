package kr.scott.ngg.user.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.PieVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.user.dao.UserDao;
import kr.scott.ngg.user.domain.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	UserDao dao;
	
	public UserServiceImpl() {
	}

	@Override
	public int doInsert(UserVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		return dao.doUpdate(inVO);
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<UserVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}
	
	
	// --------------------- User functions
	@Override
	public MessageVO doLogin(UserVO inVO) throws SQLException {
		LOG.debug("service) doLogin --------------------------");
		// msgId: 로그인성공(10), DB에 맞는 정보 X(20), 입력X(30), 탈퇴한 회원(40)
		
		int flag = 0;
		MessageVO msg = new MessageVO();
		
		// 입력된 값 확인
		flag = dao.pwCheck(inVO);
		
		// DB에 일치하는 정보가 없을 때
		if(flag == 0) {
			msg.setMsgId("20");
			msg.setMsgContent("아이디/비밀번호를 확인해주세요");
		}
		
		// DB에 일치하는 정보가 있을 때
		msg.setMsgId("10");
		msg.setMsgContent("로그인 성공");
		
		return msg;
	}

	@Override
	public int idCheck(UserVO inVO) {
		return dao.idCheck(inVO);
	}

	@Override
	public int nnCheck(UserVO inVO) {
		return dao.nnCheck(inVO);
	}
	
	@Override
	public int updateLastLogin(UserVO inVO) throws SQLException {
		return dao.updateLastLogin(inVO);
	}

	// --------------------- ADMIN functions

	@Override
	public List<PieVO> getDailyRegCnt(String dateStr) throws SQLException {
		return dao.getDailyRegCnt(dateStr);
	}

	@Override
	public List<PieVO> getWeeklyRegCnt(String dateStr) throws SQLException {
		return dao.getWeeklyRegCnt(dateStr);
	}

}

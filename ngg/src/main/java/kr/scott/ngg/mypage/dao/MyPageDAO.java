package kr.scott.ngg.mypage.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.scott.ngg.user.vo.UserVO;

public interface MyPageDAO {
	public void updateMyInfo(Map memberMap) throws DataAccessException;
	public UserVO selectMyInfo(String userId) throws DataAccessException;
}

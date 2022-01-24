package kr.scott.ngg.user.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.scott.ngg.user.vo.UserVO;

public interface UserDAO {
	public UserVO login(Map loginMap) throws DataAccessException;
	public void insertUser(UserVO userVO) throws DataAccessException;
	public String selectOverlappedID(String id) throws DataAccessException;
}
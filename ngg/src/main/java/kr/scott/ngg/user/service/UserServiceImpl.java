package kr.scott.ngg.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import kr.scott.ngg.user.dao.UserDAO;
import kr.scott.ngg.user.vo.UserVO;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO login(Map loginMap) throws Exception{
		return userDAO.login(loginMap);
	}
	
	@Override
	public void register(UserVO userVO) throws Exception{
		userDAO.insertUser(userVO);
	}
	
	@Override
	public String overlapped(String userId) throws Exception{
		return userDAO.selectOverlappedID(userId);
	}
}


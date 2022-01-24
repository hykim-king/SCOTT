package kr.scott.ngg.user.service;

import java.util.Map;

import kr.scott.ngg.user.vo.UserVO;

public interface UserService {
	public UserVO login(Map loginMap) throws Exception;
	public void register(UserVO userVO) throws Exception;
	public String overlapped(String userId) throws Exception;
}

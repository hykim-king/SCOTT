package kr.scott.ngg.mypage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import kr.scott.ngg.mypage.dao.MyPageDAO;
import kr.scott.ngg.user.vo.UserVO;

public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	private MyPageDAO myPageDAO;

	@Override
	public UserVO modifyMyInfo(Map memberMap) throws Exception{
		 String userId=(String)memberMap.get("userId");
		 myPageDAO.updateMyInfo(memberMap);
		 return myPageDAO.selectMyInfo(userId);
	}
	
	public UserVO myDetailInfo(String userId) throws Exception{
		return myPageDAO.selectMyInfo(userId);
	}
}

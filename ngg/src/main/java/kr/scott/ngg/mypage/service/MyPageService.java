package kr.scott.ngg.mypage.service;

import java.util.Map;

import kr.scott.ngg.user.vo.UserVO;

public interface MyPageService {
	public UserVO modifyMyInfo(Map userMap) throws Exception;
	public UserVO myDetailInfo(String userId) throws Exception;

}

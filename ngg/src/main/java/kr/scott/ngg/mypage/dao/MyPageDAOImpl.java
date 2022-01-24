package kr.scott.ngg.mypage.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.user.vo.UserVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void updateMyInfo(Map memberMap) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMyInfo",memberMap);
	}
	
	@Override
	public UserVO selectMyInfo(String userId) throws DataAccessException{
		UserVO userVO=(UserVO)sqlSession.selectOne("mapper.mypage.selectMyInfo",userId);
		return userVO;
		
	}
}


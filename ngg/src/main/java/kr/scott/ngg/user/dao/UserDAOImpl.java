package kr.scott.ngg.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.user.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVO login(Map loginMap) throws DataAccessException {
		UserVO userVO = (UserVO) sqlSession.selectOne("mapper.user.login", loginMap);
		return userVO;
	}

	@Override
	public void insertUser(UserVO userVO) throws DataAccessException {
		sqlSession.insert("mapper.user.insertUser", userVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.user.selectOverlappedID",id);
		return result;
	}

}

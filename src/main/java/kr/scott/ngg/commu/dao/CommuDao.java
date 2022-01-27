package kr.scott.ngg.commu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.commu.domain.CommuVO;

@Repository("commuDao")
public class CommuDao {
final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	SqlSessionTemplate  sqlSessionTemplate;
	
	final String NAMESPACE = "kr.scott.ngg.CommuMapper";
	
	public CommuDao() {	}
	
//	게시판 필요 기능들
//	1. 게시물 목록 보여주기.ㅇ
//	2. 게시물 자세히 보여주기.ㅇ
//	3. 게시물 등록.ㅇ
//	4. 게시물 수정.ㅇ
//	5. 게시물 삭제.ㅇ
//	6. 조회수 증가.ㅇ
//	7. 게시물 검색하기.ㅇ
//	임시1. 전체 삭제하기.ㅇ
//	임시2. key값들 가져오기.ㅇ
	
	//3. 게시물 등록.(완)
	public int insertCommu(CommuVO inVO) throws SQLException {
		
		String statement = NAMESPACE + ".insertCommu";
		
		return sqlSessionTemplate.insert(statement, inVO);
	}
	
	//4. 게시물 수정.(완)
	public int updateCommu(CommuVO inVO) throws SQLException {
		
		String statement = NAMESPACE + ".updateCommu";
		
		return sqlSessionTemplate.update(statement, inVO);
	}
	
	//5. 게시물 삭제.(완)
	public int deleteCommu(int communitySq) throws SQLException {
		
		String statement = NAMESPACE + ".deleteCommu";
		
		return sqlSessionTemplate.delete(statement, communitySq);
	}
	
	//2. 게시물 자세히 보여주기.(완)
	public CommuVO selectCommu(int communitySq) {
		
		String statement = NAMESPACE + ".selectCommu";
		
		return sqlSessionTemplate.selectOne(statement, communitySq);
	}
	
	//6. 조회수 증가.(완)
	public int updateCnt(int communitySq) {
		
		String statement = NAMESPACE + ".updateCnt";
		
		return sqlSessionTemplate.update(statement, communitySq);
	}
	
	//1. 게시물 목록 보여주기.(완)
	//7. 게시물 검색하기.(완)
	public List<CommuVO> selectSearchCommu(SearchVO inVO) throws SQLException {
		
		String statement = NAMESPACE + ".selectSearchCommu";
		
		return sqlSessionTemplate.selectList(statement, inVO);
	}
	
	//테스트
	/////////////////////
	
	//임시1. 전체 삭제하기.(완)
	public void deleteAll()	throws SQLException {
		String statement = NAMESPACE+".deleteAll";
	   	LOG.debug("==============================");
		LOG.debug("=statement="+statement);		
		
		int flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=flag="+flag);
		LOG.debug("==============================");
	}
	
	//임시2. key값들 가져오기.(완)
	public List<Integer> selectKeys() {
		
//		List<Integer> list =new ArrayList<Integer>();
		
		String statement = NAMESPACE + ".selectKeys";
		
		return sqlSessionTemplate.selectList(statement);
	}
	
}

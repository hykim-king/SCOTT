package kr.scott.ngg.commt.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.commt.domain.CommtVO;

@Repository("commtDao")
public class CommtDao {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	SqlSessionTemplate  sqlSessionTemplate;
	
	final String NAMESPACE = "kr.scott.ngg.CommtMapper";
	
	public CommtDao() {	}
	
	//게시물의 댓글들 select
	public List<CommtVO> selectPageCommt(int communitySq) throws SQLException {
		
		List<CommtVO> list =new ArrayList<CommtVO>();
		
		String statement = NAMESPACE + ".selectPageCommt";
		
		list = sqlSessionTemplate.selectList(statement, communitySq);
		
		return list;
	}
	
	//댓글 insert
	public int insertCommt(CommtVO inVO) throws SQLException {
		
		String statement = NAMESPACE + ".insertCommt";
		
		return sqlSessionTemplate.insert(statement, inVO);
	}
	
	//댓글 delete
	public int deleteCommt(int comment_sq) {
		
		String statement = NAMESPACE + ".deleteCommt";
		
		return sqlSessionTemplate.delete(statement, comment_sq);
	}
	
	//댓글 update
	public int updateCommt(CommtVO inVO) {
		
		String statement = NAMESPACE + ".updateCommt";
		
		return sqlSessionTemplate.update(statement, inVO);
	}
	
	///////////////test
	
	/////////////////
	
	public int getCount() throws SQLException {
		String statement = NAMESPACE +".getCount";
		return sqlSessionTemplate.selectOne(statement);
	}
	
	public void deleteAll() throws SQLException {
		String statement = NAMESPACE+".deleteAll";
	   	LOG.debug("==============================");
		LOG.debug("=statement="+statement);		
		
		int flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=flag="+flag);
		LOG.debug("==============================");
	}
	
	public int doInsert(CommtVO inVO) throws SQLException{
		int flag = 0;
		String statement = NAMESPACE+".doInsert";
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=statement="+statement);
			
		flag = sqlSessionTemplate.insert(statement, inVO);
		
		LOG.debug("=flag="+flag);
		LOG.debug("==============================");
		return flag;
	}

}

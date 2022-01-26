package kr.scott.ngg.user.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.cmn.PieVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.user.domain.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	final String NAMESPACE = "kr.scott.ngg.UserMapper";

	public UserDaoImpl() {
	}

	@Override
	public int doInsert(UserVO inVO) {
		LOG.debug("dao) doInsert => param: "+inVO);
		
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("dao) doInsert => statement: "+statement);

		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao) doInsert => flag: "+flag);
		
		return flag;
	}

	@Override
	public int doDelete(UserVO inVO) {
		LOG.debug("dao) doDelete => param: "+inVO);
		
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("dao) doDelete => statement: "+statement);

		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("dao) doDelete => flag: "+flag);
		
		return flag;
	}

	@Override
	public int doUpdate(UserVO inVO) {
		LOG.debug("dao) doUpdate => param: "+inVO);
		
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("dao) doUpdate => statement: "+statement);

		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("dao) doUpdate => flag: "+flag);
		
		return flag;
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) {
		LOG.debug("dao) doSelectOne => param: "+inVO);

		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("dao) doSelectOne => statement: "+statement);
		
		UserVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("dao) doSelectOne => outVO: "+outVO);
		
		return outVO;
	}

	@Override
	public List<UserVO> doRetrieve(SearchVO inVO) {
		LOG.debug("dao) doRetrieve => param: "+inVO);
		
		String statement = NAMESPACE + ".doRetrieve";
		LOG.debug("dao) doRetrieve => statement: "+statement);
		
		List<UserVO> list = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("dao) doRetrieve => list: "+list);
		
		return list;
	}

	@Override
	public List<UserVO> getAll() {
		String statement = NAMESPACE + ".getAll";
		LOG.debug("dao) getAll => statement: "+statement);
		
		List<UserVO> list = this.sqlSessionTemplate.selectList(statement);
		LOG.debug("dao) getAll => list: "+list);
		
		return list;
	}

	// ---------------------------------------------------------
	@Override
	public int getCount() {
		String statement = NAMESPACE + ".getCount";
		LOG.debug("dao) getCount => statement: "+statement);
		
		int flag = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("dao) getCount => flag: "+flag);
		
		return flag;
	}

	@Override
	public void deleteAll() {
		String statement = NAMESPACE + ".deleteAll";
		LOG.debug("dao) deleteAll => statement: "+statement);

		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("dao) deleteAll => flag: "+flag);
	}
	
	// --------------------- User functions
	@Override
	public int pwCheck(UserVO inVO) {
		LOG.debug("dao) pwCheck => param: "+inVO);

		String statement = NAMESPACE + ".pwCheck";
		LOG.debug("dao) pwCheck => statement: "+statement);
		
		int flag = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("dao) pwCheck => flag: "+flag);
		
		return flag;
	}
	
	@Override
	public int idCheck(UserVO inVO) {
		LOG.debug("dao) idCheck => param: "+inVO);
		
		String statement = NAMESPACE + ".idCheck";
		LOG.debug("dao) idCheck => statement: "+statement);
		
		int flag = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("dao) idCheck => flag: "+flag);
		
		return flag;
	}

	@Override
	public int nnCheck(UserVO inVO) {
		LOG.debug("dao) nnCheck => param: "+inVO);
		
		String statement = NAMESPACE + ".nnCheck";
		LOG.debug("dao) nnCheck => statement: "+statement);
		
		int flag = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("dao) nnCheck => flag: "+flag);
		
		return flag;
	}
	
	@Override
	public int updateLastLogin(UserVO inVO) {
		LOG.debug("dao) updateLastLogin => param: "+inVO);
		
		String statement = NAMESPACE + ".updateLastLogin";
		LOG.debug("dao) updateLastLogin => statement: "+statement);
		
		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("dao) updateLastLogin => flag: "+flag);
		
		return flag;
	}
	
	// --------------------- Admin User functions
	@Override
	public List<PieVO> getDailyRegCnt(String dateStr) {
		LOG.debug("dao) getDailyRegCnt => param: "+dateStr);
		
		String statement = NAMESPACE + ".getDailyRegCnt";
		LOG.debug("dao) getDailyRegCnt => statement: "+statement);
		
		List<PieVO> list = this.sqlSessionTemplate.selectList(statement, dateStr);
		LOG.debug("dao) getDailyRegCnt => list: "+list);
	
		return list;
	}

	@Override
	public List<PieVO> getWeeklyRegCnt(String dateStr) {
		LOG.debug("dao) getWeeklyRegCnt => param: "+dateStr);
		
		String statement = NAMESPACE + ".getWeeklyRegCnt";
		LOG.debug("dao) getWeeklyRegCnt => statement: "+statement);
		
		List<PieVO> list = this.sqlSessionTemplate.selectList(statement, dateStr);
		LOG.debug("dao) getWeeklyRegCnt => list: "+list);
	
		return list;
	}

}//--class

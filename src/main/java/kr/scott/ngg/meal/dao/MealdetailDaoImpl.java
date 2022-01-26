package kr.scott.ngg.meal.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

@Repository("mealdetailDao")
public class MealdetailDaoImpl implements MealdetailDao {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	final String NAMESPACE = "kr.scott.ngg.MealdetailMapper";

	public MealdetailDaoImpl() {
	}

	@Override
	public int doInsert(MealdetailVO inVO) {
		LOG.debug("dao) doInsert => param: "+inVO);
		
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("dao) doInsert => statement: "+statement);

		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao) doInsert => flag: "+flag);
		
		return flag;
	}

	@Override
	public int doDelete(MealdetailVO inVO) {
		LOG.debug("dao) doDelete => param: "+inVO);
		
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("dao) doDelete => statement: "+statement);

		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("dao) doDelete => flag: "+flag);
		
		return flag;
	}
	
	@Override
	public int deleteByMealSq(MealVO inVO) {
		LOG.debug("dao) deleteByMealSq => param: "+inVO);
		
		String statement = NAMESPACE + ".deleteByMealSq";
		LOG.debug("dao) deleteByMealSq => statement: "+statement);

		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("dao) deleteByMealSq => flag: "+flag);
		
		return flag;
	}

	@Override
	public int doUpdate(MealdetailVO inVO) {
		LOG.debug("dao) doUpdate => param: "+inVO);
		
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("dao) doUpdate => statement: "+statement);

		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("dao) doUpdate => flag: "+flag);
		
		return flag;
	}

	@Override
	public List<MealdetailVO> doRetrieve(MealVO inVO) {
		LOG.debug("dao) doRetrieve => param: "+inVO);

		String statement = NAMESPACE + ".doRetrieve";
		LOG.debug("dao) doRetrieve => statement: "+statement);
		
		List<MealdetailVO> list = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("dao) doRetrieve => list: "+list);
		
		return list;
	}
	
	// -------------------------------------------------------------------
	
	@Override
	public List<MealdetailVO> getAll() {
		String statement = NAMESPACE + ".getAll";
		LOG.debug("dao) getAll => statement: "+statement);
		
		List<MealdetailVO> list = this.sqlSessionTemplate.selectList(statement);
		LOG.debug("dao) getAll => list: "+list);
		
		return list;
	}

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

	@Override
	public MealdetailVO getLastData() {
		String statement = NAMESPACE + ".getLastData";
		LOG.debug("dao) getLastData => statement: "+statement);
		
		MealdetailVO outVO = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("dao) getLastData => outVO: "+outVO);
		
		return outVO;
	}

}

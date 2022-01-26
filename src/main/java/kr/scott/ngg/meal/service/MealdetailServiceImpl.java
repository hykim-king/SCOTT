package kr.scott.ngg.meal.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.meal.dao.MealdetailDao;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

@Service("mealdetailService")
public class MealdetailServiceImpl implements MealdetailService {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	MealdetailDao dao;

	public MealdetailServiceImpl() {
	}

	@Override
	public int doInsert(MealdetailVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(MealdetailVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public List<MealdetailVO> doRetrieve(MealVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

}

package kr.scott.ngg.meal.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.dao.MealDao;
import kr.scott.ngg.meal.domain.MealVO;

@Service("mealService")
public class MealServiceImpl implements MealService {

	@Autowired
	MealDao dao;
	
	@Override
	public int doInsert(MealVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(MealVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public int doUpdate(MealVO inVO) throws SQLException {
		return dao.doUpdate(inVO);
	}

	@Override
	public MealVO doSelectOne(MealVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<MealVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

}

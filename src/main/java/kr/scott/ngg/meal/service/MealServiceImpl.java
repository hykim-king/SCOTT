package kr.scott.ngg.meal.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.dao.MealDao;
import kr.scott.ngg.meal.dao.MealdetailDao;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

@Service("mealService")
public class MealServiceImpl implements MealService {

	@Autowired
	MealDao dao;
	
	@Autowired
	MealdetailDao mdao;
	
	@Override
	public int tdoInsert(MealVO inVO, List<MealdetailVO> list) throws SQLException {
		int flag = dao.doInsert(inVO);
		
		for(MealdetailVO md : list) {
			mdao.doInsert(md);
		}
		
		return flag;
	}
	
	@Override
	public int tdoInsert(MealVO inVO, MealdetailVO[] list) throws SQLException {
		int flag = dao.doInsert(inVO);
		
		for(MealdetailVO md : list) {
			mdao.doInsert(md);
		}
		
		return flag;
	}

	@Override
	public int tdoDelete(MealVO inVO) throws SQLException {
		mdao.deleteByMealSq(inVO);
		return dao.doDelete(inVO);
	}

	@Override
	public int tdoUpdate(MealVO inVO, List<MealdetailVO> list) throws SQLException {
		
		for(MealdetailVO md : list) {
			mdao.doInsert(md);
		}
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

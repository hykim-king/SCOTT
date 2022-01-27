package kr.scott.ngg.food.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.food.dao.FoodDao;
import kr.scott.ngg.food.domain.FoodVO;

@Service("foodService")
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodDao dao;

	@Override
	public int doInsert(FoodVO inVO) throws SQLException {
		return dao.doInsert(inVO);
	}

	@Override
	public int doDelete(FoodVO inVO) throws SQLException {
		return dao.doDelete(inVO);
	}

	@Override
	public int doUpdate(FoodVO inVO) throws SQLException {
		return dao.doUpdate(inVO);
	}

	@Override
	public FoodVO doSelectOne(FoodVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<FoodVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

}

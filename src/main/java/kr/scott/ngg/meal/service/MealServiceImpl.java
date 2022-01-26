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
		flag = insertMealdetail(list, 0);

		return flag;
	}

	@Override
	public int tdoDelete(MealVO inVO) throws SQLException {
		mdao.deleteByMealSq(inVO);
		return dao.doDelete(inVO);
	}

	@Override
	public int tdoUpdate(MealVO inVO, List<MealdetailVO> list, List<Integer> delList) throws SQLException {
		int flag = dao.doUpdate(inVO);

		flag = insertMealdetail(list, 1);

		if (delList != null && delList.size() > 0) {
			MealdetailVO mdVO = new MealdetailVO();
			for (int sq : delList) {
				mdVO.setMealdetailSq(sq);
				flag = mdao.doDelete(mdVO);
			}
		}

		return flag;
	}

	@Override
	public MealVO doSelectOne(MealVO inVO) throws SQLException {
		return dao.doSelectOne(inVO);
	}

	@Override
	public List<MealVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

	@Override
	public List<MealdetailVO> getMealdetailList(MealVO inVO) throws SQLException {
		return mdao.doRetrieve(inVO);
	}

	public int insertMealdetail(List<MealdetailVO> list, int div) {
		if (list == null || list.size() < 0) return 0;
		
		for (MealdetailVO md : list) {
			if (md.getMealdetailSq() == 0) {
				if(div == 0) {
					mdao.doInsert(md);
				} else {
					mdao.doUpdate(md);
				}
			}
		}
		
		return 1;
	}

}

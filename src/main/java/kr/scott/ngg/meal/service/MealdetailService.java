package kr.scott.ngg.meal.service;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

public interface MealdetailService {

	/**
	 * 단건 등록
	 * 
	 * @param MealdetailVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(MealdetailVO inVO) throws SQLException;

	/**
	 * 단건 삭제
	 * 
	 * @param MealdetailVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(MealdetailVO inVO) throws SQLException;
	
	/**
	 * 식단 상세 
	 * 
	 * @param MealVO
	 * @return List<MealdetailVO>
	 * @throws SQLException
	 */
	public List<MealdetailVO> doRetrieve(MealVO inVO) throws SQLException;
}

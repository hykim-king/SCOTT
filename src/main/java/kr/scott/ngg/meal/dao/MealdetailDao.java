package kr.scott.ngg.meal.dao;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

public interface MealdetailDao {
	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param MealdetailVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(MealdetailVO inVO);

	/**
	 * 단건 삭제
	 * 
	 * @param MealdetailVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(MealdetailVO inVO);

	/**
	 * 식단 번호에 따른 식단 상세 전부 삭제
	 * 
	 * @param MealdetailVO
	 * @return int >1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int deleteByMealSq(MealVO inVO);

	/**
	 * 단건 수정
	 * 
	 * @param MealdetailVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(MealdetailVO inVO);

	/**
	 * 식단 상세 
	 * 
	 * @param MealVO
	 * @return List<MealdetailVO>
	 * @throws SQLException
	 */
	public List<MealdetailVO> doRetrieve(MealVO inVO);

	// ----------------------------------------
	// select all the list
	public List<MealdetailVO> getAll();

	// get count
	public int getCount();

	// delete all
	public void deleteAll();
	
	// get last input data
	public MealdetailVO getLastData();
}

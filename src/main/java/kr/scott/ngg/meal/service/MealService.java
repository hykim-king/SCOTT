package kr.scott.ngg.meal.service;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.domain.MealVO;
import kr.scott.ngg.meal.domain.MealdetailVO;

public interface MealService {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param MealVO, List<MealdetailVO>
	 * @return int >1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int tdoInsert(MealVO inVO, List<MealdetailVO> list) throws SQLException;

	/**
	 * 단건 삭제
	 * 
	 * @param MealVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int tdoDelete(MealVO inVO) throws SQLException;

	/**
	 * 단건 수정
	 * 
	 * @param MealVO, List<MealdetailVO>
	 * @return int >1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int tdoUpdate(MealVO inVO, List<MealdetailVO> list, List<Integer> delList) throws SQLException;

	/**
	 * 단건 조회
	 * 
	 * @param MealVO
	 * @return MealVO
	 */
	public MealVO doSelectOne(MealVO inVO) throws SQLException;

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param MealVO
	 * @return List<MealVO>
	 * @throws SQLException
	 */
	public List<MealVO> doRetrieve(SearchVO inVO) throws SQLException;
	
	/**
	 * 식단 상세 
	 * 
	 * @param MealVO
	 * @return List<MealdetailVO>
	 * @throws SQLException
	 */
	public List<MealdetailVO> getMealdetailList(MealVO inVO) throws SQLException;

	
}

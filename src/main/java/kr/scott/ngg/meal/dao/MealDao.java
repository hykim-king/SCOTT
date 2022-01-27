package kr.scott.ngg.meal.dao;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.meal.domain.MealVO;

public interface MealDao {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param MealVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(MealVO inVO);

	/**
	 * 단건 삭제
	 * 
	 * @param MealVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(MealVO inVO);

	/**
	 * 단건 수정
	 * 
	 * @param MealVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(MealVO inVO);

	/**
	 * 단건 조회
	 * 
	 * @param MealVO
	 * @return MealVO
	 */
	public MealVO doSelectOne(MealVO inVO);

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param MealVO
	 * @return List<MealVO>
	 * @throws SQLException
	 */
	public List<MealVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<MealVO> getAll();

	// get count
	public int getCount();

	// delete all
	public void deleteAll();
	
	// get last input data
	public MealVO getLastData();

}

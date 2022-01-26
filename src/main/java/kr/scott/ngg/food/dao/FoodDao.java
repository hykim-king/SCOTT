package kr.scott.ngg.food.dao;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.food.domain.FoodVO;


public interface FoodDao {
	
	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(FoodVO inVO);

	/**
	 * 단건 삭제
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(FoodVO inVO);
	
	/**
	 * 단건 수정
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(FoodVO inVO);
	
	/**
	 * 단건 조회
	 * 
	 * @param FoodVO
	 * @return FoodVO
	 */
	public FoodVO doSelectOne(FoodVO inVO);
	
	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param FoodVO
	 * @return List<FoodVO>
	 * @throws SQLException
	 */
	public List<FoodVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<FoodVO> getAll();
	
	// get count
	public int getCount();
	
	// delete all
	public void deleteAll();
	
	// get last input data
	public FoodVO getLastData();
	
}

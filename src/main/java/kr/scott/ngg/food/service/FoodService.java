package kr.scott.ngg.food.service;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.food.domain.FoodVO;

public interface FoodService {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(FoodVO inVO) throws SQLException;

	/**
	 * 단건 삭제
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(FoodVO inVO) throws SQLException;

	/**
	 * 단건 수정
	 * 
	 * @param FoodVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(FoodVO inVO) throws SQLException;

	/**
	 * 단건 조회
	 * 
	 * @param FoodVO
	 * @return FoodVO
	 */
	public FoodVO doSelectOne(FoodVO inVO) throws SQLException;

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param FoodVO
	 * @return List<FoodVO>
	 * @throws SQLException
	 */
	public List<FoodVO> doRetrieve(SearchVO inVO) throws SQLException;

	
	// --------------------- Food functions
}

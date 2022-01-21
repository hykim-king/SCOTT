package kr.scott.ngg.status.dao;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.status.domain.StatusVO;

public interface StatusDao {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param StatusVO -> statusDate format: "yyyy/MM/dd"
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(StatusVO inVO);

	/**
	 * 단건 삭제
	 * 
	 * @param StatusVO -> statusDate format: "yyyy/MM/dd"
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(StatusVO inVO);

	/**
	 * 단건 수정
	 * 
	 * @param StatusVO -> statusDate format: "yyyy/MM/dd"
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(StatusVO inVO);

	/**
	 * 단건 조회
	 * 
	 * @param StatusVO -> statusDate format: "yyyy/MM/dd"
	 * @return StatusVO
	 */
	public StatusVO doSelectOne(StatusVO inVO);

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param StatusVO -> statusDate format: "yyyy/MM/dd"
	 * @return List<StatusVO>
	 * @throws SQLException
	 */
	public List<StatusVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<StatusVO> getAll();

	// get count
	public int getCount();

	// delete all
	public void deleteAll();

	// ----------------------------------------
	/**
	 * 회원 운동 현황 캘린더 뷰
	 * @param StatusVO -> statusDate에 출력할 월 정보를 세팅해야함
	 * @return List<StatusVO>
	 */
	public List<StatusVO> doRetrieveCal(StatusVO inVO);
}

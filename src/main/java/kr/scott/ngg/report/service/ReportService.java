package kr.scott.ngg.report.service;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.report.domain.ReportVO;

public interface ReportService {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param ReportVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(ReportVO inVO) throws SQLException;

	/**
	 * 단건 삭제
	 * 
	 * @param ReportVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(ReportVO inVO) throws SQLException;

	/**
	 * 단건 수정
	 * 
	 * @param ReportVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(ReportVO inVO) throws SQLException;

	/**
	 * 단건 조회
	 * 
	 * @param ReportVO
	 * @return ReportVO
	 */
	public ReportVO doSelectOne(ReportVO inVO) throws SQLException;

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param ReportVO
	 * @return List<ReportVO>
	 * @throws SQLException
	 */
	public List<ReportVO> doRetrieve(SearchVO inVO) throws SQLException;

	
	// --------------------- Report functions
}

package kr.scott.ngg.report.dao;


import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.report.domain.ReportVO;

public interface ReportDao {
	
	// insert
	public int doInsert(ReportVO inVO);
	
	/**
	 * 단건 수정
	 * 
	 * @param ReportVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(ReportVO inVO);
	
	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param ReportVO
	 * @return List<ReportVO>
	 * @throws SQLException
	 */
	public List<ReportVO> doRetrieve(SearchVO inVO);
	
}

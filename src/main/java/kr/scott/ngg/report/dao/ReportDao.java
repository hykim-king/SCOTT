package kr.scott.ngg.report.dao;

import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.report.domain.ReportVO;

public interface ReportDao {
	
	// insert
	public int doInsert(ReportVO inVO);

	// delete
	public int doDelete(ReportVO inVO);
	
	// update
	public int doUpdate(ReportVO inVO);
	
	// select one
	public ReportVO doSelectOne(ReportVO inVO);
	
	// select list with paging and searching
	public List<ReportVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<ReportVO> getAll();
	
	// get count
	public int getCount();
	
	// delete all
	public void deleteAll();
}

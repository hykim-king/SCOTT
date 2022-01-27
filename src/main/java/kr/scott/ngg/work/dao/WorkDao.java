package kr.scott.ngg.work.dao;

import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.work.domain.WorkVO;


public interface WorkDao {
	// insert
	public int doInsert(WorkVO inVO);

	// delete
	public int doDelete(WorkVO inVO);
	
	// update
	public int doUpdate(WorkVO inVO);
	
	// select one
	public WorkVO doSelectOne(WorkVO inVO);
	
	// select list with paging and searching
	public List<WorkVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<WorkVO> getAll();
	
	// get count
	public int getCount();
	
	// delete all
	public void deleteAll();
}

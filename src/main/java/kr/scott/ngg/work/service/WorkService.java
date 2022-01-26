package kr.scott.ngg.work.service;

import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.work.domain.WorkVO;

public interface WorkService {
	
	public int doInsert(WorkVO inVO);

	// delete
	public int doDelete(WorkVO inVO);
	
	// update
	public int doUpdate(WorkVO inVO);
	
	// select one
	public WorkVO doSelectOne(WorkVO inVO);
	
	// select list with paging and searching
	public List<WorkVO> doRetrieve(SearchVO inVO);

}

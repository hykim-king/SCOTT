package kr.scott.ngg.user.dao;

import java.util.List;

import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.user.domain.UserVO;

public interface UserDao {
	
	// insert
	public int doInsert(UserVO inVO);

	// delete
	public int doDelete(UserVO inVO);
	
	// update
	public int doUpdate(UserVO inVO);
	
	// select one
	public UserVO doSelectOne(UserVO inVO);
	
	// select list with paging and searching
	public List<UserVO> doRetrieve(SearchVO inVO);

	// ----------------------------------------
	// select all the list
	public List<UserVO> getAll();
	
	// get count
	public int getCount();
	
	// delete all
	public void deleteAll();
	
}

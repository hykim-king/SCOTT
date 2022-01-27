package kr.scott.ngg.file.dao;

import java.util.List;

import kr.scott.ngg.file.domain.FileVO;


public interface FileDao {
	
	// insert
	public int doInsert(FileVO inVO);

	// delete
	public int doDelete(FileVO inVO);
	
	// update
	public int doUpdate(FileVO inVO);
	
	// select one
	public FileVO doSelectOne(FileVO inVO);
	
	// select list with paging and searching
	public List<FileVO> doRetrieve();

	// ----------------------------------------
	// select all the list
	public List<FileVO> getAll();
	
	// get count
	public int getCount();
	
	// delete all
	public void deleteAll();
}

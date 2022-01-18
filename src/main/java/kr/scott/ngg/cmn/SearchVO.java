package kr.scott.ngg.cmn;

public class SearchVO {
	/** 검색 구분 */
	private String searchDiv;
	/** 검색어 */
	private String searchWord;
	/** 한 페이지 당 보일 row 수 */
	private int pageSize;
	/** 페이지 번호 */
	private int pageNum;

	public SearchVO() {
		this.searchDiv = "10";
		this.searchWord = "";
		this.pageSize = 10;
		this.pageNum = 1;
	}

	public SearchVO(String searchDiv, String searchWord, int pageSize, int pageNum) {
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", toString()=" + super.toString() + "]";
	}

}//--class

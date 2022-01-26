package kr.scott.ngg.cmn;

public class SearchVO extends DTO {
	/** 검색 구분 */
	private String searchDiv;
	/** 검색어 */
	private String searchWord;
	/** 한 페이지 당 보일 row 수 */
	private int pageSize;
	/** 페이지 번호 */
	private int pageNum;
	/** 정렬 구분 */
	private String orderDiv;
	/** 정렬 방향 */
	private String orderDir;
	
	public SearchVO() {
		this("", "", 0, 0, "", "");
	}

	public SearchVO(String searchDiv, String searchWord, int pageSize, int pageNum, String orderDiv, String orderDir) {
		this.searchDiv = StringUtil.nvl(searchDiv, "");
		this.searchWord = StringUtil.nvl(searchWord, "");
		this.pageSize = (pageSize == 0) ? 10 : pageSize;
		this.pageNum = (pageNum == 0) ? 1 : pageNum;
		this.orderDiv = StringUtil.nvl(orderDiv, "");
		this.orderDir = StringUtil.nvl(orderDir, "");
	}

	public SearchVO(String searchDiv, String searchWord, int pageSize, int pageNum) {
		this(searchDiv, searchWord, pageSize, pageNum, "", "");
	}

	public SearchVO(String orderDiv, String orderDir) {
		this("", "", 0, 0, orderDiv, orderDir);
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

	public String getOrderDiv() {
		return orderDiv;
	}

	public void setOrderDiv(String orderDiv) {
		this.orderDiv = orderDiv;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", orderDiv=" + orderDiv + ", orderDir=" + orderDir + ", toString()="
				+ super.toString() + "]";
	}

}// --class

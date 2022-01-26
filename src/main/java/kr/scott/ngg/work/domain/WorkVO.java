package kr.scott.ngg.work.domain;

import kr.scott.ngg.cmn.DTO;

public class WorkVO extends DTO {
	/** 운동 게시글 번호 */
	private int workSq;
	/** 운동 게시글 제목 */
	private String workTitle;
	/** 작성자 아이디 */
	private String userId;
	/** 운동 게시글 내용 */
	private String workContent;
	/** 운동 게시글 조회수 */
	private int workReadCnt;
	/** 운동 게시글 첨부파일 번호 */
	private int workFile;
	/** 운동 게시글 카테고리 */
	private int workCt1;
	/** 운동 수정일 */
	private String workModDt;
	/** 운동 작성일 */
	private String workRegDt;

	public WorkVO() {
		// TODO Auto-generated constructor stub
	}

	public WorkVO(int num, int totalNum) {
		super(num, totalNum);
		// TODO Auto-generated constructor stub
	}

	public WorkVO( String workTitle, String userId, String workContent, int workReadCnt, int workFile, int workCt1) {
		
		this.workTitle = workTitle;
		this.userId = userId;
		this.workContent = workContent;
		this.workReadCnt = workReadCnt;
		this.workFile = workFile;
		this.workCt1 = workCt1;
		
	}

	public WorkVO(String workTitle, String userId, String workContent, int workReadCnt, int workFile, int workCt1,
			String workModDt, String workRegDt) {
		this.workTitle = workTitle;
		this.userId = userId;
		this.workContent = workContent;
		this.workReadCnt = workReadCnt;
		this.workFile = workFile;
		this.workCt1 = workCt1;
		this.workModDt = workModDt;
		this.workRegDt = workRegDt;
	}

	public int getWorkSq() {
		return workSq;
	}

	public void setWorkSq(int workSq) {
		this.workSq = workSq;
	}

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public int getWorkReadCnt() {
		return workReadCnt;
	}

	public void setWorkReadCnt(int workReadCnt) {
		this.workReadCnt = workReadCnt;
	}

	public int getWorkFile() {
		return workFile;
	}

	public void setWorkFile(int workFile) {
		this.workFile = workFile;
	}

	public int getWorkCt1() {
		return workCt1;
	}

	public void setWorkCt1(int workCt1) {
		this.workCt1 = workCt1;
	}

	public String getWorkModDt() {
		return workModDt;
	}

	public void setWorkModDt(String workModDt) {
		this.workModDt = workModDt;
	}

	public String getWorkRegDt() {
		return workRegDt;
	}

	public void setWorkRegDt(String workRegDt) {
		this.workRegDt = workRegDt;
	}

	@Override
	public String toString() {

		return "WorkVO [workSq=" + workSq + ", workTitle=" + workTitle + ", userId=" + userId + ", workContent="
				+ workContent + ", workReadCnt=" + workReadCnt + ", workFile=" + workFile + ", workCt1=" + workCt1
				+ ", workModDt=" + workModDt + ", workRegDt=" + workRegDt + ", toString()=" + super.toString() + "]";

	}

}// --class

package kr.scott.ngg.commu.domain;

import kr.scott.ngg.cmn.DTO;

public class CommuVO extends DTO {
	/** 커뮤 게시글 고유번호 */
	private int communitySq;
	/** 커뮤 게시글 제목 */
	private String communityTitle;
	/** 커뮤 게시글 작성자 */
	private String userId;
	/** 커뮤 게시글 내용 */
	private String communityContent;
	/** 커뮤 게시글 첨부파일 번호 */
	private int communityFile;
	/** 커뮤 게시글 카테고리 */
	private int communityCt;
	/** 커뮤 게시글 조회수 */
	private int communityReadCnt;
	/** 커뮤 게시글 공개상태 */
	private int communitySt;
	/** 커뮤 게시글 수정일 */
	private String communityModDt;
	/** 커뮤 게시글 작성일 */
	private String communityRegDt;

	public CommuVO() {
		// TODO Auto-generated constructor stub
	}

	public CommuVO(int num, int totalNum) {
		super(num, totalNum);
		// TODO Auto-generated constructor stub
	}

	public CommuVO(int communitySq, String communityTitle, String userId, String communityContent, int communityFile,
			int communityCt, int communityReadCnt) {
		this.communitySq = communitySq;
		this.communityTitle = communityTitle;
		this.userId = userId;
		this.communityContent = communityContent;
		this.communityFile = communityFile;
		this.communityCt = communityCt;
		this.communityReadCnt = communityReadCnt;
		this.communitySt = 1;
		this.communityModDt = "";
		this.communityRegDt = "";
	}

	public CommuVO(int communitySq, String communityTitle, String userId, String communityContent, int communityFile,
			int communityCt, int communityReadCnt, int communitySt, String communityModDt, String communityRegDt) {
		this.communitySq = communitySq;
		this.communityTitle = communityTitle;
		this.userId = userId;
		this.communityContent = communityContent;
		this.communityFile = communityFile;
		this.communityCt = communityCt;
		this.communityReadCnt = communityReadCnt;
		this.communitySt = communitySt;
		this.communityModDt = communityModDt;
		this.communityRegDt = communityRegDt;
	}

	public int getCommunitySq() {
		return communitySq;
	}

	public void setCommunitySq(int communitySq) {
		this.communitySq = communitySq;
	}

	public String getCommunityTitle() {
		return communityTitle;
	}

	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommunityContent() {
		return communityContent;
	}

	public void setCommunityContent(String communityContent) {
		this.communityContent = communityContent;
	}

	public int getCommunityFile() {
		return communityFile;
	}

	public void setCommunityFile(int communityFile) {
		this.communityFile = communityFile;
	}

	public int getCommunityCt() {
		return communityCt;
	}

	public void setCommunityCt(int communityCt) {
		this.communityCt = communityCt;
	}

	public int getCommunityReadCnt() {
		return communityReadCnt;
	}

	public void setCommunityReadCnt(int communityReadCnt) {
		this.communityReadCnt = communityReadCnt;
	}

	public int getCommunitySt() {
		return communitySt;
	}

	public void setCommunitySt(int communitySt) {
		this.communitySt = communitySt;
	}

	public String getCommunityModDt() {
		return communityModDt;
	}

	public void setCommunityModDt(String communityModDt) {
		this.communityModDt = communityModDt;
	}

	public String getCommunityRegDt() {
		return communityRegDt;
	}

	public void setCommunityRegDt(String communityRegDt) {
		this.communityRegDt = communityRegDt;
	}

	@Override
	public String toString() {
		return "CommuVO [communityTitle=" + communityTitle + ", userId=" + userId + ", communityContent="
				+ communityContent + ", communityFile=" + communityFile + ", communityCt=" + communityCt
				+ ", communityReadCnt=" + communityReadCnt + ", communitySt=" + communitySt + ", communityModDt="
				+ communityModDt + ", communityRegDt=" + communityRegDt + ", toString()=" + super.toString() + "]";
	}

}// --class

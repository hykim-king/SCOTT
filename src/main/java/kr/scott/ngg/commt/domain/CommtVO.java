package kr.scott.ngg.commt.domain;

import kr.scott.ngg.cmn.DTO;

public class CommtVO extends DTO {
	/** 댓글 고유번호 */
	private int commentSq;
	/** 댓글이 달린 게시글 고유번호 */
	private int communitySq;
	/** 댓글 작성자 */
	private String userId;
	/** 댓글 내용 */
	private String commentContent;
	/** 댓글 첨부파일 번호 */
	private int commentFile;
	/** 댓글 공개상태 */
	private int commentSt;
	/** 댓글 작성일 */
	private String commentRegDt;
	/** 댓글 수정일 */
	private String commentModDt;

	public CommtVO() {
		// TODO Auto-generated constructor stub
	}

	public CommtVO(int communitySq, String userId, String commentContent, int commentFile, int commentSt) {
		this.commentSq = 0;
		this.communitySq = communitySq;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentFile = commentFile;
		this.commentSt = commentSt;
		this.commentRegDt = "";
		this.commentModDt = "";
	}
	
	public CommtVO(int commentSq, int communitySq, String userId, String commentContent, int commentFile, int commentSt,
			String commentRegDt, String commentModDt) {
		this.commentSq = commentSq;
		this.communitySq = communitySq;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentFile = commentFile;
		this.commentSt = commentSt;
		this.commentRegDt = commentRegDt;
		this.commentModDt = commentModDt;
	}

	public int getCommentSq() {
		return commentSq;
	}

	public void setCommentSq(int commentSq) {
		this.commentSq = commentSq;
	}

	public int getCommunitySq() {
		return communitySq;
	}

	public void setCommunitySq(int communitySq) {
		this.communitySq = communitySq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentFile() {
		return commentFile;
	}

	public void setCommentFile(int commentFile) {
		this.commentFile = commentFile;
	}

	public int getCommentSt() {
		return commentSt;
	}

	public void setCommentSt(int commentSt) {
		this.commentSt = commentSt;
	}

	public String getCommentRegDt() {
		return commentRegDt;
	}

	public void setCommentRegDt(String commentRegDt) {
		this.commentRegDt = commentRegDt;
	}

	public String getCommentModDt() {
		return commentModDt;
	}

	public void setCommentModDt(String commentModDt) {
		this.commentModDt = commentModDt;
	}

	@Override
	public String toString() {
		return "CommtVO [commentSq=" + commentSq + ", communitySq=" + communitySq + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", commentFile=" + commentFile + ", commentSt=" + commentSt
				+ ", commentRegDt=" + commentRegDt + ", commentModDt=" + commentModDt + "]";
	}


}// --class

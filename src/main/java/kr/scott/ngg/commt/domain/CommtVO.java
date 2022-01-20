package kr.scott.ngg.commt.domain;

import kr.scott.ngg.cmn.DTO;

public class CommtVO extends DTO {
	/** 댓글 고유번호 */
	private int comment_sq;
	/** 댓글이 달린 게시글 고유번호 */
	private int community_sq;
	/** 댓글 작성자 */
	private String user_id;
	/** 댓글 내용 */
	private String comment_content;
	/** 댓글 첨부파일 번호 */
	private int comment_file;
	/** 댓글 공개상태 */
	private int comment_st;
	/** 댓글 작성일 */
	private String comment_reg_dt;
	/** 댓글 수정일 */
	private String comment_mod_dt;

	public CommtVO() {
		// TODO Auto-generated constructor stub
	}

	public CommtVO(int comment_sq, int community_sq, String user_id, String comment_content, int comment_file) {
		this.comment_sq = comment_sq;
		this.community_sq = community_sq;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.comment_file = comment_file;
		this.comment_st = 1;
		this.comment_reg_dt = "";
		this.comment_mod_dt = "";
	}

	public CommtVO(int comment_sq, int community_sq, String user_id, String comment_content, int comment_file,
			int comment_st, String comment_reg_dt, String comment_mod_dt) {
		this.comment_sq = comment_sq;
		this.community_sq = community_sq;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.comment_file = comment_file;
		this.comment_st = comment_st;
		this.comment_reg_dt = comment_reg_dt;
		this.comment_mod_dt = comment_mod_dt;
	}

	public int getComment_sq() {
		return comment_sq;
	}

	public void setComment_sq(int comment_sq) {
		this.comment_sq = comment_sq;
	}


	public int getCommunity_sq() {
		return community_sq;
	}

	public void setCommunity_sq(int community_sq) {
		this.community_sq = community_sq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getComment_file() {
		return comment_file;
	}

	public void setComment_file(int comment_file) {
		this.comment_file = comment_file;
	}

	public int getComment_st() {
		return comment_st;
	}

	public void setComment_st(int comment_st) {
		this.comment_st = comment_st;
	}

	public String getComment_reg_dt() {
		return comment_reg_dt;
	}

	public void setComment_reg_dt(String comment_reg_dt) {
		this.comment_reg_dt = comment_reg_dt;
	}

	public String getComment_mod_dt() {
		return comment_mod_dt;
	}

	public void setComment_mod_dt(String comment_mod_dt) {
		this.comment_mod_dt = comment_mod_dt;
	}

	@Override
	public String toString() {
		return "CommtVO [comment_sq=" + comment_sq + ", community_sq=" + community_sq + ", user_id=" + user_id
				+ ", comment_content=" + comment_content + ", comment_file=" + comment_file + ", comment_st="
				+ comment_st + ", comment_reg_dt=" + comment_reg_dt + ", comment_mod_dt=" + comment_mod_dt
				+ ", toString()=" + super.toString() + "]";
	}

}// --class

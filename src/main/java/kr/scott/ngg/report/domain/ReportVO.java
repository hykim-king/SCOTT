package kr.scott.ngg.report.domain;

import kr.scott.ngg.cmn.DTO;

public class ReportVO extends DTO {
	/** 신고 번호 */
	private int reportSq;
	/** 신고한 유저*/
	private String reportUser;
	/** 신고 타입 */
	private int typeSq;
	/** 신고일 */
	private String reportDt;
	/** 신고 대상번호 */
	private int reportCcSq;
	/** 신고 사유 구분 */
	private int reportCt;
	/** 신고 내용 */
	private String reportCnt;
	/** 신고 번호 */
	private int reportSt;

	public ReportVO() {
		// TODO Auto-generated constructor stub
	}

	public ReportVO(int reportSq, int typeSq, int reportCcSq, int reportCt) {
		this.typeSq = typeSq;
		this.reportDt = "";
		this.reportCcSq = reportCcSq;
		this.reportCt = reportCt;
		this.reportCnt = "";
		this.reportSt = 0;
	}

	public ReportVO( String reportUser,int typeSq, String reportDt, int reportCcSq, int reportCt, String reportCnt
			) {
		this.reportUser = reportUser;
		this.typeSq = typeSq;
		this.reportDt = reportDt;
		this.reportCcSq = reportCcSq;
		this.reportCt = reportCt;
		this.reportCnt = reportCnt;
		
	}

	public int getReportSq() {
		return reportSq;
	}

	public int getTypeSq() {
		return typeSq;
	}

	public String getReportDt() {
		return reportDt;
	}


	public int getReportCcSq() {
		return reportCcSq;
	}

	public int getReportCt() {
		return reportCt;
	}

	public void setReportCt(int reportCt) {
		this.reportCt = reportCt;
	}

	public String getReportCnt() {
		return reportCnt;
	}

	public void setReportCnt(String reportCnt) {
		this.reportCnt = reportCnt;
	}

	public int getReportSt() {
		return reportSt;
	}

	public void setReportSt(int reportSt) {
		this.reportSt = reportSt;
	}

	public String getReportUser() {
		return reportUser;
	}

	public void setReportUser(String reportUser) {
		this.reportUser = reportUser;
	}

	@Override
	public String toString() {
		return "ReportVO [reportSq=" + reportSq + ", reportUser=" + reportUser + ", typeSq=" + typeSq + ", reportDt="
				+ reportDt + ", reportCcSq=" + reportCcSq + ", reportCt=" + reportCt + ", reportCnt=" + reportCnt
				+ ", reportSt=" + reportSt + ", toString()=" + super.toString() + "]";
	}

	
}// --class

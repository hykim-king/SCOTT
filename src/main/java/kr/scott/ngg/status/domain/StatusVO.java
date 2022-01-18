package kr.scott.ngg.status.domain;

import kr.scott.ngg.cmn.DTO;

public class StatusVO extends DTO {
	/** 운동한 날짜 */
	private String statusDate;
	/** 운동한 사람 */
	private String userId;
	/** 운동 상태 (0=운동안함 / 1=운동함) */
	private String statusWorkSt;
	/** 운동 메모 */
	private String statusWorkMe;

	public StatusVO() {
		// TODO Auto-generated constructor stub
	}

	public StatusVO(String statusDate, String userId, String statusWorkSt, String statusWorkMe) {
		this.statusDate = statusDate;
		this.userId = userId;
		this.statusWorkSt = statusWorkSt;
		this.statusWorkMe = statusWorkMe;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatusWorkSt() {
		return statusWorkSt;
	}

	public void setStatusWorkSt(String statusWorkSt) {
		this.statusWorkSt = statusWorkSt;
	}

	public String getStatusWorkMe() {
		return statusWorkMe;
	}

	public void setStatusWorkMe(String statusWorkMe) {
		this.statusWorkMe = statusWorkMe;
	}

	@Override
	public String toString() {
		return "StatusVO [statusDate=" + statusDate + ", userId=" + userId + ", statusWorkSt=" + statusWorkSt
				+ ", statusWorkMe=" + statusWorkMe + ", toString()=" + super.toString() + "]";
	}

}// --class

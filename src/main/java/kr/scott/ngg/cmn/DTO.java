package kr.scott.ngg.cmn;

public class DTO {
	private int num;
	private int totalNum;

	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(int num, int totalNum) {
		this.num = num;
		this.totalNum = totalNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	@Override
	public String toString() {
		return "DTO [num=" + num + ", totalNum=" + totalNum + "]";
	}

}

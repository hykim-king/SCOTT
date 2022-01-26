package kr.scott.ngg.work.domain;

public class WorkRankVO extends WorkVO {
	/** 운동 게시물 조회 순위 */
	private int rank;

	public WorkRankVO() {
	}

	public WorkRankVO(int rank) {
		super();
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "WorkRankVO [rank=" + rank + ", toString()=" + super.toString() + "]";
	}

}

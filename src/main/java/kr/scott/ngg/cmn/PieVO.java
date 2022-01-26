package kr.scott.ngg.cmn;

public class PieVO extends DTO {
	private String label;
	private int value;

	public PieVO() {
		// TODO Auto-generated constructor stub
	}

	public PieVO(String label, int value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PieVO [label=" + label + ", value=" + value + ", toString()=" + super.toString() + "]";
	}

}

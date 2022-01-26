package kr.scott.ngg.food.domain;

import kr.scott.ngg.cmn.DTO;

public class FoodVO extends DTO {
	/** 음식 고유번호 */
	private int foodSq;
	/** 음식 이름 */
	private String foodName;
	/** 음식 칼로리 */
	private int foodKcal;
	/** 음식 카테고리 */
	private int foodCt;

	public FoodVO() {
	}

	public FoodVO(int foodSq, String foodName, int foodKcal, int foodCt) {
		this.foodSq = foodSq;
		this.foodName = foodName;
		this.foodKcal = foodKcal;
		this.foodCt = foodCt;
	}

	public FoodVO(String foodName, int foodKcal, int foodCt) {
		this.foodSq = 0;
		this.foodName = foodName;
		this.foodKcal = foodKcal;
		this.foodCt = foodCt;
	}

	public FoodVO(String foodName, String foodKcal, String foodCt) {
		this.foodSq = 0;
		this.foodName = foodName;
		this.foodKcal = Integer.parseInt(foodKcal);
		this.foodCt = Integer.parseInt(foodCt);
	}

	public int getFoodSq() {
		return foodSq;
	}

	public void setFoodSq(int foodSq) {
		this.foodSq = foodSq;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodKcal() {
		return foodKcal;
	}

	public void setFoodKcal(int foodKcal) {
		this.foodKcal = foodKcal;
	}

	public int getFoodCt() {
		return foodCt;
	}

	public void setFoodCt(int foodCt) {
		this.foodCt = foodCt;
	}

	@Override
	public String toString() {
		return "FoodVO [foodSq=" + foodSq + ", foodName=" + foodName + ", foodKcal=" + foodKcal + ", foodCt=" + foodCt
				+ ", toString()=" + super.toString() + "]";
	}

}// --class

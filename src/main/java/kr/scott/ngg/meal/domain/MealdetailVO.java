package kr.scott.ngg.meal.domain;

import kr.scott.ngg.food.domain.FoodVO;

public class MealdetailVO extends FoodVO {
	/** 식단 상세 고유번호 */
	private int mealdetailSq;
	/** 식단 고유번호 */
	private int mealSq;
	/** 식단 구분(0:아침, 1:점심, 2:저녁, 3:간식) */
	private int mealDiv;

	public MealdetailVO() {
	}

	public MealdetailVO(int mealdetailSq, int mealSq, int mealDiv, String foodName, int foodKcal, int foodCt) {
		super(foodName, foodKcal, foodCt);
		this.mealdetailSq = mealdetailSq;
		this.mealSq = mealSq;
		this.mealDiv = mealDiv;
	}

	public MealdetailVO(int mealdetailSq, int mealSq, int mealDiv, String foodName, String foodKcal, String foodCt) {
		super(foodName, foodKcal, foodCt);
		this.mealdetailSq = mealdetailSq;
		this.mealSq = mealSq;
		this.mealDiv = mealDiv;
	}

	public MealdetailVO(String mealdetailSq, String mealSq, String mealDiv, String foodName, String foodKcal, String foodCt) {
		super(foodName, foodKcal, foodCt);
		this.mealdetailSq = Integer.parseInt(mealdetailSq);
		this.mealSq = Integer.parseInt(mealSq);
		this.mealDiv = Integer.parseInt(mealDiv);
	}

	public int getMealdetailSq() {
		return mealdetailSq;
	}

	public void setMealdetailSq(int mealdetailSq) {
		this.mealdetailSq = mealdetailSq;
	}

	public int getMealSq() {
		return mealSq;
	}

	public void setMealSq(int mealSq) {
		this.mealSq = mealSq;
	}

	public int getMealDiv() {
		return mealDiv;
	}

	public void setMealDiv(int mealDiv) {
		this.mealDiv = mealDiv;
	}

	@Override
	public String toString() {
		return "MealDetailVO [mealDetailSq=" + mealdetailSq + ", mealSq=" + mealSq + ", mealDiv=" + mealDiv
				+ ", toString()=" + super.toString() + "]";
	}

}

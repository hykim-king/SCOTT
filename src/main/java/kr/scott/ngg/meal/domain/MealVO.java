package kr.scott.ngg.meal.domain;

import kr.scott.ngg.cmn.DTO;

public class MealVO extends DTO {
	/** 식단 고유번호 */
	private int mealSq;
	/** 식단 날짜 */
	private String mealDate;
	/** 식단 작성자 */
	private String userId;
	/** 식단 총 칼로리 */
	private int mealKcal;
	/** 등록된 식단 구분들 */
	private String mealDivs;

	public MealVO() {
	}

	public MealVO(int mealSq, String mealDate, String userId, int mealKcal, String mealDivs) {
		this.mealSq = mealSq;
		this.mealDate = mealDate;
		this.userId = userId;
		this.mealKcal = mealKcal;
		this.mealDivs = mealDivs;
	}

	public int getMealSq() {
		return mealSq;
	}

	public void setMealSq(int mealSq) {
		this.mealSq = mealSq;
	}

	public String getMealDate() {
		return mealDate;
	}

	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMealKcal() {
		return mealKcal;
	}

	public void setMealKcal(int mealKcal) {
		this.mealKcal = mealKcal;
	}

	public String getMealDivs() {
		return mealDivs;
	}

	public void setMealDivs(String mealDivs) {
		this.mealDivs = mealDivs;
	}

	@Override
	public String toString() {
		return "MealVO [mealSq=" + mealSq + ", mealDate=" + mealDate + ", userId=" + userId + ", mealKcal=" + mealKcal
				+ ", mealDivs=" + mealDivs + ", toString()=" + super.toString() + "]";
	}

}// --class

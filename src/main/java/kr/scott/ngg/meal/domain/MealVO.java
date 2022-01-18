package kr.scott.ngg.meal.domain;

import kr.scott.ngg.cmn.DTO;

public class MealVO extends DTO {
	/** 식단 고유번호 */
	private int mealSq;
	/** 식단 작성자 */
	private String userId;
	/** 식단 내용 */
	private String mealContent;
	/** 식단 작성일 */
	private String mealRegDt;
	/** 식단 수정일 */
	private String mealModDt;

	public MealVO() {
	}

	public MealVO(int mealSq, String userId, String mealContent) {
		this.mealSq = mealSq;
		this.userId = userId;
		this.mealContent = mealContent;
		this.mealRegDt = "";
		this.mealModDt = "";
	}

	public MealVO(int mealSq, String userId, String mealContent, String mealRegDt, String mealModDt) {
		this.mealSq = mealSq;
		this.userId = userId;
		this.mealContent = mealContent;
		this.mealRegDt = mealRegDt;
		this.mealModDt = mealModDt;
	}

	public int getMealSq() {
		return mealSq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMealContent() {
		return mealContent;
	}

	public void setMealContent(String mealContent) {
		this.mealContent = mealContent;
	}

	public String getMealRegDt() {
		return mealRegDt;
	}

	public void setMealRegDt(String mealRegDt) {
		this.mealRegDt = mealRegDt;
	}

	public String getMealModDt() {
		return mealModDt;
	}

	public void setMealModDt(String mealModDt) {
		this.mealModDt = mealModDt;
	}

	@Override
	public String toString() {
		return "MealVO [userId=" + userId + ", mealContent=" + mealContent + ", mealRegDt=" + mealRegDt + ", mealModDt="
				+ mealModDt + ", toString()=" + super.toString() + "]";
	}

}// --class

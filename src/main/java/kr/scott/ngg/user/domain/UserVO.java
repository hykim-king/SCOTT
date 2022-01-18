package kr.scott.ngg.user.domain;

import kr.scott.ngg.cmn.DTO;

public class UserVO extends DTO {
	/** 사용자 아이디 */
	private String userId;
	/** 사용자 비밀번호 */
	private String userPw;
	/** 사용자 닉네임 */
	private String userNn;
	/** 사용자 이메일 */
	private String userEmail;
	/** 사용자 생일 */
	private String userBirth;
	/** 사용자 성별 */
	private int userGender;
	/** 사용자 키 */
	private Double userHeight;
	/** 사용자 몸무게 */
	private Double userWeight;
	/** 사용자 등급 */
	private int userGrade;
	/** 사용자 활동칼로리 */
	private int userActkcal;
	/** 사용자 목표 */
	private int userGoal;
	/** 사용자 가입일 */
	private String userJoinDt;
	/** 사용자 포인트 */
	private int userPoint;
	/** 사용자 최종 접속일 */
	private String userLastLogin;
	/** 사용자 권한여부 */
	private int userIsAdmin;
	/** 사용자 활성화여부 */
	private int userIsActive;

	public UserVO() {
	}

	public UserVO(String userId, String userPw, String userNn, String userEmail, String userBirth, int userGender,
			Double userHeight, Double userWeight, int userGrade, int userActkcal, int userGoal) {
		this.userId = userId;
		this.userPw = userPw;
		this.userNn = userNn;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userGrade = userGrade;
		this.userActkcal = userActkcal;
		this.userGoal = userGoal;
		this.userJoinDt = "";
		this.userPoint = 0;
		this.userLastLogin = "";
		this.userIsAdmin = 0;
		this.userIsActive = 1;
	}

	public UserVO(String userId, String userPw, String userNn, String userEmail, String userBirth, int userGender,
			Double userHeight, Double userWeight, int userGrade, int userActkcal, int userGoal, String userJoinDt,
			int userPoint, String userLastLogin, int userIsAdmin, int userIsActive) {
		this.userId = userId;
		this.userPw = userPw;
		this.userNn = userNn;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userGrade = userGrade;
		this.userActkcal = userActkcal;
		this.userGoal = userGoal;
		this.userJoinDt = userJoinDt;
		this.userPoint = userPoint;
		this.userLastLogin = userLastLogin;
		this.userIsAdmin = userIsAdmin;
		this.userIsActive = userIsActive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNn() {
		return userNn;
	}

	public void setUserNn(String userNn) {
		this.userNn = userNn;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public Double getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(Double userHeight) {
		this.userHeight = userHeight;
	}

	public Double getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(Double userWeight) {
		this.userWeight = userWeight;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	public int getUserActkcal() {
		return userActkcal;
	}

	public void setUserActkcal(int userActkcal) {
		this.userActkcal = userActkcal;
	}

	public int getUserGoal() {
		return userGoal;
	}

	public void setUserGoal(int userGoal) {
		this.userGoal = userGoal;
	}

	public String getUserJoinDt() {
		return userJoinDt;
	}

	public void setUserJoinDt(String userJoinDt) {
		this.userJoinDt = userJoinDt;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public String getUserLastLogin() {
		return userLastLogin;
	}

	public void setUserLastLogin(String userLastLogin) {
		this.userLastLogin = userLastLogin;
	}

	public int getUserIsAdmin() {
		return userIsAdmin;
	}

	public void setUserIsAdmin(int userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

	public int getUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(int userIsActive) {
		this.userIsActive = userIsActive;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userNn=" + userNn + ", userEmail=" + userEmail
				+ ", userBirth=" + userBirth + ", userGender=" + userGender + ", userHeight=" + userHeight
				+ ", userWeight=" + userWeight + ", userGrade=" + userGrade + ", userActkcal=" + userActkcal
				+ ", userGoal=" + userGoal + ", userJoinDt=" + userJoinDt + ", userPoint=" + userPoint
				+ ", userLastLogin=" + userLastLogin + ", userIsAdmin=" + userIsAdmin + ", userIsActive=" + userIsActive
				+ ", toString()=" + super.toString() + "]";
	}

}// --class

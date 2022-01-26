package kr.scott.ngg.user.service;

import java.sql.SQLException;
import java.util.List;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.PieVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.user.domain.UserVO;

public interface UserService {

	// --------------------- default functions
	/**
	 * 단건 등록
	 * 
	 * @param UserVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(UserVO inVO) throws SQLException;

	/**
	 * 단건 삭제
	 * 
	 * @param UserVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(UserVO inVO) throws SQLException;

	/**
	 * 단건 수정
	 * 
	 * @param UserVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(UserVO inVO) throws SQLException;

	/**
	 * 단건 조회
	 * 
	 * @param UserVO
	 * @return UserVO
	 */
	public UserVO doSelectOne(UserVO inVO) throws SQLException;

	/**
	 * 목록 조회(with 검색, 페이징)
	 * 
	 * @param UserVO
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	public List<UserVO> doRetrieve(SearchVO inVO) throws SQLException;

	
	// --------------------- User functions
	/**
	 * 사용자가 입력한 값을 DB 정보와 비교하여 일치하면 로그인 처리
	 * 
	 * @param UserVO
	 * @return MessageVO
	 * @throws SQLException
	 */
	public MessageVO doLogin(UserVO inVO) throws SQLException;
	
	/**
	 * 입력한 아이디 값이 DB에 존재하는지 확인
	 * 
	 * @param UserVO
	 * @return int 1(중복)/0(중복X)
	 * @throws SQLException
	 */
	public int idCheck(UserVO inVO);

	/**
	 * 입력한 닉네임 값이 DB에 존재하는지 확인
	 * 
	 * @param UserVO
	 * @return int 1(중복)/0(중복X)
	 * @throws SQLException
	 */
	public int nnCheck(UserVO inVO);
	
	/**
	 * 최종 접속일 갱신
	 * 
	 * @param UserVO
	 * @return int 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int updateLastLogin(UserVO inVO) throws SQLException;
	
	// --------------------- Admin User functions
	/**
	 * 가입자 현황: 한 주를 기준으로 일 별 가입자 수를 반환 
	 * 
	 * @param String dateStr : must include "yyyyMMdd"
	 * @return PieVO : label:"yyyy/MM/dd", value:regCnt
	 * @throws SQLException
	 */
	public List<PieVO> getDailyRegCnt (String dateStr) throws SQLException;
	
	/**
	 * 가입자 현황: 한 달을 기준으로 주 별 가입자 수를 반환 
	 * 
	 * @param String dateStr : format -> "yyyyMM"
	 * @return PieVO : label:weekNo, value:regCnt
	 * @throws SQLException
	 */
	public List<PieVO> getWeeklyRegCnt (String dateStr) throws SQLException;

}

package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.Users;

public interface UserDao {
	/**
	 * 로그인, 마이페이지등
	 * @param userId
	 * @return
	 */
	public Users selectById(String userId) throws SQLException;
	
	/**
	 * 아이디 찾기, 회원가입시 중복 방지
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public Users selectByPhone(String phone) throws SQLException;
	
	/**
	 * 전체회원 검색(관리자)
	 * @return
	 */
	public List<Users> selectAll() throws SQLException;
	
	/**
	 * 유저 정보수정(사용자 수정 비밀번호, 주소, 연락처)
	 * @param user
	 * @return
	 */
	public int updateStatus(Users user) throws SQLException;
	
	/**
	 * 회원가입
	 * @param user
	 * @return
	 */
	public int insert(Users user) throws SQLException;
	
	
	/**
	 * 회원탈퇴, 관리자 기능 (비활성화)
	 * @param userId
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public int withdrawMember(String userId, String password)throws SQLException;
	
	/**
	 * 유저 비밀번호 찾기
	 * @param userId
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public Users selectByIdPhone(String userId, String phone)throws SQLException;
}

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
	 * 전체회원 검색(관리자)
	 * @return
	 */
	public List<Users> selectAll() throws SQLException;
	
	/**
	 * 유저 정보수정(사용자 수정 비밀번호, 주소, 연락처, 회원탈퇴), 관리자 수정(비활성화)
	 * @param user
	 * @return
	 */
	public int update(Users user) throws SQLException;
	
	/**
	 * 회원가입
	 * @param user
	 * @return
	 */
	public int insert(Users user) throws SQLException;
}

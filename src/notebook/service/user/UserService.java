package notebook.service.user;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.Users;
import notebook.exception.DuplicateException;
import notebook.exception.NotFoundException;
import notebook.exception.PasswordException;
import notebook.dao.UserDao;
import notebook.dao.UserDaoImpl;

public class UserService {
	private static UserDao userDao = new UserDaoImpl();
	
	public static List<Users> selectAll() throws SQLException{
		List<Users> list = userDao.selectAll();
		return list;
	}
	
	public static void withdrawMember(String userId, String password) throws SQLException, PasswordException {
		int result = userDao.withdrawMember(userId, password);
		if(result == 0) {
			throw new PasswordException("비밀번호가 일치하지 않습니다.");
		}
	}
	
	public static void insert(Users user) throws DuplicateException, SQLException {
		Users u = userDao.selectById(user.getUserId());
		if(u != null) {
			throw new DuplicateException("사용할 수 없는 아이디 입니다.");
		}
		
		u = userDao.selectByPhone(user.getPhone());
		if(u != null) {
			throw new DuplicateException("이미 등록된 전화번호 입니다.");
		}
		if(userDao.insert(user) == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}
	
	public static void updateStatus(Users user) throws SQLException {
		if(userDao.updateStatus(user) == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}
	
	public static Users selecById(String userId) throws SQLException, NotFoundException{
		Users user = userDao.selectById(userId);
		if(user == null) {
			throw new NotFoundException("회원 정보가 없습니다.");
		}
		return user;
	}
}

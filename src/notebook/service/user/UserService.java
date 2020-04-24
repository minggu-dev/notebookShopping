package notebook.service.user;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.Users;
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
}

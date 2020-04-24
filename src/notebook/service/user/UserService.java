package notebook.service.user;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.Users;
import notebook.dao.UserDao;
import notebook.dao.UserDaoImpl;

public class UserService {
	UserDao userDao = new UserDaoImpl();
	public List<Users> selectAll() throws SQLException{
		List<Users> list = userDao.selectAll();
		return list;
	}
}

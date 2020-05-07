package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.Questions;
import notebook.domain.Users;
import notebook.util.DbUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Users selectById(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users users = null;
		String sql = "SELECT user_id, pwd, name, addr, phone, answer, que_no, question, state FROM userview WHERE user_id = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				users = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), new Questions(rs.getInt(7), rs.getString(8)), rs.getInt(9));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return users;
	}

	@Override
	public List<Users> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users order by state";
		List<Users> list = new ArrayList<Users>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), null, rs.getInt(8)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int updateStatus(Users user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE users SET pwd = ?, addr = ?, phone = ? WHERE user_id = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPwd());
			ps.setString(2, user.getAddr());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUserId());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(Users user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO users(user_id, pwd, name, addr, phone, answer, que_no) VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddr());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAnswer());
			ps.setInt(7, user.getQuestion().getQueNo());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int withdrawMember(String userId, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE users SET state = 2, phone = 'trash' || seq_trash.NEXTVAL  WHERE user_id = ? and pwd = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Users selectByPhone(String phone) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users users = null;
		String sql = "SELECT user_id, pwd, name, addr, phone, answer, que_no, question, state FROM userview WHERE phone = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				users = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), new Questions(rs.getInt(7), rs.getString(8)), rs.getInt(9));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return users;
	}
	
	@Override
	public Users selectByIdPhone(String userId, String phone) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users users = null;
		String sql = "SELECT user_id, pwd, name, addr, phone, answer, que_no, question, state FROM userview WHERE phone = ? AND user_id = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				users = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), new Questions(rs.getInt(7), rs.getString(8)), rs.getInt(9));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return users;
	}
}

package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import notebook.domain.CartList;
import notebook.util.DbUtil;

public class CartListDaoImpl implements CartListDao {

	@Override
	public List<CartList> selectById(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
	}

	@Override
	public int insert(CartList list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

	@Override
	public int update(CartList list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

}

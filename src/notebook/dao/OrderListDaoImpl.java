package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import notebook.domain.OrderList;
import notebook.util.DbUtil;

public class OrderListDaoImpl implements OrderListDao {

	@Override
	public List<OrderList> selectBySerialNum(String serialNum) throws SQLException {
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
	public List<OrderList> selectAll() throws SQLException {
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
	public int delete(int orderNo, String serialNum) throws SQLException {
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
	public int insert(OrderList list) throws SQLException {
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

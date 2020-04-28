package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.CartList;
import notebook.domain.Product;
import notebook.util.DbUtil;

public class CartListDaoImpl implements CartListDao {
	@Override
	public List<CartList> selectById(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT serialnum, model_name, company, price, img_name, quantity FROM cartlistview where user_id = ?";
		List<CartList> list = new ArrayList<CartList>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
	
			
			while(rs.next()) {
				Product product = new Product();
				product.setSerialNum(rs.getString(1));
				product.setModelName(rs.getString(2));
				product.setCompany(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setImgName(rs.getString(5));
				list.add(new CartList(userId, product, rs.getInt(6)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
			return list;

	}

	@Override
	public int insert(CartList list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO cart_list VALUES(?, ?, ?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, list.getProduct().getSerialNum());
			ps.setString(2, list.getUserId());
			ps.setInt(3, list.getQuantity());

			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int update(CartList list) throws SQLException {
		Connection con = null;

		PreparedStatement ps = null;
		String sql = "UPDATE cart_list SET quantity = ? where serialnum = ? and user_id = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, list.getQuantity());
			ps.setString(2, list.getProduct().getSerialNum());
			ps.setString(3, list.getUserId());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE cart_list where user_id = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public CartList selectByIdSerialNum(String userId, String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT model_name, company, price, img_name, quantity FROM cartlistview where user_id = ? AND serialnum = ?";
		CartList cart = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, serialNum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Product product = new Product();
				product.setSerialNum(serialNum);
				product.setModelName(rs.getString(1));
				product.setCompany(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setImgName(rs.getString(4));
				cart = new CartList(userId, product, rs.getInt(5));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return cart;
	}
	
	@Override
	public int deleteOne(String userId, String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE cart_list where user_id = ? AND serialnum = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, serialNum);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}

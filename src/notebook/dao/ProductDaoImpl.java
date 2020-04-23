package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import notebook.domain.Product;
import notebook.util.DbUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product selectByNum(String serialNum) throws SQLException {
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
	public List<Product> selectByPriceRange(int minPrice, int maxPrice) throws SQLException {
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
	public List<Product> selectNewProducts() throws SQLException {
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
	public List<Product> selectBestProducts() throws SQLException {
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
	public List<Product> selectRendomProducts() throws SQLException {
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
	public List<Product> selectSortProduct(String target) throws SQLException {
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
	public int update(Product product) throws SQLException {
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
	public int insert(Product product) throws SQLException {
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

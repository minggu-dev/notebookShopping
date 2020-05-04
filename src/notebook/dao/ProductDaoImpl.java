package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import notebook.domain.BoardReview;
import notebook.domain.Product;
import notebook.util.DbUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Map<String, Object> selectByNum(String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//상품 정보들 가져오기
			String sql = "SELECT * FROM product WHERE serialnum = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13));
				map.put("product", product);
			}
			if(product == null) {
				con.rollback();
				throw new SQLException("상품찾기 오류");
			}
			rs.close();
			ps.close();
			
			//상품 후기들 가져오기
			sql = "select * from board_review where serialnum=? ORDER BY review_no";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			List<BoardReview> list = new ArrayList<BoardReview>();
			
			while(rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String userId = rs.getString("user_id");
				String imgName = rs.getString("img_name");
				String createDate = rs.getString("create_date");
				String content = rs.getString("content");
				int grade = rs.getInt("grade");
				
				list.add(new BoardReview(reviewNo, userId, imgName, createDate, content, serialNum, grade));
			}
			map.put("boardReview", list);
			
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return map;
	}

	@Override
	public List<Product> selectByPriceRange(int minPrice, int maxPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Product> selectNewProducts() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT serialnum, model_name, company, price, ram, cpu, note_size, note_weight, launch_date, stock, grade, description_img_name, img_name"
				+ " FROM (select rownum, p.* FROM (SELECT * FROM product order by launch_date desc) p)pro"
				+ " WHERE rownum < 4";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Product> selectBestProducts() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT serialnum, model_name, company, price, ram, cpu, note_size, note_weight, launch_date, stock, grade, description_img_name, img_name"
				+ " FROM (select rownum, p.* FROM (SELECT * FROM product order by grade desc) p)pro"
				+ " WHERE rownum < 5";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Product> selectRendomProducts() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT serialnum, model_name, company, price, ram, cpu, note_size, note_weight, launch_date, stock, grade, description_img_name, img_name"
				+ " FROM (SELECT rownum, p.* FROM (SELECT * FROM product order by dbms_random.value) p) WHERE rownum < 5";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Product> selectSortProduct(String target) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product ORDER BY ";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			if(target == null || target.equals("")) {
				sql += "serialnum";
			}else if("price_desc".equals(target)) {	//가격높은순
				sql += "price desc";	
			}else if("price_asc".equals(target)) {	//가격낮은순
				sql += "price";
			}else if("new".equals(target)) { //신상품
				sql += "launch_date desc";
			}else if("grade".equals(target)) {	//평점
				sql += "grade desc";
			}
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int updateProduct(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE product SET model_name = ?, company = ?, price = ?, ram = ?, cpu = ?, note_size = ?, note_weight = ?, stock = ? WHERE serialnum = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getModelName());
			ps.setString(2, product.getCompany());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getRam());
			ps.setString(5, product.getCpu());
			ps.setInt(6, product.getNoteSize());
			ps.setDouble(7, product.getNoteWeight());
			ps.setInt(8, product.getStock());
			ps.setString(9, product.getSerialNum());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO product(serialnum, model_name, company, price, ram, cpu, note_size, note_weight, launch_date, description_img_name, img_name) VALUES(seq_serialnum.NEXTVAL, ?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getModelName());
			ps.setString(2, product.getCompany());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getRam());
			ps.setString(5, product.getCpu());
			ps.setInt(6, product.getNoteSize());
			ps.setDouble(7, product.getNoteWeight());
			ps.setString(8, product.getLaunchDate());
			ps.setString(9, product.getDescriptionImgName());
			ps.setString(10, product.getImgName());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<Product> searchProduct(String target, String search) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE ";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			if("company".equals(target)) {
				sql += "company LIKE ?";
			}else if("model_name".equals(target)) {
				sql += "model_name LIKE ?";
			}
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int grantGrade(String serialNum, double grade) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE product SET grade = ? WHERE serialnum = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, grade);
			ps.setString(2, serialNum);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateStock(String serialNum, int stock) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE product SET stock = ? WHERE serialnum = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setString(2, serialNum);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public List<Product> selectByCompany(String company) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE company = ? ORDER BY serialnum";
		List<Product> list = new ArrayList<Product>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, company);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(9)
						, rs.getInt(10), rs.getDouble(11), rs.getString(12), rs.getString(13)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}

package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.OrderList;
import notebook.domain.Product;
import notebook.util.DbUtil;

public class OrderListDaoImpl implements OrderListDao {

	@Override
	public List<OrderList> selectBySerialNum(String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT model_name, grade, img_name, order_no, quantity FROM order_list_view where serialnum = ?";
		List<OrderList> list = new ArrayList<OrderList>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setSerialNum(serialNum);
				product.setModelName(rs.getString(1));
				product.setGrade(rs.getDouble(2));
				product.setImgName(rs.getString(3));
				OrderList orderList = new OrderList(product, rs.getInt(4), rs.getInt(5));
				list.add(orderList);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(OrderList list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO order_list VALUES(?, ?, ?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, list.getOrderNo());
			ps.setString(2, list.getProduct().getSerialNum());
			ps.setInt(3, list.getQuantity());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}

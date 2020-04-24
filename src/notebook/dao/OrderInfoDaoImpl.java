package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.OrderInfo;
import notebook.domain.OrderList;
import notebook.domain.Product;
import notebook.util.DbUtil;

public abstract class OrderInfoDaoImpl implements OrderInfoDao {

	@Override
	public OrderInfo selectByNo(int orderNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM order_info_view WHERE order_no = ?";
		OrderInfo orderInfo = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			rs = ps.executeQuery();
			
			boolean isFirst = true;
			List<OrderList> orderLists = new ArrayList<OrderList>();
			while(rs.next()) {
				if(isFirst) {
					orderInfo = new OrderInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getString(7), orderLists);
					isFirst = false;
				}
				OrderList orderList = new OrderList(null, orderNo, rs.getInt(8));
				Product product = new Product();
				product.setSerialNum(rs.getString(9));
				product.setModelName(rs.getString(10));
				product.setCompany(rs.getString(11));
				product.setImgName(rs.getString(12));
				orderList.setProduct(product);
				orderLists.add(orderList);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return orderInfo;
	}

	@Override
	public List<OrderInfo> selectById(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM order_info WHERE user_id = ?";
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), null));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<OrderInfo> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM order_info";
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), null));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int updateDelivery(int orderNo, int deliveryState) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE order_info SET delivery_state = ? WHERE order_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, deliveryState);
			ps.setInt(2, orderNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int orderNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE order_info where order_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(OrderInfo info) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO order_info(order_no, user_id, total_price, addr_delivery) VALUES(seq_order.NEXTVAL, ?, ?, ?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, info.getUserId());
			ps.setInt(2, info.getTotalPrice());
			ps.setString(3, info.getAddrDelivery());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int updateAddr(int orderNo, String addrDelivery) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE order_info SET addr_delivery = ? WHERE order_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, addrDelivery);
			ps.setInt(2, orderNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int updateRefundRequest(int orderNo, boolean request) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE order_info SET refund_state = ? WHERE order_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			int refundState = request ? 1 : 0;
			ps.setInt(1, refundState);
			ps.setInt(2, orderNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}

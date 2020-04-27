package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.CartList;
import notebook.domain.OrderInfo;
import notebook.domain.OrderList;
import notebook.domain.Product;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;
import notebook.util.DbUtil;

public class OrderInfoDaoImpl implements OrderInfoDao {

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
			//가격 추가해야함
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
				product.setPrice(rs.getInt(13));
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
	public void delete(int orderNo) throws SQLException, NotFoundException, CannotModifyException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//구매상세 가져오기
			String sql = "SELECT serialnum, quantity FROM order_list WHERE order_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			rs = ps.executeQuery();
			
			List<OrderList> orderList = new ArrayList<>();
			while(rs.next()) {
				Product product = new Product();
				product.setSerialNum(rs.getString("serialnum"));
				orderList.add(new OrderList(product, orderNo, rs.getInt("quantity")));
			}
			if(orderList.size() == 0) {
				con.rollback();
				throw new NotFoundException("주문 상세 내역을 찾을 수 없습니다.");
			}
			ps.close();
			
			//구매내역 삭제하기(리스트는 cascade로 같이 삭제가 된다.)
			sql = "DELETE order_info where order_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			if(ps.executeUpdate() == 0) {
				con.rollback();
				throw new NotFoundException("주문내역을 찾을 수 없습니다.");
			}
			ps.close();
			
			//상품 재고 다시 돌려놓기
			for(OrderList list : orderList) {
				sql = "UPDATE product SET stock = stock + ? WHERE serialnum = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, list.getQuantity());
				ps.setString(2, list.getProduct().getSerialNum());
				if(ps.executeUpdate() == 0) {
					con.rollback();
					throw new CannotModifyException("상품 재고를 추가할 수 없습니다.");
				}
			}
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	}

	@Override
	public void insert(OrderInfo info) throws SQLException, NotFoundException, CannotModifyException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//장바구니 찾아오기
			String sql = "SELECT serialnum, price, quantity FROM cartlistview where user_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, info.getUserId());
			rs = ps.executeQuery();
			
			List<CartList> cartList = new ArrayList<CartList>();
			while(rs.next()) {
				Product product = new Product();
				product.setSerialNum(rs.getString(1));
				product.setPrice(rs.getInt(2));
				cartList.add(new CartList(info.getUserId(), product, rs.getInt(3)));
			}
			if(cartList.size() == 0) {
				con.rollback();
				throw new NotFoundException("장바구니가 없습니다.");
			}
			ps.close();
			rs.close();
			
			//구매내역 추가
			sql = "INSERT INTO order_info(order_no, user_id, total_price, addr_delivery) VALUES(seq_order.NEXTVAL, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, info.getUserId());
			ps.setInt(2, info.getTotalPrice());
			ps.setString(3, info.getAddrDelivery());
			if(ps.executeUpdate() == 0) {
				con.rollback();
				throw new SQLException();
			}
			ps.close();
			
			//구매 번호를 가져온다.
			sql = "SELECT seq_order.CURRVAL FROM dual";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int orderNo = 0;
			if(rs.next()) {
				orderNo = rs.getInt(1);
			}
			if(orderNo == 0) {
				con.rollback();
				throw new SQLException();
			}
			ps.close();
			
			//구매 상세 추가
			for(CartList cart : cartList) {
				sql = "INSERT INTO order_list VALUES(?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, orderNo);
				ps.setString(2, cart.getProduct().getSerialNum());
				ps.setInt(3, cart.getQuantity());
				if(ps.executeUpdate() == 0) {
					con.rollback();
					throw new SQLException();
				}
				ps.close();
			}

			//상품 재고 감소시키기
			for(CartList cart : cartList) {
				sql = "UPDATE product SET stock = stock - ? WHERE serialnum = ? AND stock >= ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getQuantity());
				ps.setString(2, cart.getProduct().getSerialNum());
				ps.setInt(3, cart.getQuantity());
				if(ps.executeUpdate() == 0) {
					con.rollback();
					throw new CannotModifyException("상품 수량을 감소할 수 없습니다.");
				}
				ps.close();
			}
			
			//장바구니 비우기
			sql = "DELETE cart_list WHERE user_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, info.getUserId());
			if(ps.executeUpdate() == 0) {
				con.rollback();
				throw new NotFoundException("장바구니가 없습니다.");
			}
			ps.close();
			
			
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
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

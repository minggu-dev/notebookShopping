package notebook.service;

import java.sql.SQLException;
import java.util.List;

import notebook.dao.OrderInfoDao;
import notebook.dao.OrderInfoDaoImpl;
import notebook.dao.OrderListDao;
import notebook.dao.OrderListDaoImpl;
import notebook.domain.CartList;
import notebook.domain.OrderInfo;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public class PurchaseService {
	private static OrderListDao orderListDao = new OrderListDaoImpl();
	private static OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
	
	public static void updateAddr(int orderNo, String addrDelivery, String userId) throws SQLException, CannotModifyException{
		if(orderInfoDao.updateAddr(orderNo, addrDelivery, userId) == 0) {
			throw new CannotModifyException("배송지 변경 불가");
		}
	}
	
	public static List<OrderInfo> selectAll() throws SQLException{
		List<OrderInfo> list = orderInfoDao.selectAll();
		
		return list;
	}
	
	public static OrderInfo selectByNo(int orderNo, String userId) throws SQLException, NotFoundException{
		OrderInfo info = orderInfoDao.selectByNo(orderNo);
		
		if(info == null) {
			throw new NotFoundException("주문 내역을 찾을 수 없습니다.");
		}
		if(!info.getUserId().equals(userId)) {
			throw new NotFoundException("구매자만 변경할 수 있습니다.");
		}
		return info;
	}
	
	public static List<OrderInfo> selectById(String userId) throws SQLException{
		List<OrderInfo> list = orderInfoDao.selectById(userId);
		return list;
	}
	
	public static void purchaseOrder(OrderInfo info) throws SQLException, NotFoundException, CannotModifyException{
		orderInfoDao.insert(info);
		
	}
	
	public static void deliveryState(int orderNo, int deliveryState) throws SQLException, CannotModifyException{
		if(orderInfoDao.updateDelivery(orderNo, deliveryState) == 0) {
			throw new CannotModifyException("배송상태를 변경할 수 없습니다.");
		}
	}
	
	public static void refundState(int orderNo, boolean request, String userId) throws SQLException, CannotModifyException{
		if(orderInfoDao.updateRefundRequest(orderNo, request, userId)==0) {
			throw new CannotModifyException("환불 요청을 할 수 없습니다.");
		}
	}
	
	public static void refundOrder(int orderNo) throws SQLException, NotFoundException, CannotModifyException{
		orderInfoDao.delete(orderNo);
	}
}

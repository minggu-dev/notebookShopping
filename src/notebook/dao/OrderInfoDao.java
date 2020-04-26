package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.OrderInfo;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public interface OrderInfoDao {
	/**
	 * 번호로 구매내역 검색(구매 상세보기)
	 * @param orderNo
	 * @return
	 */
	public OrderInfo selectByNo(int orderNo) throws SQLException;
	
	/**
	 * 유저별 구매내역 보기(구매내역만)
	 * @param userId
	 * @return
	 */
	public List<OrderInfo> selectById(String userId) throws SQLException;
	
	/**
	 * 전체 구매내역(관리자)
	 * @return
	 */
	public List<OrderInfo> selectAll() throws SQLException;
	
	/**
	 * 배송상태 변경
	 * @param info
	 * @return
	 */
	public int updateDelivery(int orderNo, int deliveryState) throws SQLException;
	
	/**
	 * 환불 요청
	 * @param orderNo
	 * @param request  true면 환불요청, false면 환불취소
	 * @return
	 * @throws SQLException
	 */
	public int updateRefundRequest(int orderNo, boolean request) throws SQLException;
	
	/**
	 * 배송지 변경
	 * @param orderNo
	 * @param addrDelivery
	 * @return
	 * @throws SQLException
	 */
	public int updateAddr(int orderNo, String addrDelivery) throws SQLException;
	
	/**
	 * 환불(관리자)
	 * @param orderNo
	 * @return
	 */
	public void delete(int orderNo) throws SQLException, NotFoundException, CannotModifyException;
	
	/**
	 * 구매시
	 * @param info
	 * @return
	 */
	public void insert(OrderInfo info) throws SQLException, NotFoundException, CannotModifyException;
}

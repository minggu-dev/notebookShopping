package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.OrderInfo;

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
	 * 배송상태, 환불시
	 * @param info
	 * @return
	 */
	public int update(OrderInfo info) throws SQLException;
	
	/**
	 * 전체환불
	 * @param orderNo
	 * @return
	 */
	public int delete(int orderNo) throws SQLException;
	
	/**
	 * 구매시
	 * @param info
	 * @return
	 */
	public int insert(OrderInfo info) throws SQLException;
}

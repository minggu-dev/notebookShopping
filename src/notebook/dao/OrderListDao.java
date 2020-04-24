package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.OrderList;

public interface OrderListDao {
	/**
	 * 상품별 구매내역 보기
	 * @param serialNum
	 * @return
	 */
	public List<OrderList> selectBySerialNum(String serialNum) throws SQLException;
	
	/**
	 * 구매시
	 * @param list
	 * @return
	 */
	public int insert(OrderList list) throws SQLException;
}

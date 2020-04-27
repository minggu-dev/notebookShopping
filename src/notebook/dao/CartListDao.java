package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.CartList;

public interface CartListDao {
	/**
	 * 회원이 장바구니 볼 때
	 * @param userId
	 * @return
	 */
	public List<CartList> selectById(String userId) throws SQLException;
	
	/**
	 * 장바구니 추가
	 * @param list
	 * @return
	 */
	public int insert(CartList list) throws SQLException;
	
	/**
	 * 장바구니 수정(수량변경 등등)
	 * @param list
	 * @return
	 */
	public int update(CartList list) throws SQLException;
	
	/**
	 * 장바구니 비우기
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public int delete(String userId) throws SQLException;
	
	/**
	 * 장바구니에 상품 있는지 확인
	 * @param userId
	 * @param serialNum
	 * @return
	 * @throws SQLException
	 */
	public CartList selectByIdSerialNum(String userId, String serialNum) throws SQLException;
}

package notebook.service;

import java.sql.SQLException;
import java.util.List;

import notebook.dao.CartListDao;
import notebook.dao.CartListDaoImpl;
import notebook.domain.CartList;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public class CartService {
	private static CartListDao cartDao = new CartListDaoImpl();
	
	public static void updateCart (CartList cart)throws SQLException, CannotModifyException{
		if(cartDao.update(cart) == 0) {
			throw new CannotModifyException("카트 수량 수정 불가능");
		}
	}

	public static void cartEmpty(String userId) throws SQLException, NotFoundException{
		int result = cartDao.delete(userId);
		if(result == 0) {
			throw new NotFoundException("장바구니가 존재하지 않습니다.");
		}
	}
	
	public static void insert(CartList list) throws SQLException, CannotModifyException{
		int result = 0;
		CartList cart = cartDao.selectByIdSerialNum(list.getUserId(), list.getProduct().getSerialNum());
		
		if(cart == null) {
			result = cartDao.insert(list);
		}else {
			list.setQuantity(list.getQuantity() + cart.getQuantity());
			result = cartDao.update(list);
		}
		if(result == 0) {
			throw new CannotModifyException("장바구니에 담을 수 없습니다.");
		}
	}
	
	public static List<CartList> showMyCart(String userId) throws SQLException{
		List<CartList> list = cartDao.selectById(userId);
		return list;
	}
}

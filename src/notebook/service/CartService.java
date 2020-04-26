package notebook.service;

import java.sql.SQLException;

import notebook.dao.CartListDao;
import notebook.dao.CartListDaoImpl;
import notebook.domain.CartList;
import notebook.exception.CannotModifyException;

public class CartService {
	private static CartListDao cartDao = new CartListDaoImpl();
	
	public static void updateCart (CartList cart)throws SQLException, CannotModifyException{
		if(cartDao.update(cart) == 0) {
			throw new CannotModifyException("카트 수량 수정 불가능");
		}
		
	}
}

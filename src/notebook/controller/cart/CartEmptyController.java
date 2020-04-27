package notebook.controller.cart;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.EmptyStockException;
import notebook.service.CartService;

public class CartEmptyController implements Controller {

	//장바구니 비우기 기능

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		String quantity = request.getParameter("quantity");
		String serialNum = request.getParameter("serialNum");
		
		if(Integer.parseInt(quantity)==0) {
			throw new EmptyStockException("장바구니에 상품이 없어 비울 수 없습니다.");
		}
		
		Product pro = new Product();
		pro.setSerialNum(serialNum);
		
		CartService.cartEmpty(userId);
		ModelAndView mv = new ModelAndView(true, "cart");
		return mv;
	}

}

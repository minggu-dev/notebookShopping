package notebook.controller.cart;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.CartService;

/**
 * 장바구니 비우기
 * @author kosta
 *
 */
public class CartEmptyController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		if(userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		CartService.cartEmpty(userId);
		ModelAndView mv = new ModelAndView(true, "장바구니 페이지");
		return mv;
	}

}

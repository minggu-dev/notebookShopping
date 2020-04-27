package notebook.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.CartList;
import notebook.exception.NotEnoughParameterException;
import notebook.service.CartService;

/**
 * 내 장바구니 보기
 * @author kosta
 *
 */
public class CartShowMyCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		if(userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		List<CartList> list = CartService.showMyCart(userId);
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show my cart");
		return mv;
	
	}

}

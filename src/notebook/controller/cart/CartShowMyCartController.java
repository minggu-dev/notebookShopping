package notebook.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.CartList;
import notebook.service.CartService;

public class CartShowMyCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		
		List<CartList> list = CartService.showMyCart(userId);
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show my cart");
		return mv;
	
	}

}

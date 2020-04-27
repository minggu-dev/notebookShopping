package notebook.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.CartList;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.CartService;
/**
 * 장바구니 추가
 * @author kosta
 *
 */
public class CartInsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String serialNum = request.getParameter("serialNum");
		String userId = request.getParameter("userId");
		String quantity = request.getParameter("quantity");
		
		if(serialNum == null || serialNum.equals("") || userId == null || userId.equals("")||
				quantity == null || quantity.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지않습니다.");
		}
		
		Product pro = new Product();
		pro.setSerialNum(serialNum);
		CartList cart = new CartList(userId, pro, Integer.parseInt(quantity));
		CartService.insert(cart);
		
		ModelAndView mv = new ModelAndView(true, "ajax로..?");
		return mv;
	}

}

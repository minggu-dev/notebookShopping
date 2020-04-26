package notebook.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.CartList;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.CartService;

/**
 * 장바구니 수량 변경(ajax)
 * @author 김민호
 *
 */
public class CartUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String serialNum = request.getParameter("serialNum");
		String count = request.getParameter("count");
		JSONObject jsonObj = new JSONObject();
		
		if(userId == null || userId.equals("") || serialNum == null || serialNum.equals("") || count == null || count.equals("")) {
			jsonObj.put("status",2);
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		CartList cart = new CartList();
		Product p = new Product();
		p.setSerialNum(serialNum);
		cart.setProduct(p);
		cart.setQuantity(Integer.parseInt(count));
		cart.setUserId(userId);
		CartService.updateCart(cart);
		jsonObj.put("status", 1);
		request.setAttribute("jsonObj", jsonObj);
		return null;
	}

}

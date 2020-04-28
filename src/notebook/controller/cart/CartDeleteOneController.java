package notebook.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.CartService;

/**
 * 장바구니에서 하나 삭제
 * @author kosta
 *
 */
public class CartDeleteOneController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String serialNum = request.getParameter("serialNum");
		if(userId == null || userId.equals("") || serialNum == null || serialNum.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		CartService.deleteOne(userId, serialNum);
		ModelAndView mv = new ModelAndView(true, "장바구니페이지로");
		return mv;
	}
}

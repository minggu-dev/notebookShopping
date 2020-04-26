package notebook.controller.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.OrderInfo;
import notebook.exception.NotEnoughParameterException;
import notebook.service.PurchaseService;

/**
 * 상품 구매시
 * @author 김민호
 *
 */
public class PurInsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String totalPrice = request.getParameter("totalPrice");
		String addrDelivery = request.getParameter("addrDelivery");
		
		if(userId == null || userId.equals("") || totalPrice == null || totalPrice.equals("") || addrDelivery == null || addrDelivery.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		OrderInfo info = new OrderInfo();
		info.setUserId(userId);
		info.setTotalPrice(Integer.parseInt(totalPrice));
		info.setAddrDelivery(addrDelivery);
		PurchaseService.purchaseOrder(info);
		ModelAndView mv = new ModelAndView(false, "구매성공 페이지");
		
		return mv;
	}
}

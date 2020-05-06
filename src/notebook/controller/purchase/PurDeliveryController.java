package notebook.controller.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.PurchaseService;

/**
 * 상품 배송정보 변경
 * @author 김민호
 *
 */
public class PurDeliveryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orderNo = request.getParameter("orderNo");
		String userId = (String)request.getSession().getAttribute("id");
		String addrDelivery = request.getParameter("deliveryAddr");
		
		if(orderNo == null || orderNo.equals("") || addrDelivery == null || addrDelivery.equals("") || userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		PurchaseService.updateAddr(Integer.parseInt(orderNo), addrDelivery, userId);
		ModelAndView mv = new ModelAndView(false, "note?command=purUser");
		return mv;
	}

}

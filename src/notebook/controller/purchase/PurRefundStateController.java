package notebook.controller.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.PurchaseService;

/**
 * 환불 요청하기
 * @author 김민호
 *
 */
public class PurRefundStateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orderNo = request.getParameter("orderNo");
		String req = request.getParameter("request");
		String userId = (String)request.getSession().getAttribute("id");
		
		if(orderNo == null|| orderNo.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		//true가 환불요청
		boolean refund = req == null || req.equals("") ? false : true;
		PurchaseService.refundState(Integer.parseInt(orderNo), refund, userId);
		ModelAndView mv = new ModelAndView(false, "note?command=purUser");
		
		return mv;
	}

}

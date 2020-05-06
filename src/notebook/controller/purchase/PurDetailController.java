package notebook.controller.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.OrderInfo;
import notebook.exception.NotEnoughParameterException;
import notebook.service.PurchaseService;

/**
 * 구매내역 상세보기
 * @author 김민호
 *
 */
public class PurDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orderNo = request.getParameter("orderNo");
		String userId = (String)request.getSession().getAttribute("id");
		if(orderNo == null ||orderNo.equals("") || userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		OrderInfo info = PurchaseService.selectByNo(Integer.parseInt(orderNo), userId);
		request.setAttribute("info", info);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orderInfoDetail.jsp");
		return mv;
	}

}

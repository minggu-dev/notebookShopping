package notebook.controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ProductService;

/**
 * 상품 하나 상세보기
 * @author 김민호
 *
 */
public class ProShowDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serialNum = request.getParameter("serialNum");
		if(serialNum == null || serialNum.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		Product product = ProductService.selectBySerialNum(serialNum);
		request.setAttribute("product", product);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("상품 상세보기 페이지");
		return mv;
	}

}

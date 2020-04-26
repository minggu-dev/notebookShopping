package notebook.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ProductService;

/**
 * 회사, 모델명으로 상품들 검색하기
 * @author 김민호
 *
 */
public class ProSearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String target = request.getParameter("target");
		String search = request.getParameter("search");
		
		if(target == null || target.equals("") || search == null || search.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		List<Product> list = ProductService.searchProduct(target, search);
		
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("상품 검색 보기");
		return mv;
	}

}

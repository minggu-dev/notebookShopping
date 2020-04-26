package notebook.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.service.ProductService;

/**
 * 전체상품 정렬해서 보기
 * @author 김민호
 *
 */
public class ProSelectAllSortController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String target = request.getParameter("target");
		
		List<Product> list = ProductService.selectAllSortProduct(target);
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("상품 전체보기");
		return mv;
	}

}

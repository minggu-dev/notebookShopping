package notebook.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.service.ProductService;

/**
 * 가격으로 상품 검색
 * @author 김민호
 *
 */
public class ProSelectByPriceRangeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String minPrice = request.getParameter("min");
		if(minPrice == null || minPrice.equals("")) {
			minPrice = "0";
		}
		String maxPrice = request.getParameter("max");
		if(maxPrice == null || maxPrice.equals("")) {
			maxPrice = "9999999";
		}
		List<Product> list = ProductService.selectByPriceRange(Integer.parseInt(minPrice), Integer.parseInt(maxPrice));
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("가격으로 상품 검색");
		return mv;
	}

}

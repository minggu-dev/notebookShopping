package notebook.controller.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.service.ProductService;

/**
 * 화면 구성하기 위한 Controller
 * 홈페이지에 신상품 3개, 베스트 상품 3개, 아무 상품 3개 골라서 뿌리기
 */
public class ProHomeController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, List<Product>> map = ProductService.homePage();
		request.setAttribute("map", map);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		
		response.getWriter().print(map);
		return mv;
	}

}

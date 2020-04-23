package notebook.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;

public class ProHomeController implements Controller {

	/**
	 * 화면 구성하기 위한 Controller
	 * 홈페이지에 신상품 3개, 베스트 상품 3개, 아무 상품 3개 골라서 뿌리기
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> newProducts = new ArrayList<Product>();
		List<Product> bestProducts = new ArrayList<Product>();
		List<Product> randomProducts = new ArrayList<Product>();
		
		return null;
	}

}

package notebook.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		PagingObject pageObj = new PagingObject();
		pageObj.setAllRecord(list.size());
		pageObj.setTotalPage(list.size() / 12 + (list.size() % 12 == 0 ? 0 : 1));

		String page = request.getParameter("page");
		if(page == null || page.equals("")) {
			page = "1";
		}
		
		int pageInt = Integer.parseInt(page);
		if(pageInt >= pageObj.getTotalPage()) {
			pageInt = pageObj.getTotalPage();
		}else if(pageInt < 1) {
			pageInt = 1;
		}
		if(list.size() >= pageInt * pageObj.getPageRecord()) {
			list = list.subList((pageInt - 1) * pageObj.getPageRecord(), pageInt * pageObj.getPageRecord());
		}else {
			list = list.subList((pageInt - 1) * pageObj.getPageRecord(), list.size());
		}
		request.setAttribute("list", list);
		request.setAttribute("pageObj", pageObj);
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.setViewName("productAll.jsp");
		
		return mv;
	}
}
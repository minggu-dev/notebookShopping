package notebook.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ProductService;

public class ProSelectByCompanyController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String company = request.getParameter("company");
		if(company == null || company.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		List<Product> list = ProductService.selectByCompany(company);
		request.setAttribute("list", list);
		

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
		
		if(pageInt * pageObj.getPageRecord() <= list.size()) {
			list = list.subList((pageInt - 1) * pageObj.getPageRecord(), pageInt * pageObj.getPageRecord());
		}else {
			list = list.subList((pageInt - 1) * pageObj.getPageRecord(), list.size());
		}
		request.setAttribute("list", list);
		request.setAttribute("pageObj", pageObj);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productAll.jsp");
		return mv;
	}
}

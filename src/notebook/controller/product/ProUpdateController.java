package notebook.controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ProductService;

/**
 * 상품 수정하기(
 * @author 김민호
 *
 */
public class ProUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serialNum = request.getParameter("serialNum");
		String modelName = request.getParameter("modelName");
		String company = request.getParameter("company");
		String price = request.getParameter("price");
		String ram = request.getParameter("ram");
		String cpu = request.getParameter("cpu");
		String noteSize = request.getParameter("noteSize");
		String noteWeight = request.getParameter("noteWeight");
		String stock = request.getParameter("stock");
		
		if(serialNum == null || serialNum.equals("") || modelName == null || modelName.equals("") || company == null || company.equals("") || price == null || price.equals("")
				|| ram == null || ram.equals("") || cpu == null || cpu.equals("") || noteSize == null || noteSize.equals("") || noteWeight == null || noteWeight.equals("")
				|| stock == null || stock.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		Product product = new Product(serialNum, modelName, company, Integer.parseInt(price), Integer.parseInt(ram), cpu,Integer.parseInt(noteSize), Double.parseDouble(noteWeight)
				, Integer.parseInt(stock), null, null);
		ProductService.update(product);
		ModelAndView mv = new ModelAndView(false, "관리자 페이지");
		return mv;
	}

}

package notebook.controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;

/**
 * 관리자 상품 등록
 * @author kosta
 *
 */
public class ProInsertController implements Controller {

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
		String launchDate = request.getParameter("launchDate");
		String stock = request.getParameter("stock");
		String grade = request.getParameter("grade");
		String descriptionImgName = request.getParameter("descriptionImgName");
		String imgName = request.getParameter("imgName");
		
		if(serialNum == null || serialNum.equals("") || modelName == null || modelName.equals("") || company == null || company.equals("") || price == null || price.equals("")
				|| ram == null || ram.equals("") || cpu == null || cpu.equals("") || noteSize == null || noteSize.equals("") || noteWeight == null || noteWeight.equals("")
				|| launchDate == null || launchDate.equals("") || stock == null || stock.equals("") || grade == null || grade.equals("") || descriptionImgName == null 
				|| descriptionImgName.equals("") || imgName == null || imgName.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		ModelAndView mv = new ModelAndView(false, "관리자 페이지");
		
		return mv;
	}
}

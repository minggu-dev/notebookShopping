package notebook.controller.product;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardReview;
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
		
		Map<String, Object> map = ProductService.selectBySerialNum(serialNum);
		request.setAttribute("product", (Product)map.get("product"));
		request.setAttribute("review", (List<BoardReview>)map.get("boardReview"));
		
		PrintWriter out = response.getWriter();
		out.print(((Product)map.get("product")).getSerialNum());
		
		List<BoardReview> list = (List<BoardReview>)map.get("boardReview");
		out.println(list.size());
		for(BoardReview re : list) {
			out.print(re.getContent());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("상품 상세보기 페이지");
		return mv;
	}
}
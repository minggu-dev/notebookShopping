package notebook.controller.review;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardReview;
import notebook.exception.NotFoundException;
import notebook.service.ReviewService;

public class ReviewSelectProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//String sql = "select * from board_review where serialnum=?";
		
			String serialNum = request.getParameter("serialNum");
			List<BoardReview> list = ReviewService.select(serialNum);
			request.setAttribute("list", list);
			
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reviewSelectBySerialNum");
		return mv;
		

	}

}

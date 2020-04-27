package notebook.controller.review;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardReview;
import notebook.exception.CannotModifyException;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ReviewService;

public class ReviewUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");
		String reviewNo = request.getParameter("reviewNo");
		String userId = request.getParameter("userId");
		String serialNum = request.getParameter("serialNum");
		String grade = request.getParameter("grade");
		
		if(userId == null || userId.equals("") || serialNum == null || serialNum.equals("")
				|| grade==null || grade.equals("") ) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		BoardReview review = new BoardReview(Integer.parseInt(reviewNo), userId, null, content, serialNum, Integer.parseInt(grade) );
		ReviewService.update(review);
		
		ModelAndView mv = new ModelAndView(true, "리뷰보는곳 이동");
		
		
		return mv;
		
	
	}

	
}

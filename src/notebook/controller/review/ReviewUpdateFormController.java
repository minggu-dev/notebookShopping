package notebook.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardReview;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ReviewService;

public class ReviewUpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String serialNum = request.getParameter("serialNum");
		if(userId == null || userId.equals("") || serialNum == null || serialNum.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		//수정해야함
		BoardReview review = ReviewService.
		
		return null;
	}

}

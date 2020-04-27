package notebook.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardReview;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ReviewService;

/**
 * 수정 폼으로 이동하기
 * @author kosta
 *
 */
public class ReviewUpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String reviewNo = request.getParameter("reviewNo");
		if(userId == null || userId.equals("") || reviewNo == null || reviewNo.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		BoardReview review = ReviewService.selectByNo(Integer.parseInt(reviewNo));
		request.setAttribute("review", review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("후기들 보기?");
		
		return mv;
	}

}

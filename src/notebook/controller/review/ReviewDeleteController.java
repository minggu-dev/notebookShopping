package notebook.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import java.io.File;
import java.util.List;
import notebook.domain.BoardReview;
import notebook.exception.CannotModifyException;
import notebook.service.ReviewService;

public class ReviewDeleteController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String path = request.getServletContext().getRealPath("/save");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo")); //?????
		
		
		String url = "reviewselect";
		try {
			boolean bFind = false;
			List<BoardReview> ls = ReviewService.searchByUserId(userId);
			for(BoardReview br : ls) {
				if(br.getReviewNo() == reviewNo) {
					bFind = true;
					ReviewService.delete(reviewNo);
					// 실제 파일 지우기.
					String fName = br.getImgName();
					if(fName != null)
						new File(path, fName).delete();
					break;
				}
			}
			
			if(!bFind) {
				throw new CannotModifyException("해당 리뷰는 다른 작성자의 리뷰 입니다.");
			}
			
		}catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName(url);
		
		return mv;
	}
}

    

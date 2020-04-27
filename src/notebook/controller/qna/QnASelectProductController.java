package notebook.controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.dao.BoardReviewDao;
import notebook.dao.BoardReviewDaoImpl;
import notebook.domain.BoardQnA;
import notebook.domain.BoardReview;
import notebook.exception.NotFoundException;
import notebook.service.QnAService;

public class QnASelectProductController implements Controller {
	
	/**
	 * 상품상세보기에서 qna게시판 눌렀을 때
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serialNum = request.getParameter("serialNum");
		
		if(serialNum == null || serialNum.equals("")) {
			throw new NotFoundException("입력값이 충분하지 않습니다.");
		}
		
		List<BoardQnA> list = QnAService.selectBySerialNum(serialNum);
		request.setAttribute("list", list);
		//상품별 후기 게시판보기
		BoardReviewDao review = new BoardReviewDaoImpl();
		List<BoardReview> reviewlist = review.selectBySerialNum(serialNum);
		request.setAttribute("reviewlist", reviewlist);
		//후기 게시물 쓰러가기
		//review.insert(review);
		
		ModelAndView mv = new ModelAndView(false, "");
		return mv;
	}

}

package notebook.controller.ans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardAnswer;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.AnswerService;

public class AnsInsertController implements Controller {
	
	/**
	 * 답변 달기_qnaNo, content _ 답변상태 1로 변경.
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		String content = request.getParameter("content");
		String userId = request.getParameter("userId");
		
		if(qnaNo == null || qnaNo.equals("") || content == null || content.equals("") || userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}

		if(userId.equals("admin")) {
			throw new NotFoundException("관리자만 가능합니다.");
		}
		BoardAnswer board = new BoardAnswer();
		board.setQnaNo(Integer.parseInt(qnaNo));
		board.setContent(content);
		AnswerService.insert(board);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		//qnaNo으로 게시물 상세보기로 이동
		mv.setViewName("");
		return mv;
	}

}
package notebook.controller.ans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardAnswer;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.AnswerService;

public class AnsUpdateController implements Controller {
	
	/**
	 * 게시물답변 수정하기_content
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");//수정할 내용
		String ansNo = request.getParameter("ansNo");//수정할 답변게시물 번호
		String qnaNo = request.getParameter("qnaNo");
		String userId = request.getParameter("userId");
		if(content == null || content.equals("") || ansNo == null || ansNo.equals("") || qnaNo == null || qnaNo.equals("") || userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}

		if(userId.equals("admin")) {
			throw new NotFoundException("관리자만 가능합니다.");
		}
		BoardAnswer ans = new BoardAnswer();
		ans.setAnsNo(Integer.parseInt(ansNo));
		ans.setContent(content);
		AnswerService.update(ans);//답변 수정
		
		ModelAndView mv = new ModelAndView();
		//게시물 상세보기로
		mv.setViewName("");
		return mv;
	}

}



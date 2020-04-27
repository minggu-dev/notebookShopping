package notebook.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardQnA;
import notebook.exception.NotEnoughParameterException;
import notebook.service.QnAService;

public class QnAUpdateFormController implements Controller {
	
	/**
	 * 수정하기 버튼 누르면 폼으로 이동
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		if(qnaNo == null || qnaNo.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		String flag = request.getParameter("flag");
		boolean state = flag == null ? false : true;
		
		BoardQnA board = QnAService.selectByNo(Integer.parseInt(qnaNo), state);
		
		request.setAttribute("board", board);
		ModelAndView mv = new ModelAndView(false, "");//게시물 수정하기.jsp
		return mv;
		
	}

}


package notebook.controller.ans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.AnswerService;

public class AnsDeleteController implements Controller {
	
	/**
	 * 답변 삭제
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ansNo = request.getParameter("ansNo");//삭제할 답변 게시물 번호
		String qnaNo = request.getParameter("qnaNo");
		String userId = request.getParameter("userId");
		if(ansNo == null || ansNo.equals("") || qnaNo == null || qnaNo.equals("") || userId==null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		if(userId.equals("admin")) {
			throw new NotFoundException("관리자만 가능합니다.");
		}
		AnswerService.delete(Integer.parseInt(ansNo), Integer.parseInt(qnaNo));
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		
		//qnaNo가지고 가야한다
		mv.setViewName("게시물 상세보기");
		return mv;
	}

}




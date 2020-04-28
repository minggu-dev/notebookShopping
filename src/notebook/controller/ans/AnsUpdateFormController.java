package notebook.controller.ans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardAnswer;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.AnswerService;

public class AnsUpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ansNo = request.getParameter("ansNo");
		String userId = (String)request.getSession().getAttribute("id");
		
		if(ansNo == null || ansNo.equals("") || userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}

		if(userId.equals("admin")) {
			throw new NotFoundException("관리자만 가능합니다.");
		}
		
		BoardAnswer answer = AnswerService.selectByNo(Integer.parseInt(ansNo));
		request.setAttribute("answer", answer);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("답변 수정 폼으로 이동");
		
		return mv;
	}

}

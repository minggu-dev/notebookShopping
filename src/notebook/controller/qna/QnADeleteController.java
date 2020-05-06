package notebook.controller.qna;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.QnAService;;

public class QnADeleteController implements Controller {

	/**
	 * 게시물 삭제.
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		String userId = (String)request.getSession().getAttribute("id");
		if(qnaNo == null || qnaNo.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		ModelAndView mv = new ModelAndView();
		if(userId.equals("admin")) {
			QnAService.admindelete(Integer.parseInt(qnaNo));
			mv.setRedirect(true);
			mv.setViewName("note?command=qnaAll");
		}else {
			QnAService.delete(Integer.parseInt(qnaNo), userId);
			mv.setRedirect(true);//true 이면 Redirect로 간다.
			mv.setViewName("qnaList.jsp");//이동할 url
		}
		
		return mv;
	}

}
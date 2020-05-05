package notebook.controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardQnA;
import notebook.service.QnAService;


public class QnASelectAllController implements Controller {
	//qna게시판 들어갈 때 / 관리자 / 모든게시판 정보 보여주기

	/**
	 * 모든 게시판 내역 보여주기 
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List<BoardQnA> list = QnAService.selectAll();
			
			request.setAttribute("list", list);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("qnaList.jsp");
			return mv;
		
	}
	
	

}

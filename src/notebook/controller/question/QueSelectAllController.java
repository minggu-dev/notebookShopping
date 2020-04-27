package notebook.controller.question;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Questions;
import notebook.exception.NotFoundException;
import notebook.service.QuestionsService;

public class QueSelectAllController implements Controller {
	

	/**
	 * 회원가입시 질문들 보여주기
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				List<Questions> list = QuestionsService.selectAll();
				request.setAttribute("list", list);
				
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Questions selectAll");
			return mv;
			
	}

}

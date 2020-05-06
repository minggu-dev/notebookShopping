package notebook.controller.ans;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardAnswer;
import notebook.service.AnswerService;

public class AnsSelectController implements Controller{


		/**
		 * 게시물 답글 상세보기
		 */
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String qnaNo = request.getParameter("qnaNo");
			List<BoardAnswer> list = AnswerService.selectByQnaNo(Integer.parseInt(qnaNo));
			request.setAttribute("list", list);
			JSONArray jsonObj = JSONArray.fromObject(list);
			request.setAttribute("jsonObj", jsonObj);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("qnaReadAdmin.jsp");
			return mv;
		}
}
package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 유저 핸드폰으로 아이디 찾기 -> 질문 가져오기
 * @author 김민호
 *
 */
public class UserIdQuestionFindController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		if(phone == null||phone.equals("") || name == null || name.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		Users user = UserService.selectByPhoneName(phone, name);
		String question = user.getQuestion().getQuestion();
		//핸드폰 번호랑 답변으로 찾아오자
		request.setAttribute("question", question);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("질문 답변 창으로");
		return mv;
	}
}

package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 폰번호랑 아이디로 질문 가져오기
 * @author 김민호
 *
 */
public class UserPwdQuestionFindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String phone = request.getParameter("phone");
		if(userId == null || userId.equals("") || phone == null || phone.equals("") || name ==null ||name.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		Users user = UserService.selectByIdPhoneName(userId, phone, name);
		String question = user.getQuestion().getQuestion();
		request.setAttribute("question", question);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("질문묻기 창으로");
		return mv;
	}

}

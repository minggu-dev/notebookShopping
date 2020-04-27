package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 유저의 핸드폰과 질문을 받아서 아이디 찾아오기
 * @author kosta
 *
 */
public class UserIdFindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		String answer = request.getParameter("answer");
		if(phone == null || phone.equals("") || answer == null || answer.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		Users user = UserService.selectByPhoneAns(phone, answer);
		String userId = user.getUserId();
		request.setAttribute("userId", userId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("로그인 창으로");
		return mv;
	}

}

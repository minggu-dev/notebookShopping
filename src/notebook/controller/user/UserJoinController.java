package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Questions;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.user.UserService;

/**
 * 회원가입
 * @author kosta
 *
 */
public class UserJoinController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String answer = request.getParameter("answer");
		String queNo = request.getParameter("queNo");
		String question = request.getParameter("question");
		
		if(userId == null || userId.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("") || addr == null 
				|| addr.equals("") || phone == null || phone.equals("") || answer == null || answer.equals("") || queNo == null
				|| queNo.equals("") || question == null || question.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		ModelAndView mv = new ModelAndView(true, "note");
		Users user = new Users(userId, pwd, name, addr, phone, answer, new Questions(Integer.parseInt(queNo), question));
		
		UserService.insert(user);
		
		return mv;
	}

}
